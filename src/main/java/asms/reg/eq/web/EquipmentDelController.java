package asms.reg.eq.web;

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
import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentDelController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentDelController {
	
	@Resource(name = "EquipmentService")
    protected EquipmentService equipmentService;
	
	@RequestMapping("/rgst/equipment/equipmentDelRsnForm.do")
	public String EquipmentDelRsnForm(@RequestParam("eqm_id")String eqm_id, @RequestParam("executeUrl")String executeUrl, @RequestParam("callbackName")String callbackName, ModelMap map) throws Exception {
		
		EquipmentVO equipmentVO = new EquipmentVO();
		
		equipmentVO.setEqm_id(eqm_id);
		
		String modalTitleNm = Constants.Equipment_MngNo_CodeNm;
		
		equipmentVO = equipmentService.equipmentBaseInfoSearch(equipmentVO);
		
		map.addAttribute("eqm_id", eqm_id);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("callbackName", callbackName);
		map.addAttribute("modalTitleNm", modalTitleNm);
		map.addAttribute("eqm_nm", equipmentVO.getEqm_nm());
		
		return "/reg/equipment/EquipmentDelRsn";
	}
	
	@RequestMapping("/rgst/equipment/equipmentDelAction.do")
	public String EquipmentDelAction(@ModelAttribute("EquipmentVO") EquipmentVO equipmentVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		equipmentVO.setReg_status(Constants.RegStatus_Del);
		equipmentVO.setReg_id(loginUserVO.getMp_id());
		equipmentVO.setReg_nm(loginUserVO.getMp_nm());
		equipmentVO.setReg_dt(currentDate);
		
		int result = equipmentService.EquipmentDelAction(equipmentVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}

	@RequestMapping("/rgst/equipment/equipmentSelectDelRsnForm.do")
	public String EquipmentSelectDelRsnForm(@ModelAttribute("EquipmentVO")EquipmentVO equipmentVO, @RequestParam("executeUrl")String executeUrl, ModelMap map) throws Exception {
		
		String modalTitleNm = Constants.Equipment_MngNo_CodeNm;
		
		map.addAttribute("equipmentVO", equipmentVO);
		map.addAttribute("executeUrl", executeUrl);
		map.addAttribute("modalTitleNm", modalTitleNm);
		
		return "/reg/equipment/EquipmentSelectDelRsn";
	}
	
	@RequestMapping("/rgst/equipment/equipmentSelectDelAction.do")
	public String EquipmentSelectDelAction(@ModelAttribute("EquipmentVO") EquipmentVO equipmentVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		String[] eqm_id_array = equipmentVO.getEqm_id().split(",");
		equipmentVO.setEqm_id_array(eqm_id_array);
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		equipmentVO.setReg_status(Constants.RegStatus_Del);
		equipmentVO.setReg_id(loginUserVO.getMp_id());
		equipmentVO.setReg_nm(loginUserVO.getMp_nm());
		equipmentVO.setReg_dt(currentDate);
		
		int result = equipmentService.EquipmentSelectDelAction(equipmentVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
		
}
