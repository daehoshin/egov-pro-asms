package asms.sys.code.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.code.service.CodeService;
import asms.sys.code.service.CodeVO;

@Controller
public class SysCodeViewController {
	
	@Resource(name = "CodeService")
    protected CodeService codeService;
	
	@RequestMapping("/sys/code/codeViewForm.do")
	public String SysCodeView(@RequestParam("code_id")String code_id, ModelMap map) throws Exception{
		CodeVO codeVO = new CodeVO();
		codeVO.setCode_id(code_id);
		
		codeVO = codeService.codeInfoSearch(codeVO);
			
		map.addAttribute("codeVO", codeVO);
		
		return "/sys/code/codeView";
	}
}
