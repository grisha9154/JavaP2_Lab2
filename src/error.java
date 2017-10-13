import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Grish on 10.10.2017.
 */
@ManagedBean
@RequestScoped
public class error implements Serializable{
    private int id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "qwe";
    }
    @Override
    public boolean equals(Object o){
        return true;
    }
    @Override
    public int hashCode(){
    return 0;
    }
}
