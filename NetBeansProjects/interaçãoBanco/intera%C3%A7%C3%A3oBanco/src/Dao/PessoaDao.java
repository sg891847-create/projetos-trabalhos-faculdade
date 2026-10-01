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
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }
    
    public Pessoa getPessoa(int idPessoa) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setIdioma(rs.getString("idioma"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome=?, sexo=?, idioma=? WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar pessoa: " + ex.getMessage());
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
    
    
    public void excluir(int id) {
        String sql = "DELETE FROM pessoa WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir pessoa: " + ex.getMessage());
        }
    }
}
   
    
