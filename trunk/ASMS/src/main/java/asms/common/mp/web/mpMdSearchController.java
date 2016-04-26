package asms.common.mp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName asms.common.mp.web
 * @FileName mpMdSearchController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Controller
public class mpMdSearchController {
	@RequestMapping("/common/mp/mpMdSearch.do")
	public String mpMdSearch(@RequestParam(value="targetForm", required=false)String targetForm, @RequestParam(value="targetId", required=false)String targetId, @RequestParam(value="targetNm", required=false)String targetNm, ModelMap map) throws Exception{
		
		map.addAttribute("targetForm", targetForm);
		map.addAttribute("targetId", targetId);
		map.addAttribute("targetNm", targetNm);
		
		return "/common/mp/mpMdSearch";
	}
}
