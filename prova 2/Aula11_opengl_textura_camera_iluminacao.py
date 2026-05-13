import pyglet
pyglet.options['shadow_window'] = False
pyglet.window.Window(visible=False)

import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *
from PIL import Image
import math
import os
from pywavefront import Wavefront

# CONFIGURAÇÕES DO CENÁRIO 
camera_x, camera_y, camera_z = 29, 4.0, 0 
yaw, pitch = -90, -5
sensitivity = 0.1 
SIZE = 30   
HEIGHT = 10 

def load_texture(filename):
    if not os.path.exists(filename):
        print(f"AVISO: Arquivo nao encontrado -> {filename}")
        return None
    try:
        img = Image.open(filename)
        img = img.transpose(Image.FLIP_TOP_BOTTOM)
        img_data = img.convert("RGBA").tobytes()
        width, height = img.size
        tex_id = glGenTextures(1)
        glBindTexture(GL_TEXTURE_2D, tex_id)
        
        # Mantido em REPEAT conforme solicitado anteriormente
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT)
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT)
        
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, img_data)
        return tex_id
    except Exception as e:
        print(f"Falha ao carregar {filename}: {e}")
        return None

def draw_floor(tex_id):
    glEnable(GL_TEXTURE_2D)
    glBindTexture(GL_TEXTURE_2D, tex_id if tex_id else 0)
    glBegin(GL_QUADS)
    glColor3f(1, 1, 1)
    glTexCoord2f(0, 0); glVertex3f(-SIZE, 0, -SIZE)
    glTexCoord2f(10, 0); glVertex3f(SIZE, 0, -SIZE)
    glTexCoord2f(10, 10); glVertex3f(SIZE, 0, SIZE)
    glTexCoord2f(0, 10); glVertex3f(-SIZE, 0, SIZE)
    glEnd()

def draw_walls(tex_id):
    glEnable(GL_TEXTURE_2D)
    glBindTexture(GL_TEXTURE_2D, tex_id if tex_id else 0)
    glBegin(GL_QUADS)
    # Fundo
    glTexCoord2f(0, 0); glVertex3f(-SIZE, 0, -SIZE)
    glTexCoord2f(5, 0); glVertex3f(SIZE, 0, -SIZE)
    glTexCoord2f(5, 1); glVertex3f(SIZE, HEIGHT, -SIZE)
    glTexCoord2f(0, 1); glVertex3f(-SIZE, HEIGHT, -SIZE)
    # Frente
    glTexCoord2f(0, 0); glVertex3f(-SIZE, 0, SIZE)
    glTexCoord2f(5, 0); glVertex3f(SIZE, 0, SIZE)
    glTexCoord2f(5, 1); glVertex3f(SIZE, HEIGHT, SIZE)
    glTexCoord2f(0, 1); glVertex3f(-SIZE, HEIGHT, SIZE)
    # Esquerda
    glTexCoord2f(0, 0); glVertex3f(-SIZE, 0, SIZE)
    glTexCoord2f(5, 0); glVertex3f(-SIZE, 0, -SIZE)
    glTexCoord2f(5, 1); glVertex3f(-SIZE, HEIGHT, -SIZE)
    glTexCoord2f(0, 1); glVertex3f(-SIZE, HEIGHT, SIZE)
    # Direita
    glTexCoord2f(0, 0); glVertex3f(SIZE, 0, -SIZE)
    glTexCoord2f(5, 0); glVertex3f(SIZE, 0, SIZE)
    glTexCoord2f(5, 1); glVertex3f(SIZE, HEIGHT, SIZE)
    glTexCoord2f(0, 1); glVertex3f(SIZE, HEIGHT, -SIZE)
    glEnd()

