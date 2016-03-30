package asms.reg.plc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.asset.service.AssetBaseInfoVO;

@Controller
public class PlaceDelController {
	@RequestMapping("/rgst/place/placeDelAction.do")
	public String PlaceDel(@ModelAttribute("AssetBaseInfoVO") AssetBaseInfoVO assetBaseInfoVO, ModelMap map) throws Exception{
		
		String result = "";
		
		try {
			assetBaseInfoVO.getAsset_del_rsn();
		} catch(Exception e) {
			
		}
		
		map.addAttribute("result", result);
		
		return "jsonView";
	}
}
