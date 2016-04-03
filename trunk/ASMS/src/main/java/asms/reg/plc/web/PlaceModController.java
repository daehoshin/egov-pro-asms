package asms.reg.plc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName PlaceModController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Controller
public class PlaceModController {
	
    @Resource(name = "PlaceService")
    protected PlaceService placeService;
	
    @RequestMapping("/rgst/place/placeModForm.do")
	public String PlaceModForm(@RequestParam("plc_id")String plc_id, ModelMap map) throws Exception{
		
    	PlaceVO placeVO = new PlaceVO();
		placeVO.setPlc_id(plc_id);
		
		placeVO = placeService.placeInfoSearch(placeVO);
			
		map.addAttribute("placeVO", placeVO);
		
    	return "/reg/place/PlaceMod";
	}
    
	@RequestMapping("/rgst/place/placeModAction.do")
	public String PlaceMod(@ModelAttribute("PlaceVO")PlaceVO placeVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		placeVO.setSys_id(loginUserVO.getMp_id());
		placeVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = placeService.placeModAction(placeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
}
