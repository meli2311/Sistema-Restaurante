package Controlador;

import Modelo.Presupuestos;
import Modelo.PresupuestosDao;
import Vista.Ganancias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorP implements ActionListener {

    PresupuestosDao dao = new PresupuestosDao();
    
    Presupuestos pres = new Presupuestos();
    
    Ganancias ga = new Ganancias();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorP(Ganancias g) {
        this.ga = g;
        this.ga.btnListar.addActionListener(this);
//        this.ga.btnAceptar.addActionListener(this);
//        this.ga.btnAceptar.addActionListener(this);
//        this.ga.btnModificar.addActionListener(this);
//        this.ga.btnEliminar.addActionListener(this);
        listar(ga.TablaG);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ga.btnListar) {
//            LimpiarTabla();
            listar(ga.TablaG);
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

}
