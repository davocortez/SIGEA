/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Bean.BeanProfesor;
import Utilerias.conexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class DaoProfesor {
    String consultar="select * from profesor";
    
    public List consultarProfesor() {
        List listaNombre = new ArrayList();
        try {
            Connection connect = conexionMySql.getConnection();
            PreparedStatement ps = connect.prepareStatement(consultar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanProfesor bean = new BeanProfesor();
            }
        } catch (SQLException sale) {
            sale.printStackTrace();
        }
        return listaNombre;
    }
}
