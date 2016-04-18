package asms.reg.eq.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentAddController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentAddController {
	
	@Resource(name = "EquipmentService")
    protected EquipmentService equipmentService;
	
	@RequestMapping("/rgst/equipment/equipmentAddForm.do")
	public String EquipmentAddForm() throws Exception {
		
		return "/reg/equipment/EquipmentAdd";
	}

	@RequestMapping("/rgst/equipment/equipmentAddAction.do")
	public String EquipmentAddAction(@ModelAttribute("EquipmentVO")EquipmentVO equipmentVO, HttpSession session, ModelMap map) throws Exception {
		
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		
		equipmentVO.setReg_id(loginUserVO.getMp_id());
		equipmentVO.setReg_nm(loginUserVO.getMp_nm());
		equipmentVO.setSys_id(loginUserVO.getMp_id());
		equipmentVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = equipmentService.equipmentAddAction(equipmentVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
