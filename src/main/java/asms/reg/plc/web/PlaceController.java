package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.plc.web
 * @FileName RegPlaceController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class PlaceController {
	
	@RequestMapping("/reg/place/place.do")
	public String Place() throws Exception{
		return "/reg/place/Place";
	}
	
}
