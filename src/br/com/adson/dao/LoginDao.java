
package br.com.adson.dao;

import br.com.adson.model.Login;
import br.com.adson.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao {
    
    public static ArrayList<Login> buscarLogin() throws SQLException {
        ArrayList<Login> loginAux = new ArrayList<>();
        String sql = "select login_nome, login_senha from login";
        
        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Login login = new Login();
            login.setLogin(rs.getString("login_nome"));
            login.setSenha(rs.getString("login_senha"));
            
            loginAux.add(login);
        }
        return loginAux;
    } 
    
}
