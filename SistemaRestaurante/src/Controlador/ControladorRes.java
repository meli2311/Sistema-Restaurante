package Controlador;

import Modelo.ReservaDAO;
import Modelo.Reservas;
import Vista.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorRes implements ActionListener {

    ReservaDAO dao = new ReservaDAO();

    Reservas res = new Reservas();

    Reserva reser = new Reserva();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorRes(Reserva r) {
        this.reser = r;
        this.reser.btnListar.addActionListener(this);
        this.reser.btnAgregar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reser.btnListar) {
            listar(reser.Tabla1);
        }
        if (e.getSource()==reser.btnAgregar) {
            agregar();
            
        }

    }

    public void agregar() {
        String nom = reser.txtNombre.getText();
        int dni = Integer.parseInt(reser.txtDNI.getText());
        String email = reser.txtEmail.getText();
        int telefono = Integer.parseInt(reser.txtTelefono.getText());
        Date Fecha = (Date) reser.txtFecha.getDate();
        int N_Mesa = Integer.parseInt(reser.txtMesa.getText());
        res.setNombre_cliente(nom);
        res.setDNI(dni);
        res.setEmail(email);
        res.setTelefono(telefono);
        res.setFecha_hora(Fecha);
        res.setNumero_mesa(N_Mesa);
        int r=dao.agregar(res);
        
        if (r==1) {
            JOptionPane.showMessageDialog(reser, "Reserva registrado con exito");
        } else {
            JOptionPane.showMessageDialog(reser, "Ocurrio un error");
        }
        
        

    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Reservas> lista = dao.listar();

        Object[] object = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_Reserva();
            object[1] = lista.get(i).getNombre_cliente();
            object[2] = lista.get(i).getDNI();
            object[3] = lista.get(i).getEmail();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getFecha_hora();
            object[6] = lista.get(i).getNumero_mesa();
            modelo.addRow(object);
        }
        reser.Tabla1.setModel(modelo);

    }

}
