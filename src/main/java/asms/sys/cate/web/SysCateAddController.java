package asms.sys.cate.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.cate.service.CateService;
import asms.sys.cate.service.CateVO;

@Controller
public class SysCateAddController {
	
	@Resource(name = "CateService")
    protected CateService cateService;
	
	@RequestMapping("/sys/cate/cateAddForm.do")
	public String SysCateAddForm() throws Exception {
	
		return "/sys/cate/cateAdd";
	}
	
	@RequestMapping("/sys/cate/cateAddAction.do")
	public String SysCateAddAction(@ModelAttribute("CateVO")CateVO cateVO, HttpSession session, ModelMap map) throws Exception {
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		String currentDate = DateUtils.CurrentDate();
		
		cateVO.setReg_id(loginUserVO.getMp_id());
		cateVO.setReg_nm(loginUserVO.getMp_nm());
		cateVO.setReg_dt(currentDate);
		cateVO.setSys_id(loginUserVO.getMp_id());
		cateVO.setSys_nm(loginUserVO.getMp_nm());
		cateVO.setSys_dt(currentDate);
		
		int result = cateService.cateAddAction(cateVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", cateVO.getCate_id());
		
		return "jsonView";
	}
}
