import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *

# --- Variáveis Globais de Estado ---
objeto_atual = None

# Posições iniciais dos objetos (usadas para movimentação) [cite: 11]
cube_pos = [-6.0, 0.0]
tri_pos  = [0.0, 0.0]
pyr_pos  = [6.0, 0.0]

# Zoom e rotação da cena (para visualização geral) [cite: 11]
zoom = -15.0
rot_x = 0.0
rot_y = 0.0

def init():
    """Configurações iniciais do OpenGL[cite: 12]."""
    glClearColor(0.0, 0.0, 0.0, 1.0)          # Cor de fundo preta
    glClearDepth(1.0)                         # Profundidade máxima
    glEnable(GL_DEPTH_TEST)                   # Ativa teste de profundidade
    glDepthFunc(GL_LEQUAL)                   # Critério de profundidade
    glMatrixMode(GL_PROJECTION)               # Muda para matriz de projeção
    glLoadIdentity()
    gluPerspective(45.0, 1280.0 / 480.0, 0.1, 100.0)  # Perspectiva 3D
    glMatrixMode(GL_MODELVIEW)                # Volta para matriz de modelagem

def reset_transformations():
    """Reseta posições e transformações dos objetos."""
    global cube_pos, tri_pos, pyr_pos, zoom, rot_x, rot_y
    cube_pos = [-6.0, 0.0]
    tri_pos  = [0.0, 0.0]
    pyr_pos  = [6.0, 0.0]
    zoom = -15.0
    rot_x = 0.0
    rot_y = 0.0

def draw_cube():
    """Renderiza um cubo 3D colorido[cite: 24]."""
    glPushMatrix() # Salva a matriz de transformação atual (Checkpoint)
    glTranslatef(cube_pos[0], cube_pos[1], 0)
    glBegin(GL_QUADS)
    # Face traseira
    glColor3f(1, 0, 0); glVertex3f(1, 1, -1); glVertex3f(-1, 1, -1); glVertex3f(-1, -1, -1); glVertex3f(1, -1, -1)
    # Face frontal
    glColor3f(0, 1, 0); glVertex3f(1, -1, 1); glVertex3f(-1, -1, 1); glVertex3f(-1, 1, 1); glVertex3f(1, 1, 1)
    # Face direita
    glColor3f(0, 0, 1); glVertex3f(1, 1, 1); glVertex3f(1, 1, -1); glVertex3f(1, -1, -1); glVertex3f(1, -1, 1)
    # Face esquerda
    glColor3f(1, 1, 0); glVertex3f(-1, 1, -1); glVertex3f(-1, 1, 1); glVertex3f(-1, -1, 1); glVertex3f(-1, -1, -1)
    # Face superior
    glColor3f(0, 1, 1); glVertex3f(1, 1, 1); glVertex3f(-1, 1, 1); glVertex3f(-1, 1, -1); glVertex3f(1, 1, -1)
    # Face inferior
    glColor3f(1, 0, 1); glVertex3f(1, -1, -1); glVertex3f(-1, -1, -1); glVertex3f(-1, -1, 1); glVertex3f(1, -1, 1)
    glEnd()
    glPopMatrix() # Restaura a matriz original

def draw_triangle():
    """Renderiza um triângulo 2D[cite: 34]."""
    glPushMatrix()
    glTranslatef(tri_pos[0], tri_pos[1], 0)
    glBegin(GL_TRIANGLES)
    glColor3f(1, 1, 0)
    glVertex3f(0, 2, 0)
    glVertex3f(-2, -2, 0)
    glVertex3f(2, -2, 0)
    glEnd()
    glPopMatrix()

def draw_pyramid():
    """Renderiza uma pirâmide 3D com base quadrada[cite: 41]."""
    glPushMatrix()
    glTranslatef(pyr_pos[0], pyr_pos[1], 0)
    # Lados
    glBegin(GL_TRIANGLES)
    glColor3f(1, 0, 0); glVertex3f(0, 1, 0); glVertex3f(-1, -1, 1); glVertex3f(1, -1, 1)
    glColor3f(0, 1, 0); glVertex3f(0, 1, 0); glVertex3f(1, -1, 1); glVertex3f(1, -1, -1)
    glColor3f(0, 0, 1); glVertex3f(0, 1, 0); glVertex3f(1, -1, -1); glVertex3f(-1, -1, -1)
    glColor3f(1, 1, 0); glVertex3f(0, 1, 0); glVertex3f(-1, -1, -1); glVertex3f(-1, -1, 1)
    glEnd()
    # Base
    glBegin(GL_QUADS)
    glColor3f(1, 0, 1); glVertex3f(-1, -1, -1); glVertex3f(1, -1, -1); glVertex3f(1, -1, 1); glVertex3f(-1, -1, 1)
    glEnd()
    glPopMatrix()

