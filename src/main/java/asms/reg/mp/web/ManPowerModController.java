package asms.reg.mp.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerModController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Controller
public class ManPowerModController {
	
	@Resource(name = "ManPowerService")
    protected ManPowerService manPowerService;
	
    @RequestMapping("/reg/manpower/manPowerModForm.do")
	public String ManPowerModForm(@RequestParam("mp_id")String mp_id, ModelMap map) throws Exception{
		
    	ManPowerVO manPowerVO = new ManPowerVO();
    	manPowerVO.setMp_id(mp_id);
		
    	manPowerVO = manPowerService.manPowerInfoSearch(manPowerVO);
			
		map.addAttribute("manPowerVO", manPowerVO);
		
    	return "/reg/manpower/ManPowerMod";
	}
    
	@RequestMapping("/reg/manpower/manPowerModAction.do")
	public String ManPowerMod(@ModelAttribute("ManPowerVO")ManPowerVO manPowerVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		manPowerVO.setSys_id(loginUserVO.getMp_id());
		manPowerVO.setSys_nm(loginUserVO.getMp_nm());
		
		/*int result = manPowerService.manPowerModAction(manPowerVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);*/
		
		return "jsonView";
	}
}
