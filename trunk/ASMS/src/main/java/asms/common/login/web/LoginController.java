package asms.common.login.web;

import java.security.Principal;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import asms.common.Constants;
import asms.common.login.service.LoginService;
import asms.common.login.service.LoginUserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(Constants.LoginUserVO)
public class LoginController {
	
	@Autowired private UserDetailsService userDetailsSvc;
	
	@Resource(name="LoginService")
	private LoginService LoginService;
	
	@RequestMapping(value="/login.do")	
	public String LoginUserInfo(HttpSession session, Principal principal, ModelMap model) throws Exception {
		
		String mp_id = principal.getName();
		
		LoginUserVO loginUserVO = LoginService.selectLoginUserInfo(mp_id);
		
		model.addAttribute("loginUserVO", loginUserVO);
		
		return "forward:/main.do";
	}
	
}
