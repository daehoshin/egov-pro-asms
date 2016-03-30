package asms.common.asset.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetService;

@Controller
public class AssetDelRsnRegController {
	
	@Resource(name = "AssetService")
    protected AssetService assetService;
	
	@RequestMapping("/common/asset/AssetDelRsnForm.do")
	String AssetDelRsnForm(@RequestParam("asset_pk")String asset_pk, @RequestParam("executeUrl")String executeUrl, @RequestParam("callbackName")String callbackName, ModelMap map) throws Exception {
		
		AssetBaseInfoVO assetBaseInfoVO = new AssetBaseInfoVO();
		
		assetBaseInfoVO.setAsset_pk(asset_pk);
		
		assetBaseInfoVO = assetService.AssetBaseInfoSearch(assetBaseInfoVO);
		
		map.addAttribute("asset_pk", asset_pk);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("callbackName", callbackName);
		map.addAttribute("asset_nm", assetBaseInfoVO.getAsset_nm());
		
		return "/common/delRsnReg";
	}
}
