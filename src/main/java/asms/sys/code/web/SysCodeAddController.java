package asms.sys.code.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.code.service.CodeService;
import asms.sys.code.service.CodeVO;

@Controller
public class SysCodeAddController {
	
	@Resource(name = "CodeService")
    protected CodeService codeService;
	
	@RequestMapping("/sys/code/codeAddForm.do")
	public String SysCodeAddForm() throws Exception {
	
		return "/sys/code/codeAdd";
	}
	
	@RequestMapping("/sys/code/codeAddAction.do")
	public String SysCodeAddAction(@ModelAttribute("CodeVO")CodeVO codeVO, HttpSession session, ModelMap map) throws Exception {
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		String currentDate = DateUtils.CurrentDate();
		
		codeVO.setReg_id(loginUserVO.getMp_id());
		codeVO.setReg_nm(loginUserVO.getMp_nm());
		codeVO.setReg_dt(currentDate);
		codeVO.setSys_id(loginUserVO.getMp_id());
		codeVO.setSys_nm(loginUserVO.getMp_nm());
		codeVO.setSys_dt(currentDate);
		
		int result = codeService.codeAddAction(codeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", codeVO.getCode_id());
		
		return "jsonView";
	}
}
