
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yonatan
 */
public class Sqlusuarios extends Conexion {
    
    
   public int existeusuario (String usuario) {
       
       PreparedStatement ps = null;
       ResultSet rs = null;
       Connection con = getConnection();
       
       String sql = "SELECT count(id) FROM usuarios WHERE usuario = ? ";
       
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, usuario);
           rs = ps.executeQuery();
           
           if (rs.next())   
           {
               return rs.getInt(1);
       }
           return 1;
   }catch (SQLException ex){
       Logger.getLogger(Sqlusuarios.class.getName()) .log(Level.SEVERE, null, ex);
       return 1;
   }
  
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public boolean guardardatos(usuarios usr)
//    {
//        
//        PreparedStatement ps = null;
//        Connection con = getConexion();
//        
//        String sql = "INSERT INTO usuarios (Nombre_Cliente,DNI,email,Telefono,hora,fecha,numero_mesa)"
//                + "VALUES (?,?,?,?,?,?,?)";
//        
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, usr.getNombre_Cliente());
//            ps.setString(2, usr.getDNI());
//            ps.setString(3, usr.getEmail());
//            ps.setString(4, usr.getTelefono());
//            ps.setString(5, usr.getHora());
//            ps.setString(6, usr.getFecha());
//            ps.setString(7, usr.getNumero_mesa()); 
//            ps.execute();
//            return true;
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);
//            
//            return false;
//        }
//             
//    }
            
    
}
