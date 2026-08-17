import threading
import time

# 1. Variável global compartilhada entre todas as threads
saldo_central = 0.0

# 2. Criação do objeto de trava (Lock) para exclusão mútua
trava_saldo = threading.Lock()

def caixa_vendedor(id_caixa):
    global saldo_central
    valor_ficha = 10.00
    total_fichas = 1000

    for _ in range(total_fichas):
        # --- SEÇÃO CRÍTICA ---
        # Garante que apenas UMA thread por vez altere o saldo_central
        with trava_saldo:
            saldo_central += valor_ficha
        # ---------------------

def principal():
    threads = []
    num_caixas = 5

    print("Iniciando as vendas nos caixas...")
    tempo_inicio = time.time()

    # 3. Criação e inicialização das 5 threads
    for i in range(1, num_caixas + 1):
        # Instancia a thread apontando para a função caixa_vendedor
        t = threading.Thread(target=caixa_vendedor, args=(i,))
        threads.append(t)
        t.start()  # Inicia a execução concorrente

    # 4. Sincronização de término das threads
    for t in threads:
        t.join()  # Faz o programa principal esperar cada thread terminar

    tempo_fim = time.time()

    # 5. Exibição dos resultados
    print("-" * 40)
    print(f"Vendas finalizadas em {tempo_fim - tempo_inicio:.4f} segundos.")
    print(f"Saldo final em conta: R$ {saldo_central:,.2f}")
    
    # Validação do resultado esperado (R$ 50.000,00)
    saldo_esperado = num_caixas * 1000 * 10.00
    if saldo_central == saldo_esperado:
        print("SUCESSO: O saldo está perfeitamente consistente!")
    else:
        print("ERRO: Ocorreu uma condição de corrida!")

if __name__ == "__main__":
    principal()