package asms.reg.mp.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerViewController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Controller
public class ManPowerViewController {
	
	@Resource(name = "ManPowerService")
    protected ManPowerService manPowerService;
	
	@RequestMapping("/reg/manpower/manPowerViewForm.do")
	public String ManPowerViewForm(@RequestParam("mp_id")String mp_id, ModelMap map) throws Exception{
		
		ManPowerVO manPowerVO = new ManPowerVO();
		manPowerVO.setMp_id(mp_id);
		
		manPowerVO = manPowerService.manPowerInfoSearch(manPowerVO);
			
		map.addAttribute("manPowerVO", manPowerVO);
		
		return "/reg/manpower/ManPowerView";
    	
	}
}
