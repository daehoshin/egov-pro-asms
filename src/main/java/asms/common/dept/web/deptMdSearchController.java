package asms.common.dept.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName asms.common.dept.web
 * @FileName deptMdSearchController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Controller
public class deptMdSearchController {
	@RequestMapping("/common/dept/deptMdSearch.do")
	public String deptMdSearch(@RequestParam(value="targetForm", required=false)String targetForm, @RequestParam(value="targetId", required=false)String targetId, @RequestParam(value="targetNm", required=false)String targetNm, ModelMap map) throws Exception{
		
		map.addAttribute("targetForm", targetForm);
		map.addAttribute("targetId", targetId);
		map.addAttribute("targetNm", targetNm);
		
		return "/common/dept/deptMdSearch";
	}
}
