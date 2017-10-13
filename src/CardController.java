import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.sql.*;

/**
 * Created by Grish on 10.10.2017.
 */
@ManagedBean
@RequestScoped
public class CardController implements Serializable {
    private String info;
    private int paySum;

    public CardController(){

    }
    public String pay(String login,int sum){
        try{
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/JFS", "root", "");

            int total_sum = (sum-this.paySum);

            if(total_sum>=0 /*&& paySum>=0*/){
            String qery = "update lab  set summ="+total_sum+" where login='"+login+"'";
            Statement st = con.createStatement();
            st.execute(qery);
            st.close();
            con.close();
            return "index.xhtml";
            }else{
                return "error.xhtml";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "error.xhtml";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error.xhtml";
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public int hashCode(){
        return 0;
    }
    @Override
    public boolean equals(Object o){
        return true;
    }
    @Override
    public String toString(){
        return "koko";
    }

    public int getPaySum() {
        return paySum;
    }

    public void setPaySum(int paySum) {
        this.paySum = paySum;
    }
}
