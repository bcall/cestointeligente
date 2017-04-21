package ar.com.itr.cestointeligente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends ControllersCore{

	private static final long serialVersionUID = -4392986401742248081L;

	@RequestMapping(value ={"/login","/"}, method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {
		if (error == true) {
			model.put("error",
					"Datos incorrectos!");
		} else {
			model.put("error", "");
		}

		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String getDeniedPage() {
		return "403";
	}
}
