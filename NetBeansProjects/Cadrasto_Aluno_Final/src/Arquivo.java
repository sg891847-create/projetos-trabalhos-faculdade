import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    private FileWriter arqW;
    private BufferedWriter escritor;

    private FileReader arqR;
    private BufferedReader leitor;

    private List<Aluno> listaAlunos;

    public String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaAlunos = new ArrayList<>();
    }

    public List<Aluno> leArquivo() {

        listaAlunos.clear();

        try {
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] campos = linha.split(";");

                String nome = campos[0];
                String dataNascimento = campos[1];
                char sexo = campos[2].charAt(0);
                String matricula = campos[3];
                String curso = campos[4];
                String cpf = campos[5];
                String endereço = campos[6];
                String cep = campos[7];
                String estado = campos[8];
                String telefone = campos[9];

                Aluno a = new Aluno(nome, dataNascimento, sexo, matricula, curso, cpf, endereço, cep, estado, telefone);

                listaAlunos.add(a);
            }

            leitor.close();
            arqR.close();

        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe.
            // Começa com a lista vazia.
            System.out.println("Arquivo ainda não existe.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAlunos;
    }

    // Retorna a lista que esta na memoria
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    // Grava TODA a lista no arquivo
    public void gravaArquivo() {

        try {
            arqW = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqW);

            for (Aluno a : listaAlunos) {

                escritor.write(
                    a.nome + ";" +
                    a.dataNascimento + ";" +
                    a.sexo + ";" +
                    a.matricula + ";" +
                    a.curso + ";" +
                    a.cpf + ";" +
                    a.endereço + ";" +
                    a.cep + ";" +
                    a.estado + ";" +
                    a.telefone
                );

                escritor.newLine();
            }

            escritor.close();
            arqW.close();

            System.out.println("Lista salva no arquivo!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}