package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegPlaceViewController {
    
	@RequestMapping("/rgst/place/placeViewForm.do")
	public String RegPlaceViewForm(@RequestParam("plc_id")String plc_id, ModelMap map) throws Exception{
		
    	String result = "";
		
		try {
			
		} catch(Exception e) {
			
		}
		
		map.addAttribute("result", result);
		
		return "jsonView";
    	
	}
}
