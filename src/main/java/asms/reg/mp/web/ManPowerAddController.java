package asms.reg.mp.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerAddController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Controller
public class ManPowerAddController {
	
	@Resource(name = "ManPowerService")
    protected ManPowerService manPowerService;
	
	@RequestMapping("/reg/manpower/manpowerAddForm.do")
	public String ManPowerAddForm() throws Exception {
		
		return "/reg/manpower/ManPowerAdd";
	}

	@RequestMapping("/reg/manpower/manpowerAddAction.do")
	public String ManPowerAddAction(@ModelAttribute("ManPowerVO")ManPowerVO manPowerVO, HttpSession session, ModelMap map) throws Exception {
		
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		manPowerVO.setReg_id(loginUserVO.getMp_id());
		manPowerVO.setReg_nm(loginUserVO.getMp_nm());
		manPowerVO.setSys_id(loginUserVO.getMp_id());
		manPowerVO.setSys_nm(loginUserVO.getMp_nm());
		
		/*int result = manPowerService.manPowerAddAction(manPowerVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);*/
		
		return "jsonView";
	}
}
