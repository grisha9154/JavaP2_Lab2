import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;

/**
 * Created by Grish on 10.10.2017.
 */

@FacesValidator("absVAlidator")
public class MyValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String str = o.toString();
        if(str.contains("-")){
            String message = MessageFormat.format("{0} не верное значение",str);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"--","Ну, что ты, фраер, огорчаешь");
            throw new ValidatorException(facesMessage);
        }
    }
}
