
package br.com.adson.controller;

import br.com.adson.dao.LoginDao;
import br.com.adson.model.Login;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginController {

    public ArrayList<Login> buscarLoginSenha() throws SQLException, ClassNotFoundException {
        return LoginDao.buscarLogin();
    }
}
