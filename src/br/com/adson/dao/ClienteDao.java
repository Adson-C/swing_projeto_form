
package br.com.adson.dao;

import br.com.adson.model.Cliente;
import br.com.adson.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClienteDao extends Dao<Cliente> {

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO cliente(cli_nome , cli_cpf, cli_email, cli_dt_nasc, cli_sexo, cli_fone)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            
            Connection conn = this.obterConexao();
            
            try{
                
                ps = conn.prepareStatement(sql);
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpf());
                ps.setString(3, cliente.getEmail());
                ps.setDate(4, cliente.getNascimento());
                ps.setString(5, cliente.getSexo());
                ps.setString(6, cliente.getFone());
                
                ps.executeUpdate();
                
            }finally{
                try{
                    ConnectionFactory.closeConnection(conn, ps);
                    
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean atualizar(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCodigo(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
