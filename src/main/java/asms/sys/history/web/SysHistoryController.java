package asms.sys.history.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;

@Controller
public class SysHistoryController {
	@RequestMapping("/sys/history/history.do")
	public String SysHistory(HttpSession session, ModelMap map) throws Exception {
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		map.addAttribute("loginUserVO", loginUserVO);
		
		return "/sys/history/history";
	}
}
