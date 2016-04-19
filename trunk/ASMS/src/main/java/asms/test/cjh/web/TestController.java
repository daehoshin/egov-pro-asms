package asms.test.cjh.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.test.cjh.service.TestService;

/**
 * @PackageName asms.reg.plc.web
 * @FileName RegPlaceController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class TestController {
	
	@Resource(name = "TestService")
    protected TestService testService;
	
	@RequestMapping("/test/cjh/test.do")
	public String test(HttpSession session, ModelMap map) throws Exception{
		List data = testService.testListSearch();
		map.put("testData", data);
		return "/asms/test/cjh/test";
	}
	
}
