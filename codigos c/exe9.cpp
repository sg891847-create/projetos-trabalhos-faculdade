#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct Livro {
    string titulo;
    string autor;
    int ano;
    int status; // 0 = disponivel, 1 = emprestado
};

void cadastrarLivro(vector<Livro>& biblioteca) {
    Livro l;
    cout << "Título: ";
    cin.ignore();
    getline(cin, l.titulo);
    cout << "Autor: ";
    getline(cin, l.autor);
    cout << "Ano: ";
    cin >> l.ano;
    l.status = 0; // Disponível por padrão
    biblioteca.push_back(l);
}

void listarLivros(const vector<Livro>& biblioteca) {
    cout << "\n=== ACERVO DA BIBLIOTECA ===" << endl;
    for (size_t i = 0; i < biblioteca.size(); i++) {
        cout << i << " - " << biblioteca[i].titulo 
             << " | Autor: " << biblioteca[i].autor 
             << " | Ano: " << biblioteca[i].ano 
             << " | Status: " << (biblioteca[i].status == 0 ? "Disponível" : "Emprestado") << endl;
    }
}

void emprestarLivro(vector<Livro>& biblioteca, int indice) {
    if (indice >= 0 && indice < biblioteca.size()) {
        if (biblioteca[indice].status == 0) {
            biblioteca[indice].status = 1;
            cout << "Livro '" << biblioteca[indice].titulo << "' emprestado com sucesso!" << endl;
        } else {
            cout << "Livro já está emprestado." << endl;
        }
    } else {
        cout << "Índice inválido!" << endl;
    }
}

void salvarEmArquivo(const vector<Livro>& biblioteca) {
    ofstream arq("livros.txt");
    for (const auto& l : biblioteca) {
        arq << l.titulo << ";" << l.autor << ";" << l.ano << ";" << l.status << endl;
    }
    arq.close();
}

void lerDoArquivo(vector<Livro>& biblioteca) {
    ifstream arq("livros.txt");
    if (!arq.is_open()) return;
    
    biblioteca.clear();
    string linha;
    while (getline(arq, linha)) {
        size_t p1 = linha.find(';');
        size_t p2 = linha.find(';', p1 + 1);
        size_t p3 = linha.rfind(';');

        Livro l;
        l.titulo = linha.substr(0, p1);
        l.autor = linha.substr(p1 + 1, p2 - p1 - 1);
        l.ano = stoi(linha.substr(p2 + 1, p3 - p2 - 1));
        l.status = stoi(linha.substr(p3 + 1));
        biblioteca.push_back(l);
    }
    arq.close();
}

int main() {
    vector<Livro> biblioteca;
    
    // Exemplo de uso
    cadastrarLivro(biblioteca);
    salvarEmArquivo(biblioteca);
    
    // Simula carregamento
    vector<Livro> novaBiblioteca;
    lerDoArquivo(novaBiblioteca);
    listarLivros(novaBiblioteca);

    return 0;
}