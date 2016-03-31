package asms.common.asset.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.Constants;
import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetService;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.common.asset.web
 * @FileName AssetDelController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Controller
public class AssetDelController {
	
	@Resource(name = "AssetService")
    protected AssetService assetService;
	
	@RequestMapping("/common/asset/assetDelRsnForm.do")
	public String AssetDelRsnForm(@RequestParam("asset_pk")String asset_pk, @RequestParam("asset_type")String asset_type, @RequestParam("executeUrl")String executeUrl, @RequestParam("callbackName")String callbackName, ModelMap map) throws Exception {
		
		AssetBaseInfoVO assetBaseInfoVO = new AssetBaseInfoVO();
		
		assetBaseInfoVO.setAsset_pk(asset_pk);
		assetBaseInfoVO.setAsset_type(asset_type);
		
		String modalTitleNm = "";
		
		if(Constants.Equipment_MngNo_Code.equals(asset_type)){
			modalTitleNm = Constants.Equipment_MngNo_CodeNm;
		} else if(Constants.Place_MngNo_Code.equals(asset_type)){
			modalTitleNm = Constants.Place_MngNo_CodeNm;
		} else if(Constants.ManPower_MngNo_Code.equals(asset_type)){
			modalTitleNm = Constants.ManPower_MngNo_CodeNm;
		}
		
		assetBaseInfoVO = assetService.AssetBaseInfoSearch(assetBaseInfoVO);
		
		map.addAttribute("asset_pk", asset_pk);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("callbackName", callbackName);
		map.addAttribute("modalTitleNm", modalTitleNm);
		map.addAttribute("asset_type", asset_type);
		map.addAttribute("assetNm", assetBaseInfoVO.getAsset_nm());
		
		return "/common/assetDelRsn";
	}
	
	@RequestMapping("/common/asset/assetDelRsn.do")
	public String AssetAddAction(@ModelAttribute("AssetBaseInfoVO")AssetBaseInfoVO assetBaseInfoVO, HttpSession session, ModelMap map) throws Exception {
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute("loginUserVO");
		String currentDate = DateUtils.CurrentDate();
		
		assetBaseInfoVO.setAsset_reg_status(Constants.RegStatus_Del);
		assetBaseInfoVO.setReg_id(loginUserVO.getMp_id());
		assetBaseInfoVO.setReg_nm(loginUserVO.getMp_nm());
		assetBaseInfoVO.setReg_dt(currentDate);
		
		int result = assetService.AssetDelAction(assetBaseInfoVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