def handle_keys():
    """Lê teclas e atualiza estados conforme a opção[cite: 19, 20]."""
    global zoom, rot_x, rot_y, cube_pos, tri_pos, pyr_pos
    keys = pygame.key.get_pressed()

    # Zoom e rotação globais (Z, X, Q, E, R, F) [cite: 28, 29, 30]
    if keys[K_z]: zoom += 0.2
    if keys[K_x]: zoom -= 0.2
    if keys[K_q]: rot_x += 2
    if keys[K_e]: rot_x -= 2
    if keys[K_r]: rot_y += 2
    if keys[K_f]: rot_y -= 2

    # Opções 1, 2 e 4: Movimentação WASD individual [cite: 25, 35, 42]
    if objeto_atual == 1:
        if keys[K_w]: cube_pos[1] += 0.1
        if keys[K_s]: cube_pos[1] -= 0.1
        if keys[K_a]: cube_pos[0] -= 0.1
        if keys[K_d]: cube_pos[0] += 0.1
    elif objeto_atual == 2:
        if keys[K_w]: tri_pos[1] += 0.1
        if keys[K_s]: tri_pos[1] -= 0.1
        if keys[K_a]: tri_pos[0] -= 0.1
        if keys[K_d]: tri_pos[0] += 0.1
    elif objeto_atual == 4:
        if keys[K_w]: pyr_pos[1] += 0.1
        if keys[K_s]: pyr_pos[1] -= 0.1
        if keys[K_a]: pyr_pos[0] -= 0.1
        if keys[K_d]: pyr_pos[0] += 0.1

    # Opções 3 e 5: Movimentação conjunta WASD [cite: 38, 45]
    elif objeto_atual in [3, 5]:
        if keys[K_w]: cube_pos[1]+=0.1; tri_pos[1]+=0.1; pyr_pos[1]+=0.1
        if keys[K_s]: cube_pos[1]-=0.1; tri_pos[1]-=0.1; pyr_pos[1]-=0.1
        if keys[K_a]: cube_pos[0]-=0.1; tri_pos[0]-=0.1; pyr_pos[0]-=0.1
        if keys[K_d]: cube_pos[0]+=0.1; tri_pos[0]+=0.1; pyr_pos[0]+=0.1

    # Opção 6: Controle individual [cite: 50]
    elif objeto_atual == 6:
        # Cubo: I, K, J, L [cite: 54, 55]
        if keys[K_i]: cube_pos[1] += 0.1
        if keys[K_k]: cube_pos[1] -= 0.1
        if keys[K_j]: cube_pos[0] -= 0.1
        if keys[K_l]: cube_pos[0] += 0.1
        # Triângulo: G, B, V, N [cite: 57, 58]
        if keys[K_g]: tri_pos[1] += 0.1
        if keys[K_b]: tri_pos[1] -= 0.1
        if keys[K_v]: tri_pos[0] -= 0.1
        if keys[K_n]: tri_pos[0] += 0.1
        # Pirâmide: Setas [cite: 60, 61]
        if keys[K_UP]:    pyr_pos[1] += 0.1
        if keys[K_DOWN]:  pyr_pos[1] -= 0.1
        if keys[K_LEFT]:  pyr_pos[0] -= 0.1
        if keys[K_RIGHT]: pyr_pos[0] += 0.1

def draw_scene():
    """Renderiza a cena com os objetos escolhidos[cite: 17]."""
    glLoadIdentity()
    glTranslatef(0, 0, zoom)
    glRotatef(rot_x, 1, 0, 0)
    glRotatef(rot_y, 0, 1, 0)

    if objeto_atual == 1:
        draw_cube()
    elif objeto_atual == 2:
        draw_triangle()
    elif objeto_atual == 3:
        draw_cube()
        draw_triangle()
    elif objeto_atual == 4:
        draw_pyramid()
    elif objeto_atual in [5, 6]:
        draw_cube()
        draw_triangle()
        draw_pyramid()

def main():
    global objeto_atual
    print("=== MENU DE FORMAS ===")
    print("1 - Cubo")
    print("2 - Triângulo")
    print("3 - Cubo + Triângulo")
    print("4 - Apenas Pirâmide")
    print("5 - Todos juntos (WASD para todos)")
    print("6 - Todos com controle individual")

    try:
        objeto_atual = int(input("Escolha uma opção: "))
    except ValueError:
        print("Opção inválida!")
        return

    pygame.init()
    pygame.display.set_mode((1280, 480), DOUBLEBUF | OPENGL)
    pygame.display.set_caption("Trabalho 01 - Computação Gráfica")
    init()
    reset_transformations()

    running = True
    while running:
        for event in pygame.event.get():
            if event.type == QUIT or (event.type == KEYDOWN and event.key == K_ESCAPE):
                running = False

        handle_keys()
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        draw_scene()
        pygame.display.flip()
        pygame.time.wait(10)
    pygame.quit()

if __name__ == "__main__":
    main()