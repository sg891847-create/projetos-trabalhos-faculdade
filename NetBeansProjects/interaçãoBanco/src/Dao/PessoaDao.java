/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import conexao.Conexao;
import java.sql.*;

    
    
    
/**
 *
 * @author laboratorio
 */
import Beans.Pessoa;
public class PessoaDao {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDao(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void incerir (Pessoa pessoa){
        String sql = "INCERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.execute();
        }catch (SQLException e){
            System.out.println("Erro ao incerir pessoa: " +e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Yuki");
        p.setSexo("F");
        p.setIdioma("Japones");
       
        
        PessoaDao pDAO = new PessoaDao();
        pDAO.incerir(p);
    }
}
   
    
