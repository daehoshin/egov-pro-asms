package asms.sign.export.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import asms.sign.export.service.ExportVO;

/**
 * @PackageName asms.sign.export.web
 * @FileName ExportController.java
 * @Author Jinho Jung
 * @Since 2016. 4. 03.
 */
@Controller
public class ExportController {
	@RequestMapping("/sign/export/export.do")
	public String export() throws Exception{
		return "/sign/export/export";
	}
}
