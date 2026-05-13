# Importação das bibliotecas necessárias
import pyglet
pyglet.options['shadow_window'] = False
pyglet.window.Window(visible=False)

import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *
from PIL import Image
import math
from pywavefront import Wavefront

# Variáveis globais de posição e rotação da câmera
camera_x, camera_y, camera_z = 0, 1, -8  # Ajuste inicial para ver a cena melhor
yaw, pitch = 0, 0
sensitivity = 0.02
rot_x, rot_y = 0, 0

def update_camera_direction():
    rad_yaw = math.radians(yaw) 
    rad_pitch = math.radians(pitch) 
    dir_x = math.cos(rad_pitch) * math.sin(rad_yaw) 
    dir_y = math.sin(rad_pitch)                      
    dir_z = math.cos(rad_pitch) * math.cos(rad_yaw) 
    return dir_x, dir_y, dir_z 

def load_texture(filename):
    try:
        img = Image.open(filename) 
        img = img.transpose(Image.FLIP_TOP_BOTTOM) 
        img_data = img.convert("RGBA").tobytes() 
        width, height = img.size 
        tex_id = glGenTextures(1) 
        glBindTexture(GL_TEXTURE_2D, tex_id) 
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, img_data) 
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR) 
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR) 
        return tex_id 
    except:
        return None

def draw_textured_cube():
    glBegin(GL_QUADS)
    # Lista de coordenadas de textura e vértices simplificada
    faces = [
        (0,1,2,3), (4,5,6,7), (0,1,5,4), (3,2,6,7), (1,2,6,5), (0,3,7,4)
    ]
    for face in faces:
        glTexCoord2f(0,0); glVertex3fv(cube_vertices[face[0]])
        glTexCoord2f(1,0); glVertex3fv(cube_vertices[face[1]])
        glTexCoord2f(1,1); glVertex3fv(cube_vertices[face[2]])
        glTexCoord2f(0,1); glVertex3fv(cube_vertices[face[3]])
    glEnd()

cube_vertices = [
    (-1, -1, -1), ( 1, -1, -1), ( 1,  1, -1), (-1,  1, -1),
    (-1, -1,  1), ( 1, -1,  1), ( 1,  1,  1), (-1,  1,  1) 
]

def draw_obj_model(scene, tex_id):
    glEnable(GL_TEXTURE_2D) 
    glBindTexture(GL_TEXTURE_2D, tex_id) 
    for mat in scene.materials.values(): 
        verts = mat.vertices  
        count = len(verts) // 8 
        array_type = (GLfloat * len(verts))(*verts) 
        glEnableClientState(GL_VERTEX_ARRAY) 
        glEnableClientState(GL_NORMAL_ARRAY) 
        glEnableClientState(GL_TEXTURE_COORD_ARRAY) 
        glInterleavedArrays(GL_T2F_N3F_V3F, 0, array_type) 
        glDrawArrays(GL_TRIANGLES, 0, count) 
        glDisableClientState(GL_TEXTURE_COORD_ARRAY) 
        glDisableClientState(GL_NORMAL_ARRAY)
        glDisableClientState(GL_VERTEX_ARRAY)

def init_opengl(display):
    glEnable(GL_DEPTH_TEST) 
    glEnable(GL_TEXTURE_2D) 
    glEnable(GL_LIGHTING) 
    glEnable(GL_LIGHT0) 
    # REQUISITO: Modificação da posição da luz
    glLightfv(GL_LIGHT0, GL_POSITION, (5, 10, 2, 1)) 
    glMatrixMode(GL_PROJECTION) 
    glLoadIdentity() 
    gluPerspective(45, (display[0] / display[1]), 0.1, 50.0) 
    glMatrixMode(GL_MODELVIEW)

