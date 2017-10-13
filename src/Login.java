import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.print.DocFlavor;
import java.io.Serializable;
import java.sql.*;

/**
 * Created by Grish on 09.10.2017.
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    private String login;
    private String password;
    private String info;
    private int sum;
    private String debug;

    public Login(){
        login="";
        password="";
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public  String getPassword(){
        return password;
    }
    public String tryLogin() {
       try {
           Connection connection;
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost/JFS", "root", "");
           String qery = "select * from lab";
           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery(qery);

           while(rs.next()){
           if(rs.getString("login").equals(this.login)&&rs.getString("password").equals(this.password)) {
               info = rs.getString("info");
               sum  = rs.getInt("summ");
               st.close();
               connection.close();
               return "log.xhtml";
           }
           }
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           return "error.xhtml";
       } catch (SQLException e) {
           e.printStackTrace();
           return "error.xhtml";
       }
        return "error.xhtml";
     }
    @Override
    public String toString(){
        return login+password;
    }
    @Override
    public boolean equals(Object o){
        return true;
    }
    @Override
    public int hashCode(){
        return 0;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
