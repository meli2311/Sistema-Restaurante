package Controlador;

import Modelo.Presupuestos;
import Modelo.PresupuestosDao;
import Vista.Ganancias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorP implements ActionListener {

    PresupuestosDao dao = new PresupuestosDao();

    Presupuestos pres = new Presupuestos();

    Ganancias ga = new Ganancias();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorP(Ganancias g) {
        this.ga = g;
        this.ga.btnAgregar.addActionListener(this);
        this.ga.btnAceptar.addActionListener(this);
        this.ga.btnActualizar.addActionListener(this);
        this.ga.btnEliminar.addActionListener(this);
        listar(ga.TablaG);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ga.btnAgregar) {
            agregar();
            LimpiarTabla();
            listar(ga.TablaG);
        }
        if (e.getSource() == ga.btnActualizar) {
            int fila = ga.TablaG.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(ga, "Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt((String) ga.TablaG.getValueAt(fila, 0).toString());
                int ganancia = Integer.parseInt((String) ga.TablaG.getValueAt(fila, 1).toString());
                String fecha_hora = (String) ga.TablaG.getValueAt(fila, 2);
                ga.txtId.setText("" + id);
                ga.txtGanancia.setText("" + ganancia);
                ((JTextField) ga.txtFecha.getDateEditor().getUiComponent()).setText(fecha_hora);

            }

        }
        if (e.getSource() == ga.btnAceptar) {

            Actualizar();
            LimpiarTabla();
            listar(ga.TablaG);
        }

        if (e.getSource() == ga.btnEliminar) {

            eliminar();
            LimpiarTabla();
            listar(ga.TablaG);

        }

    }

    public void eliminar() {
        int fila = ga.TablaG.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(ga, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt((String) ga.TablaG.getValueAt(fila, 0).toString());
            dao.eliminiar1(id);
            JOptionPane.showMessageDialog(ga, "Usuario eliminado correcatamente");

        }

    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Presupuestos> lista = dao.Listar();
        Object[] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_Presupuesto();
            object[1] = lista.get(i).getGanancia();
            object[2] = lista.get(i).getFecha();
            modelo.addRow(object);
        }
        ga.TablaG.setModel(modelo);
    }

    public void LimpiarTabla() {
        for (int i = 0; i < ga.TablaG.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void Actualizar() {
        int id = Integer.parseInt(ga.txtId.getText());
        int ganancia = Integer.parseInt(ga.txtGanancia.getText());
        String Fecha = ((JTextField) ga.txtFecha.getDateEditor().getUiComponent()).getText();
        pres.setId_Presupuesto(id);
        pres.setGanancia(ganancia);
        pres.setFecha(Fecha);
        int r = dao.Actualizar(pres);

        if (r == 1) {
            JOptionPane.showMessageDialog(ga, "Datos Atualizados con exito");
        } else {
            JOptionPane.showMessageDialog(ga, "Ocurrio un error");
        }

    }

    public void agregar() {
        int ganancia = Integer.parseInt(ga.txtGanancia.getText());
        String Fecha = ((JTextField) ga.txtFecha.getDateEditor().getUiComponent()).getText();
        pres.setGanancia(ganancia);
        pres.setFecha(Fecha);
        int r = dao.agregar(pres);
        if (r == 1) {
            JOptionPane.showMessageDialog(ga, "Datos registrados con exito");
        } else {
            JOptionPane.showMessageDialog(ga, "Ocurrio un error");
        }
    }

}
