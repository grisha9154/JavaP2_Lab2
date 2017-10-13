import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.DecimalFormat;

/**
 * Created by Grish on 10.10.2017.
 */
@FacesConverter("ConvEvro")
public class Convert implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return s;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        float amountInDollars = Float.parseFloat(o.toString());
        double ammountInRub = amountInDollars*2;
        DecimalFormat df = new DecimalFormat("###,##0.##");
        return df.format(ammountInRub);
    }
}
