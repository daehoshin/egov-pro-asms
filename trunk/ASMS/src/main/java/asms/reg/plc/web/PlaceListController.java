package asms.reg.plc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName RegPlaceListController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Controller
public class PlaceListController {
	
    @Resource(name = "PlaceService")
    protected PlaceService placeService;
    
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	@RequestMapping("/rgst/place/placeListSearch.do")
	public String PlaceList(@ModelAttribute("PlaceVO")PlaceVO placeVO, Model map) throws Exception{
		
		List RegPlaceList = placeService.placeListSearch(placeVO);
		
		map.addAttribute("RegPlaceList", RegPlaceList);
		
		return "/reg/place/PlaceList";
	}
}
