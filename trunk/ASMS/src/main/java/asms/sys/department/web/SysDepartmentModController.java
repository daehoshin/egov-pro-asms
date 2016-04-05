package asms.sys.department.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.sys.department.service.DeptService;
import asms.sys.department.service.DeptVO;

/**
 * @PackageName asms.sys.department.web
 * @FileName SysDepartmentModController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Controller
public class SysDepartmentModController {
	
	@Resource(name = "DeptService")
	protected DeptService deptService;
	 
	@RequestMapping("/sys/department/departmentModForm.do")
	public String SysDepartmentModForm(@RequestParam("dept_id")String dept_id, ModelMap map) throws Exception{
		
    	DeptVO deptVO = new DeptVO();
    	deptVO.setDept_id(dept_id);
		
    	deptVO = deptService.deptInfoSearch(deptVO);
			
		map.addAttribute("deptVO", deptVO);
		
    	return "/sys/department/departmentMod";
	}
}
