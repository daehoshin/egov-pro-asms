package asms.reg.eq.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentViewController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentViewController {
    
	@Resource(name = "EquipmentService")
    protected EquipmentService equipmentService;
	
	@RequestMapping("/rgst/equipment/equipmentViewForm.do")
	public String EquipmentViewForm(@RequestParam("eqm_id")String eqm_id, ModelMap map) throws Exception{
		
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEqm_id(eqm_id);
		
		equipmentVO = equipmentService.equipmentInfoSearch(equipmentVO);
			
		map.addAttribute("equipmentVO", equipmentVO);
		
		return "/reg/equipment/EquipmentView";
    	
	}
}
