package asms.reg.mp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class RegManPowerController {
	@RequestMapping("/reg/manpower/manpower.do")
	public String RegManPower() throws Exception{
		return "/reg/manpower/regManPower";
	}
}
