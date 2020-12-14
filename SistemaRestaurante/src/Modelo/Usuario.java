package Modelo;

/**
 *
 * @author Yonatan
 */
public class Usuario {

    private String usuario;
    private String password;
    private int nivelAcceso;

    public Usuario() {
    }

    public Usuario(String usuario, String password, int nivelAcceso) {
        this.usuario = usuario;
        this.password = password;
        this.nivelAcceso = nivelAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }


    

}
