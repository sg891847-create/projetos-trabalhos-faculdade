import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public String nome;
    public String dataNascimento;
    public char sexo;
    public String matricula;
    public String curso;
    public String cpf;
    public String endereço;       
    public String cep;
    public String estado;
    public String telefone;

    public Aluno(String nome, String dataNascimento, char sexo, String matricula, 
                 String curso, String cpf, String endereço, String cep, String estado, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.endereço = endereço;
        this.cep = cep;
        this.estado = estado;
        this.telefone = telefone;
    }

    public Object[] obterDadosTabela() {
        return new Object[] {
            matricula, nome, cpf, curso, dataNascimento, sexo, telefone, estado
        };
    }
}