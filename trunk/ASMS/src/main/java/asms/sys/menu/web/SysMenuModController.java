package asms.sys.menu.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.menu.service.MenuService;
import asms.sys.menu.service.MenuVO;

/**
 * @PackageName asms.sys.menu.web
 * @FileName SysMenuModController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
@Controller
public class SysMenuModController {
	
	@Resource(name = "MenuService")
	protected MenuService menuService;
	 
	@RequestMapping("/sys/menu/menuModForm.do")
	public String SysMenuModForm(@RequestParam("menu_grp_id")String menu_grp_id, ModelMap map) throws Exception{
		
    	MenuVO menuVO = new MenuVO();
    	menuVO.setMenu_grp_id(menu_grp_id);
		
    	menuVO = menuService.menuInfoSearch(menuVO);
			
		map.addAttribute("menuVO", menuVO);
		
    	return "/sys/menu/menuMod";
	}
}
