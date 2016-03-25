package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegPlaceController {
	@RequestMapping("/rgst/place.do")
	public String RegPlace() throws Exception{
		return "/reg/place/regPlace";
	}
}
