from concurrent.futures import ThreadPoolExecutor
import random

def processar_filial(vendas):
    """Função pura: recebe uma lista, calcula e retorna a soma local."""
    return sum(vendas)

def principal_moderno():
    # 1. Dados independentes
    dados_filiais = [
        [random.uniform(10.0, 500.0) for _ in range(10000)]
        for _ in range(4)
    ]

    # 2. Execução com Pool de 4 Threads
    with ThreadPoolExecutor(max_workers=4) as executor:
        # Dispara as 4 funções em paralelo. map() aguarda e coleta os retornos automaticamente
        resultados_locais = list(executor.map(processar_filial, dados_filiais))

    # 3. Junção final dos resultados na thread principal
    faturamento_total = sum(resultados_locais)

    for i, subtotal in enumerate(resultados_locais, 1):
        print(f"Filial {i}: R$ {subtotal:,.2f}")

    print("-" * 40)
    print(f"Faturamento Total Anual: R$ {faturamento_total:,.2f}")

if __name__ == "__main__":
    principal_moderno()