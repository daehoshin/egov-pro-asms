package asms.reg.plc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName PlaceViewController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Controller
public class PlaceViewController {
    
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/rgst/place/placeViewForm.do")
	public String PlaceViewForm(@RequestParam("plc_id")String plc_id, ModelMap map) throws Exception{
		
		PlaceVO placeVO = new PlaceVO();
		placeVO.setPlc_id(plc_id);
		
		placeVO = placeService.placeInfoSearch(placeVO);
			
		map.addAttribute("placeVO", placeVO);
		
		return "/reg/place/PlaceView";
    	
	}
}
