
package Main;

import SingletonImp.ConexionBD;


public class Main {

    public static void main(String[] args) {
        ConexionBD con = ConexionBD.getInstancia();
        con.conectar();
        System.out.println("Conexion: " + con.getCon());
        con.desconectar();
    }
    
}
