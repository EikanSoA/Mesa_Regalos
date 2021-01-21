
package mesa_regalos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pantallas.Registro_Anfitrion;

public class ConexionBD {
    public Statement Con(){
        
        
        Statement st = null;
        Connection con = null;
        
        try{
                String url = "jdbc:mysql://localhost:3306/dbmesaregalo";
                String usuario = "root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url,usuario,password);
                if(con != null){
                    System.out.println("CONEXION A LA BASE DE DATOS" +
                            "\n" + url );
                    st = con.createStatement();
                    
                    
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(Registro_Anfitrion.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                if(con != null){
                    try{
                        con.close();
                        st.close();
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        return st;
        } 
     
}
