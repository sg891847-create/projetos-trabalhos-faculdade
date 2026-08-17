import threading
import random
import time

class ThreadFilial(threading.Thread):
    def __init__(self, id_filial, vendas):
        super().__init__()
        self.id_filial = id_filial
        self.vendas = vendas       
        self.total_local = 0.0    
        
    def run(self):
        self.total_local = sum(self.vendas)


def principal():
    #criação das 4 listas de vendas
    random.seed(42)     
    filiais_dados = {
        "Filial 1 (Matriz)": [random.uniform(10.0, 500.0) for _ in range(10000)],
        "Filial 2 (Norte)":  [random.uniform(10.0, 500.0) for _ in range(10000)],
        "Filial 3 (Sul)":    [random.uniform(10.0, 500.0) for _ in range(10000)],
        "Filial 4 (Leste)":  [random.uniform(10.0, 500.0) for _ in range(10000)],
    }

    threads = []
    
    print("Disparando o processamento paralelo das filiais\n")
    tempo_inicio = time.time()

    #FORK
    for nome, lista_vendas in filiais_dados.items():
        t = ThreadFilial(nome, lista_vendas)
        threads.append(t)
        t.start() # Inicia o cálculo

    #aguarda o término de todas as threads
    for t in threads:
        t.join()

    #thread principal coleta os resultados e soma a bagaça toda 
    faturamento_total_anual = 0.0
    
    print("RESULTADOS INDEPENDENTES")
    for t in threads:
        print(f"{t.id_filial}: R$ {t.total_local:,.2f}")
        faturamento_total_anual += t.total_local

    tempo_fim = time.time()

    print("-" * 40)
    print(f"Faturamento Total Anual: R$ {faturamento_total_anual:,.2f}")
    print(f"Tempo de processamento: {tempo_fim - tempo_inicio:.5f} segundos")

if __name__ == "__main__":
    principal()
