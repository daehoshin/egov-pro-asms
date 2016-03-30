package asms.reg.eq.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.eq.web
 * @FileName RegEquipmentController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class RegEquipmentController {
	@RequestMapping("/reg/equipment/equipment.do")
	public String RegEquipment() throws Exception{
		return "/reg/equipment/Equipment";
	}
}