
package Main;

import SingletonImp.ConexionBD;


public class Main {

    public static void main(String[] args) {
        ConexionBD con = ConexionBD.getInstancia("jdbc:h2:mem:testdb");
        ConexionBD con2 = ConexionBD.getInstancia("jdbc:sqlLite:mem:testdb");
        con.conectar();
        System.out.println("Conexion: " + con.getCon());
        System.out.println("Conexion 2: " + con2.getCon());
        con.desconectar();
    }
}
