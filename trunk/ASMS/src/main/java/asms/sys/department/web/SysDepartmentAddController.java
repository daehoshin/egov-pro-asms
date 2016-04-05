package asms.sys.department.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.sys.department.service.DeptService;
import asms.sys.department.service.DeptVO;

/**
 * @PackageName asms.sys.department.web
 * @FileName SysDepartmentAddController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Controller
public class SysDepartmentAddController {
	
	@Resource(name = "DeptService")
    protected DeptService deptService;
	
	@RequestMapping("/sys/department/departmentAddForm.do")
	public String SysDepartmentAddForm() throws Exception {
	
		return "/sys/department/departmentAdd";
	}
	
	@RequestMapping("/sys/department/deptAddAction.do")
	public String SysDepartmentAddAction(@ModelAttribute("DeptVO")DeptVO deptVO, HttpSession session, ModelMap map) throws Exception {
		String resultMsg = "";

		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);

		String currentDate = DateUtils.CurrentDate();
		
		deptVO.setReg_id(loginUserVO.getMp_id());
		deptVO.setReg_nm(loginUserVO.getMp_nm());
		deptVO.setReg_dt(currentDate);
		deptVO.setSys_id(loginUserVO.getMp_id());
		deptVO.setSys_nm(loginUserVO.getMp_nm());
		deptVO.setSys_dt(currentDate);
		
		int result = deptService.deptAddAction(deptVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		map.addAttribute("resultId", deptVO.getDept_id());
		
		return "jsonView";
	}
}
