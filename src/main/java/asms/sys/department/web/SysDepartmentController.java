package asms.sys.department.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.sys.department.web
 * @FileName SysDepartmentController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 4.
 */
@Controller
public class SysDepartmentController {
	@RequestMapping("/sys/department/department.do")
	public String SysDepartment(HttpSession session, ModelMap map) throws Exception {
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		map.addAttribute("loginUserVO", loginUserVO);
		
		return "/sys/department/department";
	}
}
