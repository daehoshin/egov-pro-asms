package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegPlaceAddController {
	
	@RequestMapping("/rgst/place/placeAddForm.do")
	public String RegPlaceAddForm() throws Exception {
		
		return "/reg/place/regPlaceAdd";
	}
	
}
