package asms.reg.plc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName RegPlaceController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class PlaceController {
	
	@RequestMapping("/reg/place/place.do")
	public String Place(HttpSession session, ModelMap map) throws Exception{
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		map.addAttribute("loginUserVO", loginUserVO);
		
		return "/reg/place/Place";
	}
	
}
