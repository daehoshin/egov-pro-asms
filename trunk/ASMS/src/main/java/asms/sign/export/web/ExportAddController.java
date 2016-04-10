package asms.sign.export.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.sign.export.service.ExportService;
import asms.sign.export.service.ExportVO;

/**
 * @PackageName asms.sign.export.web
 * @FileName ExportAddController.java
 * @Author Jinho Jung
 * @Since 2016. 4. 09.
 */
@Controller
public class ExportAddController {
	
	@Resource(name = "ExportService")
    protected ExportService exportService;
	
	
	@RequestMapping("/sign/export/exportRegForm.do")
	public String exportRegForm(ExportVO export) throws Exception{
		return "/sign/export/exportReg";
	}
	
	@RequestMapping("/sign/export/exportAddAction.do")
	public String exportAddAction(@ModelAttribute("ExportVO")ExportVO exportVO, HttpSession session, ModelMap map) throws Exception{
		String resultMsg = "";
		System.out.println(exportVO);
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		exportVO.setReg_id(loginUserVO.getMp_id());
		exportVO.setReg_nm(loginUserVO.getMp_nm());
		exportVO.setSys_id(loginUserVO.getMp_id());
		exportVO.setSys_nm(loginUserVO.getMp_nm());
		exportVO.setApp_hm_id(loginUserVO.getMp_id());
		
		int result = exportService.exportAddAction(exportVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		map.addAttribute("result", result == 1);
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
}
