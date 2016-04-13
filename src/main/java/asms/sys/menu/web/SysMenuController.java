package asms.sys.menu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.sys.menu.web
 * @FileName SysMenuController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
@Controller
public class SysMenuController {
	@RequestMapping("/sys/menu/menu.do")
	public String SysMenu() throws Exception {
		return "/sys/menu/menu";
	}
}