def main():
    global camera_x, camera_y, camera_z, yaw, pitch, rot_x, rot_y 
    pygame.init() 
    display = (800, 600) 
    pygame.display.set_mode(display, DOUBLEBUF | OPENGL) 
    pygame.event.set_grab(True) 
    pygame.mouse.set_visible(False) 

    init_opengl(display) 

    # CARREGAMENTO DE TEXTURAS
    tex_caixa = load_texture("textura.jpg")
    tex_grama = load_texture("grama.jpg")    # Para o chão
    tex_tijolo = load_texture("tijolo.jpg")  # Para a parede
    tex_madeira = load_texture("madeira.jpg")# Para o totem
    
    cat_tex = load_texture("OBJS/Cat/Cat_diffuse.jpg")
    trex_tex = load_texture("OBJS/T-Rex/GRANDEB2.JPG")

    # CARREGAMENTO DE MODELOS
    cat_scene = Wavefront('OBJS/Cat/Cat.obj', collect_faces=True, parse=True) 
    trex_scene = Wavefront('OBJS/T-Rex/T-Rex Model.obj', collect_faces=True, parse=True) 
    wolf_scene = Wavefront('OBJS/Lobo/LowPolyWolf.obj', collect_faces=True, parse=True) 

    clock = pygame.time.Clock() 
    running = True 

    while running:
        clock.tick(60) 
        for event in pygame.event.get(): 
            if event.type == QUIT: running = False
            if event.type == KEYDOWN and event.key == K_ESCAPE: running = False

        dx, dy = pygame.mouse.get_rel() 
        yaw += dx * sensitivity     
        pitch += dy * sensitivity   
        dir_x, dir_y, dir_z = update_camera_direction()

        keys = pygame.key.get_pressed() 
        if keys[K_w]: camera_x += dir_x * 0.2; camera_y += dir_y * 0.2; camera_z += dir_z * 0.2
        if keys[K_s]: camera_x -= dir_x * 0.2; camera_y -= dir_y * 0.2; camera_z -= dir_z * 0.2
        
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        glLoadIdentity() 
        gluLookAt(camera_x, camera_y, camera_z, camera_x + dir_x, camera_y + dir_y, camera_z + dir_z, 0, 1, 0)

        # --- PARTE I: CONSTRUÇÃO DO AMBIENTE ---
        
        # 1. CHÃO (Cubo achatado)
        glBindTexture(GL_TEXTURE_2D, tex_grama)
        glPushMatrix()
        glTranslatef(0, -2.1, 0)
        glScalef(15, 0.1, 15)
        draw_textured_cube()
        glPopMatrix()

        # 2. PAREDE AO FUNDO
        glBindTexture(GL_TEXTURE_2D, tex_tijolo)
        glPushMatrix()
        glTranslatef(0, 2, 10)
        glScalef(10, 4, 0.2)
        draw_textured_cube()
        glPopMatrix()

        # 3. TOTEM (Pilha de cubos)
        glBindTexture(GL_TEXTURE_2D, tex_madeira)
        for i in range(3):
            glPushMatrix()
            glTranslatef(-6, (i * 2) - 1, 0)
            draw_textured_cube()
            glPopMatrix()

        # 4. CUBO PRINCIPAL (Original)
        glBindTexture(GL_TEXTURE_2D, tex_caixa)
        glPushMatrix()
        glTranslatef(0, -1, -4)
        draw_textured_cube()
        glPopMatrix()

        # --- PARTE II: MODELOS 3D ---
        
        # Gato (Centro)
        glPushMatrix()
        glTranslatef(0, -2, 0); glRotatef(180, 0, 1, 0); glRotatef(-90, 1, 0, 0); glScalef(0.02, 0.02, 0.02)
        draw_obj_model(cat_scene, cat_tex)
        glPopMatrix()

        # T-Rex (Direita)
        glPushMatrix()
        glTranslatef(4, -2, 0); glRotatef(-90, 1, 0, 0); glScalef(0.01, 0.01, 0.01)
        draw_obj_model(trex_scene, trex_tex)
        glPopMatrix()

        # Lobo (Esquerda)
        glPushMatrix()
        glTranslatef(-3, -2, 3); glRotatef(-90, 1, 0, 0); glScalef(1.5, 1.5, 1.5)
        draw_obj_model(wolf_scene, tex_caixa) # Usando textura padrão para o lobo
        glPopMatrix()

        pygame.display.flip() 

    pygame.quit() 

if __name__ == "__main__":
    main()