def draw_obj_model(scene, textures_dict, default_tex=None):
    glEnable(GL_TEXTURE_2D)
    for name, mat in scene.materials.items():
        tex = textures_dict.get(name, default_tex)
        glBindTexture(GL_TEXTURE_2D, tex if tex else 0)
        verts = mat.vertices
        glEnableClientState(GL_VERTEX_ARRAY)
        glEnableClientState(GL_NORMAL_ARRAY)
        glEnableClientState(GL_TEXTURE_COORD_ARRAY)
        glInterleavedArrays(GL_T2F_N3F_V3F, 0, (GLfloat * len(verts))(*verts)) 
        glDrawArrays(GL_TRIANGLES, 0, len(verts) // 8)
        glDisableClientState(GL_TEXTURE_COORD_ARRAY)
        glDisableClientState(GL_NORMAL_ARRAY)
        glDisableClientState(GL_VERTEX_ARRAY)

def update_camera():
    rad_yaw, rad_pitch = math.radians(yaw), math.radians(pitch)
    return (math.sin(rad_yaw) * math.cos(rad_pitch), math.sin(rad_pitch), -math.cos(rad_yaw) * math.cos(rad_pitch))

def main():
    global camera_x, camera_y, camera_z, yaw, pitch
    pygame.init()
    pygame.display.set_mode((800, 600), DOUBLEBUF | OPENGL)
    pygame.event.set_grab(True)
    pygame.mouse.set_visible(False)

    glEnable(GL_DEPTH_TEST)
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    
    glMatrixMode(GL_PROJECTION)
    gluPerspective(45, 800/600, 0.1, 200.0)
    glMatrixMode(GL_MODELVIEW)

    # --- CARREGAMENTO DE ATIVOS ---
    tex_grama = load_texture("grama.jpg")
    tex_tijolo = load_texture("tijolo.jpg")
    
    # GATO
    cat_tex = load_texture("OBJS/Cat/Cat_diffuse.jpg")
    cat_scene = Wavefront('OBJS/Cat/Cat.obj', collect_faces=True, parse=True)
    
    # ÁRVORE (LENDO COMO PNG)
    tree_bark = load_texture("OBJS/tree/bark_0004.jpg")
    tree_leaves1 = load_texture("OBJS/tree/DB2X2_L01.png") # Alterado para PNG
    tree_leaves2 = load_texture("OBJS/tree/DB2X2_L02.png") # Alterado para PNG
    tree_scene = Wavefront('OBJS/tree/Tree.obj', collect_faces=True, parse=True)
    
    tree_dict = {
        'Trank_bark': tree_bark, 
        'DB2X2_L01': tree_leaves1, 
        'DB2X2_L02': tree_leaves2
    }

    # T-REX
    trex_body = load_texture("OBJS/T-Rex/GRANDECO.jpg")
    trex_eye = load_texture("OBJS/T-Rex/GRANDEB2.jpg")
    trex_scene = Wavefront('OBJS/T-Rex/T-Rex Model.obj', collect_faces=True, parse=True)
    trex_dict = {'DINOMAT': trex_body, 'DINOOJO': trex_eye}

    clock = pygame.time.Clock()
    while True:
        clock.tick(60)
        for event in pygame.event.get():
            if event.type == QUIT or (event.type == KEYDOWN and event.key == K_ESCAPE):
                pygame.quit(); return

        dx_m, dy_m = pygame.mouse.get_rel()
        yaw += dx_m * sensitivity
        pitch = max(-89, min(89, pitch - dy_m * sensitivity))

        dir_x, dir_y, dir_z = update_camera()
        keys = pygame.key.get_pressed()
        s = 0.5
        if keys[K_w]: camera_x += dir_x*s; camera_y += dir_y*s; camera_z += dir_z*s
        if keys[K_s]: camera_x -= dir_x*s; camera_y -= dir_y*s; camera_z -= dir_z*s

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        glLoadIdentity()
        gluLookAt(camera_x, camera_y, camera_z, camera_x+dir_x, camera_y+dir_y, camera_z+dir_z, 0, 1, 0)

        draw_floor(tex_grama)
        draw_walls(tex_tijolo)

        # 1. T-REX (CENTRALIZADO)
        glPushMatrix()
        glTranslatef(0, 0, 0)
        glScalef(0.025, 0.025, 0.025) 
        draw_obj_model(trex_scene, trex_dict)
        glPopMatrix()

        # 2. GATO
        glPushMatrix()
        glTranslatef(-10, 0.5, 8)
        glRotatef(45, 0, 1, 0); glRotatef(-90, 1, 0, 0); glScalef(0.02, 0.02, 0.02)
        draw_obj_model(cat_scene, {}, cat_tex)
        glPopMatrix()

        # 3. ÁRVORE
        glPushMatrix()
        glTranslatef(15, 0, -10); glScalef(7.0, 7.0, 7.0) 
        draw_obj_model(tree_scene, tree_dict)
        glPopMatrix()
        
        pygame.display.flip()

if __name__ == "__main__":
    main()