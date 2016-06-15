package asms.sys.history.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.history.service.HistoryService;
import asms.sys.history.service.HistoryVO;

@Controller
public class SysHistoryViewController {
	
	@Resource(name = "HistoryService")
    protected HistoryService historyService;
	
	@RequestMapping("/sys/history/historyViewForm.do")
	public String SysHistoryView(@RequestParam("history_id")String history_id, ModelMap map) throws Exception{
		HistoryVO historyVO = new HistoryVO();
		historyVO.setHistory_id(history_id);
		
		historyVO = historyService.historyInfoSearch(historyVO);
			
		map.addAttribute("historyVO", historyVO);
		
		return "/sys/history/historyView";
	}
}
