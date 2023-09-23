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

    private ConexionBD() {
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }

        return instancia;

    }

    @Override
    public void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:h2:mem:testdb");

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
