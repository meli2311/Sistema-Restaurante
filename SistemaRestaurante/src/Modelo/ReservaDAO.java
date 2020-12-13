package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ReservaDAO {

    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {

        List<Reservas> datos = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try {
            con = conexion.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reservas r = new Reservas();
                r.setId_Reserva(rs.getInt(1));
                r.setNombre_cliente(rs.getString(2));
                r.setDNI(rs.getInt(3));
                r.setEmail(rs.getString(4));
                r.setTelefono(rs.getInt(5));
                r.setFecha_hora(rs.getString(6));
                r.setNumero_mesa(rs.getInt(7));
                datos.add(r);

            }

        } catch (Exception e) {
        }

        return datos;

    }

    public int agregar(Reservas r) {

        String sql = "INSERT INTO reserva (Nombre_Cliente, DNI, email, Telefono, fecha_hora, numero_mesa) VALUES (?,?,?,?,?,?); ";

        try {

            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre_cliente());
            ps.setInt(2, r.getDNI());
            ps.setString(3, r.getEmail());
            ps.setInt(4, r.getTelefono());
            ps.setString(5, r.getFecha_hora());
            ps.setInt(6, r.getNumero_mesa());
            ps.executeUpdate();

        } catch (SQLException e) {
        }

        return 1;

    }

    public int Actualizar(Reservas r) {
        int respuesta = 0;
        String sql = "UPDATE reserva SET Nombre_Cliente = ?, DNI = ?, email = ?, Telefono = ?, fecha_hora = ?, numero_mesa = ? WHERE (id_Reserva = ?);";
        
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre_cliente());
            ps.setInt(2, r.getDNI());
            ps.setString(3, r.getEmail());
            ps.setInt(4, r.getTelefono());
            ps.setString(5, r.getFecha_hora());
            ps.setInt(6, r.getNumero_mesa());
            ps.setInt(7, r.getId_Reserva());
            respuesta = ps.executeUpdate();
            if (respuesta == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            
        }
        return respuesta;
    }
    
    public void eliminar(int id) {
        String sql = "delete from Reserva where id_Reserva=" + id;
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql); 
            ps.executeUpdate();

        } catch (SQLException e) {
        }

    }
    

}
