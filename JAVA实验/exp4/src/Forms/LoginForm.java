package Forms;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class LoginForm extends ActionForm {

    private String account;
    private String password;

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

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        boolean tag = false;
        for(int i = 0;i < account.length();i++) {
            if(account.charAt(i) < '0' || account.charAt(i) > '9') {
                tag = true;
            }
        }
        if(account.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","账号");
            errors.add("account",message);
        } else if(account.length() < 5 || account.length() > 8) {
            ActionMessage message = new ActionMessage("error.length","账号",5,8);
            errors.add("account",message);
        } else if(tag == true) {
            ActionMessage message = new ActionMessage("error.type","账号");
            errors.add("account",message);
        }
        if(password.length() == 0) {
            ActionMessage message = new ActionMessage("error.null","密码");
            errors.add("password",message);
        } else if(password.length() < 6 || password.length() > 10) {
            ActionMessage message = new ActionMessage("error.length","密码",6,10);
            errors.add("password",message);
        }
        return errors;
    }
}
