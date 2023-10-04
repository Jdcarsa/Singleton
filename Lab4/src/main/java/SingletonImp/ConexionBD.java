package SingletonImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INGESIS
 */
public class ConexionBD implements IConexionBD {

    private static ConexionBD instancia;
    private Connection con;
    private String conexion;

    private ConexionBD(String conexion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.conexion = conexion;

    }

    public static ConexionBD getInstancia(String conexion) {
        if (instancia == null) {
            instancia = new ConexionBD(conexion);
        }

        return instancia;

    }

    @Override
    public void conectar() {
        try {
            con = DriverManager.getConnection(conexion);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desconectar() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }


}
