package asms.sys.department.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysDepartmentAddController {
	@RequestMapping("/sys/department/departmentAddForm.do")
	public String SysDepartmentAddForm() throws Exception {
	
		return "/sys/department/departmentAdd";
	}
}
