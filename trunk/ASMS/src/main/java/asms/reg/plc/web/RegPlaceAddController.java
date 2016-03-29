package asms.reg.plc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

@Controller
public class RegPlaceAddController {
	
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/rgst/place/placeAddForm.do")
	public String RegPlaceAddForm() throws Exception {
		
		return "/reg/place/regPlaceAdd";
	}

	@RequestMapping("/rgst/place/placeAddAction.do")
	public String RegPlaceAddAction(@ModelAttribute("PlaceVO")PlaceVO placeVO) throws Exception {
		
		String result = placeService.RegPlaceAddAction(placeVO);
		
		return "jsonView";
	}
	
}
