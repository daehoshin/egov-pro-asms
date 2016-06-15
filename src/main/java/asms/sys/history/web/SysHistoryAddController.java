package asms.sys.history.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.history.service.HistoryService;
import asms.sys.history.service.HistoryVO;

@Controller
public class SysHistoryAddController {
	
	@Resource(name = "HistoryService")
    protected HistoryService historyService;
	
	@RequestMapping("/sys/history/historyAddForm.do")
	public String SysHistoryAddForm() throws Exception {
	
		return "/sys/history/historyAdd";
	}
	
	@RequestMapping("/sys/history/historyAddAction.do")
	public String SysHistoryAddAction(@ModelAttribute("HistoryVO")HistoryVO historyVO, HttpSession session, ModelMap map) throws Exception {
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		String currentDate = DateUtils.CurrentDate();
		
		historyVO.setReg_id(loginUserVO.getMp_id());
		historyVO.setReg_nm(loginUserVO.getMp_nm());
		historyVO.setReg_dt(currentDate);
		historyVO.setSys_id(loginUserVO.getMp_id());
		historyVO.setSys_nm(loginUserVO.getMp_nm());
		historyVO.setSys_dt(currentDate);
		
		int result = historyService.historyAddAction(historyVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", historyVO.getHistory_id());
		
		return "jsonView";
	}
}
