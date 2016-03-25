package asms.reg.mp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegManPowerController {
	@RequestMapping("/rgst/manpower.do")
	public String RegManPower() throws Exception{
		return "/reg/manpower/regManPower";
	}
}
