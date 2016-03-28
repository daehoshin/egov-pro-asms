package asms.reg.plc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

@Controller
public class RegPlaceModController {
	
    @Resource(name = "PlaceService")
    protected PlaceService placeService;
	
    @RequestMapping("/rgst/place/placeModForm.do")
	public String RegPlaceModForm(@RequestParam("plc_id")String plc_id, ModelMap map) throws Exception{
		
    	/*map.addAttribute("RegPlaceInfo", RegPlaceInfo);*/
    	
    	return "/reg/place/regPlaceMod";
	}
    
	@RequestMapping("/rgst/place/placeModAction.do")
	public String RegPlaceMod(@ModelAttribute("PlaceVO")PlaceVO placeVO, ModelMap map) throws Exception{
		
		String result = "";
		
		try {
			
		} catch(Exception e) {
			
		}
		
		map.addAttribute("result", result);
		
		return "jsonView";
	}
}
