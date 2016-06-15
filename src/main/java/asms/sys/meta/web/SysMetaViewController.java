package asms.sys.meta.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.meta.service.MetaService;
import asms.sys.meta.service.MetaVO;

@Controller
public class SysMetaViewController {
	
	@Resource(name = "MetaService")
    protected MetaService metaService;
	
	@RequestMapping("/sys/meta/metaViewForm.do")
	public String SysMetaView(@RequestParam("meta_id")String meta_id, ModelMap map) throws Exception{
		MetaVO metaVO = new MetaVO();
		metaVO.setMeta_id(meta_id);
		
		metaVO = metaService.metaInfoSearch(metaVO);
			
		map.addAttribute("metaVO", metaVO);
		
		return "/sys/meta/metaView";
	}
}
