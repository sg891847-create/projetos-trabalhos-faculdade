#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct Aluno {
    string nome;
    int matricula;
    float nota;
};

// Exercício 1: Função sem retorno para leitura e exibição
void cadastrarAlunos(Aluno alunos[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        cout << "\n--- Aluno " << i + 1 << " ---" << endl;
        cout << "Nome: ";
        cin.ignore();
        getline(cin, alunos[i].nome);
        cout << "Matrícula: ";
        cin >> alunos[i].matricula;
        cout << "Nota: ";
        cin >> alunos[i].nota;
    }
}

void exibirAlunos(const Aluno alunos[], int tamanho) {
    cout << "\n=== Lista de Alunos ===" << endl;
    for (int i = 0; i < tamanho; i++) {
        cout << "Matrícula: " << alunos[i].matricula 
             << " | Nome: " << alunos[i].nome 
             << " | Nota: " << alunos[i].nota << endl;
    }
}

// Exercício 2: Média das notas
float calcularMedia(const Aluno alunos[], int tamanho) {
    float soma = 0;
    for (int i = 0; i < tamanho; i++) {
        soma += alunos[i].nota;
    }
    return tamanho > 0 ? soma / tamanho : 0.0f;
}

// Exercício 3: Busca por matrícula
int buscarPorMatricula(const Aluno alunos[], int tamanho, int matricula) {
    for (int i = 0; i < tamanho; i++) {
        if (alunos[i].matricula == matricula) {
            return i; // Retorna o índice
        }
    }
    return -1; // Não encontrado
}

// Exercício 4: Salvar em arquivo texto
void salvarEmArquivo(const Aluno alunos[], int tamanho) {
    ofstream arquivo("alunos.txt");
    if (!arquivo.is_open()) {
        cerr << "Erro ao abrir o arquivo para escrita." << endl;
        return;
    }
    for (int i = 0; i < tamanho; i++) {
        arquivo << alunos[i].matricula << ";" << alunos[i].nome << ";" << alunos[i].nota << endl;
    }
    arquivo.close();
    cout << "\nDados salvos em 'alunos.txt' com sucesso!" << endl;
}

// Exercício 5: Ler de arquivo texto
void lerDeArquivo() {
    ifstream arquivo("alunos.txt");
    if (!arquivo.is_open()) {
        cerr << "Erro ao abrir o arquivo para leitura." << endl;
        return;
    }

    vector<Aluno> alunosLidos;
    Aluno temp;
    string linha, notaStr;

    // Lendo o arquivo formatado como: matricula;nome;nota
    while (getline(arquivo, linha)) {
        size_t pos1 = linha.find(';');
        size_t pos2 = linha.rfind(';');
        if (pos1 != string::npos && pos2 != string::npos) {
            temp.matricula = stoi(linha.substr(0, pos1));
            temp.nome = linha.substr(pos1 + 1, pos2 - pos1 - 1);
            temp.nota = stof(linha.substr(pos2 + 1));
            alunosLidos.push_back(temp);
        }
    }
    arquivo.close();

    cout << "\n=== Alunos Lidos do Arquivo ===" << endl;
    for (const auto& a : alunosLidos) {
        cout << "Matrícula: " << a.matricula << " | Nome: " << a.nome << " | Nota: " << a.nota << endl;
    }
}

int main() {
    const int QTDE = 5;
    Aluno alunos[QTDE];

    // Exercício 1
    cadastrarAlunos(alunos, QTDE);
    exibirAlunos(alunos, QTDE);

    // Exercício 2
    cout << "\nMédia Geral das Notas: " << calcularMedia(alunos, QTDE) << endl;

    // Exercício 3
    int matBusca;
    cout << "\nDigite uma matrícula para buscar: ";
    cin >> matBusca;
    int idx = buscarPorMatricula(alunos, QTDE, matBusca);
    if (idx != -1) {
        cout << "Aluno Encontrado -> Nome: " << alunos[idx].nome << " | Nota: " << alunos[idx].nota << endl;
    } else {
        cout << "Aluno não encontrado!" << endl;
    }

    // Exercício 4
    salvarEmArquivo(alunos, QTDE);

    // Exercício 5
    lerDeArquivo();

    return 0;
}