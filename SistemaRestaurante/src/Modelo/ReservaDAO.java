package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                r.setFecha_hora(rs.getDate(6));
                r.setNumero_mesa(rs.getInt(7));
                datos.add(r);

            }

        } catch (Exception e) {
        }

        return datos;

    }

}
