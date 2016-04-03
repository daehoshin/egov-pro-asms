package asms.sign.export.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.sign.export.web
 * @FileName SignExportController.java
 * @Author Jinho Jung
 * @Since 2016. 4. 03.
 */
@Controller
public class SignExportController {
	@RequestMapping("/sign/export/export.do")
	public String RegManPower() throws Exception{
		return "/sign/export/export";
	}
}
