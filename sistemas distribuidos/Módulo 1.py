import threading
import time

saldo_central = 0.0
trava_saldo = threading.Lock()

def caixa_vendedor(id_caixa):
    global saldo_central
    valor_ficha = 10.00
    total_fichas = 1000

    for _ in range(total_fichas):
        #seção crítica
        with trava_saldo:
            saldo_central += valor_ficha
            
def principal():
    threads = []
    num_caixas = 5

    print("Iniciando as vendas nos caixas...")
    tempo_inicio = time.time()

        #criação e inicializa as 5 threads
    for i in range(1, num_caixas + 1):
        t = threading.Thread(target=caixa_vendedor, args=(i,))
        threads.append(t)
        t.start()  
    #sincronização de término das threads
    for t in threads:
        t.join() 
        
    tempo_fim = time.time()

    #exibição dos resultados
    print("-" * 40)
    print(f"Vendas finalizadas em {tempo_fim - tempo_inicio:.4f} segundos.")
    print(f"Saldo final em conta: R$ {saldo_central:,.2f}")
    
    #validação 
    saldo_esperado = num_caixas * 1000 * 10.00
    if saldo_central == saldo_esperado:
        print("SUCESSO: O saldo está perfeitamente consistente!")
    else:
        print("ERRO: Ocorreu uma condição de corrida!")

if __name__ == "__main__":
    principal()
