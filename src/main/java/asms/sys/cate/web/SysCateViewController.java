package asms.sys.cate.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.cate.service.CateService;
import asms.sys.cate.service.CateVO;

@Controller
public class SysCateViewController {
	
	@Resource(name = "CateService")
    protected CateService cateService;
	
	@RequestMapping("/sys/cate/cateViewForm.do")
	public String SysCateView(@RequestParam("cate_id")String cate_id, ModelMap map) throws Exception{
		CateVO cateVO = new CateVO();
		cateVO.setCate_id(cate_id);
		
		cateVO = cateService.cateInfoSearch(cateVO);
			
		map.addAttribute("cateVO", cateVO);
		
		return "/sys/cate/cateView";
	}
}
