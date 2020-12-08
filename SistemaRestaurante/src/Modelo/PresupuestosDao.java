package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PresupuestosDao {
    
    Conexion conexion=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
    
    List<Presupuestos> datos=new ArrayList<>();
    String sql="SELECT * FROM presupuesto";
    
    
        try {
            con=conexion.getConnection();
            
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                Presupuestos p=new Presupuestos();
                p.setId_Presupuesto(rs.getInt(1));
                p.setGanancia(rs.getInt(2));
                p.setFecha(rs.getString(3));
                datos.add(p);
            }
        } catch (Exception e) {
            
        }
    return datos;
    
    }
    
    
    public int agregar(Presupuestos p){
    String sql="INSERT INTO presupuesto (Ganancia, fecha) VALUES (?, ?);";
    
        try {
            con=conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, p.getGanancia());
            ps.setString(2, p.getFecha());
            ps.executeUpdate();

            
        } catch (SQLException e) {
            
            
        }
    return 1;
    }
    
    public int Actualizar(Presupuestos p) {
        int r=0;
        String sql = "update presupuesto set Ganancia=?, fecha=? where id_Presupuesto=? ;";

        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getGanancia());
            ps.setString(2, p.getFecha());
            ps.setInt(3, p.getId_Presupuesto());
            r=ps.executeUpdate();
            if (r==1) {
                return  1;
            } else {
                return  0;
            }
            

        } catch (SQLException e) {

        }
        return r;
    }
    
    public void eliminiar(int id){
    String sql="delete from presupuesto where id_Presupuesto="+id;
    
        try {
            con=conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeQuery();
            
        } catch (Exception e) {
        }
    
    
    }
    

}
