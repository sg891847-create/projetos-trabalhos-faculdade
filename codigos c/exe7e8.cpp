#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

struct Produto {
    int codigo;
    string descricao;
    float preco;
    int quantidade;
};

// Exercício 6: Funções de Produto
void cadastrar(Produto vet[], int n) {
    for (int i = 0; i < n; i++) {
        cout << "\n--- Produto " << i + 1 << " ---" << endl;
        cout << "Código: ";
        cin >> vet[i].codigo;
        cout << "Descrição: ";
        cin.ignore();
        getline(cin, vet[i].descricao);
        cout << "Preço: R$ ";
        cin >> vet[i].preco;
        cout << "Quantidade: ";
        cin >> vet[i].quantidade;
    }
}

void listar(const Produto vet[], int n) {
    cout << "\n=== Estudo de Estoque ===" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Cód: " << vet[i].codigo 
             << " | Item: " << vet[i].descricao 
             << " | Preço: R$ " << vet[i].preco 
             << " | Qtd: " << vet[i].quantidade << endl;
    }
}

float calcularTotal(const Produto vet[], int n) {
    float total = 0;
    for (int i = 0; i < n; i++) {
        total += vet[i].preco * vet[i].quantidade;
    }
    return total;
}

void salvarEstoque(const Produto vet[], int n) {
    ofstream arq("estoque.txt");
    for (int i = 0; i < n; i++) {
        arq << vet[i].codigo << ";" << vet[i].descricao << ";" << vet[i].preco << ";" << vet[i].quantidade << endl;
    }
    arq.close();
}

// Exercício 7: Atualizar quantidade em arquivo
void atualizarQuantidadeEmArquivo(int codigo, int novaQtd) {
    ifstream arqLeitura("estoque.txt");
    if (!arqLeitura.is_open()) return;

    vector<Produto> produtos;
    string linha;
    
    // Ler arquivo
    while (getline(arqLeitura, linha)) {
        size_t p1 = linha.find(';');
        size_t p2 = linha.find(';', p1 + 1);
        size_t p3 = linha.rfind(';');

        Produto p;
        p.codigo = stoi(linha.substr(0, p1));
        p.descricao = linha.substr(p1 + 1, p2 - p1 - 1);
        p.preco = stof(linha.substr(p2 + 1, p3 - p2 - 1));
        p.quantidade = stoi(linha.substr(p3 + 1));

        if (p.codigo == codigo) {
            p.quantidade = novaQtd; // Atualiza
        }
        produtos.push_back(p);
    }
    arqLeitura.close();

    // Sobreescrever arquivo atualizado
    ofstream arqEscrita("estoque.txt");
    for (const auto& p : produtos) {
        arqEscrita << p.codigo << ";" << p.descricao << ";" << p.preco << ";" << p.quantidade << endl;
    }
    arqEscrita.close();
    cout << "\nQuantidade do código " << codigo << " atualizada no arquivo com sucesso!" << endl;
}

int main() {
    int n = 2; // Exemplo simplificado para 2 produtos
    Produto produtos[2];

    cadastrar(produtos, n);
    listar(produtos, n);
    cout << "\nValor total em estoque: R$ " << calcularTotal(produtos, n) << endl;
    salvarEstoque(produtos, n);

    // Exercício 7
    int cod, novaQtd;
    cout << "\nDigite o código do produto para atualizar no arquivo: ";
    cin >> cod;
    cout << "Digite a nova quantidade: ";
    cin >> novaQtd;
    atualizarQuantidadeEmArquivo(cod, novaQtd);

    return 0;
}