package asms.reg.plc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.web
 * @FileName PlaceDelController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class PlaceDelController {
	
	@Resource(name = "PlaceService")
    protected PlaceService placeService;
	
	@RequestMapping("/rgst/place/placeDelRsnForm.do")
	public String PlaceDelRsnForm(@RequestParam("plc_id")String plc_id, @RequestParam("executeUrl")String executeUrl, @RequestParam("callbackName")String callbackName, ModelMap map) throws Exception {
		
		PlaceVO placeVO = new PlaceVO();
		
		placeVO.setPlc_id(plc_id);
		
		String modalTitleNm = Constants.Place_MngNo_CodeNm;
		
		placeVO = placeService.placeBaseInfoSearch(placeVO);
		
		map.addAttribute("plc_id", plc_id);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("callbackName", callbackName);
		map.addAttribute("modalTitleNm", modalTitleNm);
		map.addAttribute("plc_nm", placeVO.getPlc_nm());
		
		return "/reg/place/PlaceDelRsn";
	}
	
	@RequestMapping("/rgst/place/placeDelAction.do")
	public String PlaceDelAction(@ModelAttribute("PlaceVO") PlaceVO placeVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		placeVO.setReg_status(Constants.RegStatus_Del);
		placeVO.setReg_id(loginUserVO.getMp_id());
		placeVO.setReg_nm(loginUserVO.getMp_nm());
		placeVO.setReg_dt(currentDate);
		
		int result = placeService.PlaceDelAction(placeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}

	@RequestMapping("/rgst/place/placeSelectDelRsnForm.do")
	public String PlaceSelectDelRsnForm(@ModelAttribute("PlaceVO")PlaceVO placeVO, @RequestParam("executeUrl")String executeUrl, ModelMap map) throws Exception {
		
		String modalTitleNm = Constants.Place_MngNo_CodeNm;
		
		map.addAttribute("placeVO", placeVO);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("modalTitleNm", modalTitleNm);
		
		return "/reg/place/PlaceSelectDelRsn";
	}
	
	@RequestMapping("/rgst/place/placeSelectDelAction.do")
	public String PlaceSelectDelAction(@ModelAttribute("PlaceVO") PlaceVO placeVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		String[] plc_id_array = placeVO.getPlc_id().split(",");
		placeVO.setPlc_id_array(plc_id_array);
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		placeVO.setReg_status(Constants.RegStatus_Del);
		placeVO.setReg_id(loginUserVO.getMp_id());
		placeVO.setReg_nm(loginUserVO.getMp_nm());
		placeVO.setReg_dt(currentDate);
		
		int result = placeService.PlaceSelectDelAction(placeVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
		
}
