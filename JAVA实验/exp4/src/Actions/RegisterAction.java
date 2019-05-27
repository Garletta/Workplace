package Actions;

import DAO.AccountDao;
import Forms.RegisterForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        RegisterForm registerForm = (RegisterForm) form;
        String account = registerForm.getAccount();
        String password = registerForm.getPassword();
        String name = registerForm.getName();
        AccountDao accountDao = new AccountDao();
        boolean can = accountDao.AddAccount(account,password,name);
        if(!can){
            ActionMessages errors = new ActionMessages();
            ActionMessage message = new ActionMessage("error.account","注册",account + "已");
            errors.add("register",message);
            this.saveErrors(request,errors);
            return mapping.getInputForward();
        } else {
            return mapping.findForward("Success");
        }
    }
}
