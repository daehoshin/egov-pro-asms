package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegPlaceFinishController {
    
	@RequestMapping("/rgst/place/placeRegFinish.do")
	public String PlaceRegFinish(@RequestParam("plc_id")String plc_id, ModelMap map) throws Exception{
		
    	
    	return "jsonView";
	}
	
}
