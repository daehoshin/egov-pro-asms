package asms.reg.af.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegAttachedFileController {
	@RequestMapping("/rgst/attachedfile.do")
	public String RegAttachedFile() throws Exception{
		return "/reg/attachedfile/regAttachedFile";
	}
}
