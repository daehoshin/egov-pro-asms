package asms.sys.meta.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.meta.service.MetaService;
import asms.sys.meta.service.MetaVO;

@Controller
public class SysMetaAddController {
	
	@Resource(name = "MetaService")
    protected MetaService metaService;
	
	@RequestMapping("/sys/meta/metaAddForm.do")
	public String SysMetaAddForm() throws Exception {
	
		return "/sys/meta/metaAdd";
	}
	
	@RequestMapping("/sys/meta/metaAddAction.do")
	public String SysMetaAddAction(@ModelAttribute("MetaVO")MetaVO metaVO, HttpSession session, ModelMap map) throws Exception {
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		String currentDate = DateUtils.CurrentDate();
		
		metaVO.setReg_id(loginUserVO.getMp_id());
		metaVO.setReg_nm(loginUserVO.getMp_nm());
		metaVO.setReg_dt(currentDate);
		metaVO.setSys_id(loginUserVO.getMp_id());
		metaVO.setSys_nm(loginUserVO.getMp_nm());
		metaVO.setSys_dt(currentDate);
		
		int result = metaService.metaAddAction(metaVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", metaVO.getMeta_id());
		
		return "jsonView";
	}
}
