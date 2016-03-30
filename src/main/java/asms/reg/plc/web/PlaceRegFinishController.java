package asms.reg.plc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.login.service.LoginUserVO;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

@Controller
public class PlaceRegFinishController {
    
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/rgst/place/placeRegFinishAction.do")
	public String PlaceRegFinish(@RequestParam("plc_id")String plc_id, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute("loginUserVO");
		PlaceVO placeVO = new PlaceVO();
		
		placeVO.setPlc_id(plc_id);
		placeVO.setSys_id(loginUserVO.getMp_id());
		placeVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = placeService.placeRegFinishAction(placeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
