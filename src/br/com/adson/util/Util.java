
package br.com.adson.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Util {

    public static Date converterToDate(String stringdata) {
        
        DateFormat df;
        Date data = new Date();
        
        try {
            df = new SimpleDateFormat("yyyy-MM-dd");
            data = df.parse(stringdata);
            
        } catch (ParseException e) {
            JOptionPane.showInputDialog(null, "Ocorreu um erro converterParaData: "+ e);
        }
        
        return data;
    }

    public static Object converterToString(Date data) {
        DateFormat df;
        String dataString = null;
        
        df = new SimpleDateFormat("yyyy-MM-dd");
        dataString = df.format(data);
        return  dataString;
    }
    
}
