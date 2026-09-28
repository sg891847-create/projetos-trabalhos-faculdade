#include <iostream>
#include <string>
#include <vector>
#include <fstream>

#include "util.h"

    using namespace std;

        int main() {
            ifstream ArquivoStopWords;
            
            ofstream ArquivoTextoSemStopWords;
            
            vector<string> listStopWords;
            //rotina que carregar a porra toda pra lista
            ArquivoStopWords.open("stopwords.txt");

                if (!ArquivoStopWords) {
                cout << "Arquivo não localizado. Programa encerrado." << endl;
            exit(0);
            
        
                }


                string linha;
	            while (!ArquivoStopWords.eof()) {
		            getline(ArquivoStopWords,linha); //lendo a linha inteira
		            //colocar em maiusculo
                    linha = paraMaiusculoStringComRetorno(linha);

                    listStopWords.push_back(linha);

                }
                ArquivoStopWords.close();
                    
                
                //rotina que exibe a lista de stopwords
                for (int i = 0; i < listStopWords.size(); i++){

                    cout << listStopWords[i] << ", ";

                }
            
            cout <<"\n\n\n";
            
            ifstream ArquivoTextoOriginal;
            string nomeArquivo;
            cout << "Digite o nome do arquivo de texto original: ";
            cin >> nomeArquivo;

            ArquivoTextoOriginal.open(nomeArquivo);

            if() (!ArquivoTextoOriginal) {
                cout << "Arquivo não localizado. Programa encerrado." << endl;
                exit(0);
            }
            
            ofstream ArquivoTextoSemStopWords;
                arquivoTextoSemStopWords.open("textoSemStopWords.txt");

                bool encntrou;
                string palavra;
                while (ArquivoTextoOriginal >> palavra) {
                    palavra = paraMaiusculoStringComRetorno(palvra);
                    
                    encntrou = false;
                    for (int i = 0; i < listStopWords.size(); i++) {
                        if (palavra == listStopWords[i]) {
                            encntrou = true;
                            break;
                        }
                    }
                    if (!encntrou) {
                        arquivoTextoSemStopWords << palavra << " ";
                    }
                }

                arquivoTextoOriginal.close();
                arquivoTextoSemStopWords.close();

            return 1;
        }