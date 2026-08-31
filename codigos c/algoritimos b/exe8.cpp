#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Jogador {
    string nome;
    int pontuacao;
    int nivel;
};

void cadastrarJogadores(vector<Jogador>& jogadores, int qtd) {
    for (int i = 0; i < qtd; i++) {
        Jogador j;
        cout << "\nNome do Jogador " << i + 1 << ": ";
        cin.ignore();
        getline(cin, j.nome);
        cout << "Pontuação: ";
        cin >> j.pontuacao;
        cout << "Nível: ";
        cin >> j.nivel;
        jogadores.push_back(j);
    }
}

// Ordenação com Bubble Sort
void ordenarRanking(vector<Jogador>& jogadores) {
    int n = jogadores.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (jogadores[j].pontuacao < jogadores[j + 1].pontuacao) { // Decrescente
                swap(jogadores[j], jogadores[j + 1]);
            }
        }
    }
}

void gravarRanking(const vector<Jogador>& jogadores) {
    ofstream arq("ranking.txt");
    arq << "=== RANKING DE JOGADORES ===" << endl;
    for (size_t i = 0; i < jogadores.size(); i++) {
        arq << i + 1 << "º Lugar: " << jogadores[i].nome 
            << " | Pontos: " << jogadores[i].pontuacao 
            << " | Nível: " << jogadores[i].nivel << endl;
    }
    arq.close();
    cout << "\nRanking gravado com sucesso em 'ranking.txt'!" << endl;
}

int main() {
    vector<Jogador> lista;
    cadastrarJogadores(lista, 3);
    ordenarRanking(lista);
    gravarRanking(lista);
    return 0;
}