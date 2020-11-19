

package Controlador;

import Modelo.ReservaDAO;
import Modelo.Reservas;
import Vista.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    
    ReservaDAO  dao=new ReservaDAO();
    
    Reservas res=new Reservas();
    
    Reserva sisr=new Reserva();
    DefaultTableModel modelo=new DefaultTableModel();

    public Controlador(Reserva v) {
        this.sisr=v;
//        this.sisr.btnListar.addActionListener(this);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void listar(JTable tabla)
    {
        modelo=(DefaultTableModel)tabla.getModel();
        List<Reservas>   lista=dao.listar();
        
        Object[] object=new Object[4];
        
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getId_Reserva();
            object[1]=lista.get(i).getNombre_cliente();
            object[2]=lista.get(i).getDNI();
            object[3]=lista.get(i).getEmail();
            object[4]=lista.get(i).getTelefono();
            object[5]=lista.get(i).getFecha_hora();
            object[6]=lista.get(i).getNumero_mesa();
            
        }
    
    
    
    }
    
}
