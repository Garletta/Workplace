package Forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class RegisterForm extends ActionForm {

    private String account;
    private String password;
    private String confirmPassword;
    private String name;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String comfirmPassword) {
        this.confirmPassword = comfirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UnsupportedEncodingException {
        this.name = new String(name.getBytes("ISO8859-1"));
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(account.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","账号");
            errors.add("account",message);
        }
        if(password.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","密码");
            errors.add("password",message);
        }
        if(confirmPassword.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","确认密码");
            errors.add("confirmPassword",message);
        } else if(!password.equals(confirmPassword)) {
            ActionMessage message = new ActionMessage("error.notSamePassword");
            errors.add("notSamePassword",message);
        }
        if(name.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","姓名");
            errors.add("name",message);
        }
        return errors;
    }
}
