package asms.reg.eq.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.eq.web
 * @FileName EquipmentController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Controller
public class EquipmentController {
	@RequestMapping("/reg/equipment/equipment.do")
	public String RegEquipment() throws Exception{
		return "/reg/equipment/Equipment";
	}
}