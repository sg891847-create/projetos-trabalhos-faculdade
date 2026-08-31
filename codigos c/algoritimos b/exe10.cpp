#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct Venda {
    string produto;
    int quantidade;
    float valor_unitario;
    string data; // Formato YYYY-MM-DD ou DD/MM/YYYY
};

void cadastrarVendaEGravar() {
    Venda v;
    cout << "Produto: ";
    cin.ignore();
    getline(cin, v.produto);
    cout << "Quantidade: ";
    cin >> v.quantidade;
    cout << "Valor Unitário: R$ ";
    cin >> v.valor_unitario;
    cout << "Data (DD/MM/AAAA): ";
    cin >> v.data;

    ofstream arq("vendas.txt", ios::app); // ios::app adiciona ao final sem apagar
    arq << v.produto << ";" << v.quantidade << ";" << v.valor_unitario << ";" << v.data << endl;
    arq.close();
}

vector<Venda> lerVendas() {
    vector<Venda> vendas;
    ifstream arq("vendas.txt");
    if (!arq.is_open()) return vendas;

    string linha;
    while (getline(arq, linha)) {
        size_t p1 = linha.find(';');
        size_t p2 = linha.find(';', p1 + 1);
        size_t p3 = linha.rfind(';');

        Venda v;
        v.produto = linha.substr(0, p1);
        v.quantidade = stoi(linha.substr(p1 + 1, p2 - p1 - 1));
        v.valor_unitario = stof(linha.substr(p2 + 1, p3 - p2 - 1));
        v.data = linha.substr(p3 + 1);
        vendas.push_back(v);
    }
    arq.close();
    return vendas;
}

void exibirTodasVendas(const vector<Venda>& vendas) {
    cout << "\n=== HISTÓRICO DE VENDAS ===" << endl;
    for (const auto& v : vendas) {
        cout << "Data: " << v.data << " | Produto: " << v.produto 
             << " | Qtd: " << v.quantidade << " | Unit: R$ " << v.valor_unitario 
             << " | Total: R$ " << (v.quantidade * v.valor_unitario) << endl;
    }
}

float calcularTotalPorDia(const vector<Venda>& vendas, const string& dataFiltro) {
    float totalDia = 0;
    for (const auto& v : vendas) {
        if (v.data == dataFiltro) {
            totalDia += v.quantidade * v.valor_unitario;
        }
    }
    return totalDia;
}

void gerarRelatorioGeral(const vector<Venda>& vendas) {
    float totalGeral = 0;
    for (const auto& v : vendas) {
        totalGeral += v.quantidade * v.valor_unitario;
    }
    float media = vendas.empty() ? 0 : totalGeral / vendas.size();

    cout << "\n=== RELATÓRIO GERAL DE VENDAS ===" << endl;
    cout << "Quantidade de vendas registradas: " << vendas.size() << endl;
    cout << "Faturamento Total: R$ " << totalGeral << endl;
    cout << "Média por Venda: R$ " << media << endl;
}

int main() {
    cadastrarVendaEGravar();
    
    vector<Venda> vendas = lerVendas();
    exibirTodasVendas(vendas);
    
    string dataBusca;
    cout << "\nDigite uma data para calcular o total vendido (ex: 20/10/2026): ";
    cin >> dataBusca;
    cout << "Total vendido em " << dataBusca << ": R$ " << calcularTotalPorDia(vendas, dataBusca) << endl;

    gerarRelatorioGeral(vendas);

    return 0;
}