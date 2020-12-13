/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Stock;
import Modelo.StockDAO;
import Vista.MantStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorStock implements ActionListener {
   
    StockDAO dao = new StockDAO();
    Stock sto = new Stock();
    MantStock ms = new MantStock();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorStock(MantStock s){
        this.ms = s;
        this
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
