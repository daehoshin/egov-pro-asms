package asms.reg.common.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

@Controller
public class AssetDelRsnRegController {
	
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/reg/common/AssetDelRsnForm.do")
	String AssetDelRsnReg(@RequestParam("plc_id")String plc_id, @RequestParam("executeUrl")String executeUrl, @RequestParam("callbackName")String callbackName, ModelMap map) throws Exception {
		
		PlaceVO placeVO = new PlaceVO();
		
		placeVO.setPlc_id(plc_id);
		
		placeVO = placeService.placeInfoSearch(placeVO);
		
		map.addAttribute("plc_id",plc_id);
		map.addAttribute("executeUrl",executeUrl);
		map.addAttribute("callbackName",callbackName);
		map.addAttribute("asset_nm",plc_id);
		
		return "/reg/common/AssetDelRsnReg";
	}
}
