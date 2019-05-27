package Actions;

import DAO.AccountDao;
import Forms.LoginForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        LoginForm loginForm = (LoginForm) form;
        String account = loginForm.getAccount();
        String password = loginForm.getPassword();
        AccountDao accountDao = new AccountDao();
        boolean can = accountDao.queryAccount(account,password);
        if(!can){
            ActionMessages errors = new ActionMessages();
            ActionMessage message = new ActionMessage("error.login");
            errors.add("login",message);
            this.saveErrors(request,errors);
            return mapping.getInputForward();
        } else {
            return mapping.findForward("Success");
        }
    }
}
