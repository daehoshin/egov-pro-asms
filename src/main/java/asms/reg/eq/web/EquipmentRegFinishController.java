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
import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentRegFinishController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentRegFinishController {
    
	@Resource(name = "EquipmentService")
    protected EquipmentService equipmentService;
	
	@RequestMapping("/rgst/equipment/equipmentRegFinishAction.do")
	public String EquipmentRegFinish(@RequestParam("eqm_id")String eqm_id, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		EquipmentVO equipmentVO = new EquipmentVO();
		
		equipmentVO.setEqm_id(eqm_id);
		equipmentVO.setSys_id(loginUserVO.getMp_id());
		equipmentVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = equipmentService.equipmentRegFinishAction(equipmentVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
