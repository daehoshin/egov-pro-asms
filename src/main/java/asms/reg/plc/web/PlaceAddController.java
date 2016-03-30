package asms.reg.plc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.login.service.LoginUserVO;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName PlaceAddController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Controller
public class PlaceAddController {
	
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/rgst/place/placeAddForm.do")
	public String PlaceAddForm() throws Exception {
		
		return "/reg/place/PlaceAdd";
	}

	@RequestMapping("/rgst/place/placeAddAction.do")
	public String PlaceAddAction(@ModelAttribute("PlaceVO")PlaceVO placeVO, HttpSession session, ModelMap map) throws Exception {
		
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute("loginUserVO");
		
		placeVO.setReg_id(loginUserVO.getMp_id());
		placeVO.setReg_nm(loginUserVO.getMp_nm());
		placeVO.setSys_id(loginUserVO.getMp_id());
		placeVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = placeService.placeAddAction(placeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
