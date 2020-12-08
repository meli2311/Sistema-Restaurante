package Modelo;


public class Presupuestos {
    
    private int id_Presupuesto;
    private int Ganancia;
    private String fecha;

    public Presupuestos() {
    }

    public Presupuestos(int id_Presupuesto, int Ganancia, String fecha) {
        this.id_Presupuesto = id_Presupuesto;
        this.Ganancia = Ganancia;
        this.fecha = fecha;
    }

    public int getId_Presupuesto() {
        return id_Presupuesto;
    }

    public void setId_Presupuesto(int id_Presupuesto) {
        this.id_Presupuesto = id_Presupuesto;
    }

    public int getGanancia() {
        return Ganancia;
    }

    public void setGanancia(int Ganancia) {
        this.Ganancia = Ganancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

}
