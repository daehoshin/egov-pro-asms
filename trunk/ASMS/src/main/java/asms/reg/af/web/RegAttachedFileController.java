package asms.reg.af.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.af.web
 * @FileName RegAttachedFileController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class RegAttachedFileController {
	@RequestMapping("/reg/attachedfile/attachedfile.do")
	public String RegAttachedFile() throws Exception{
		return "/reg/attachedfile/regAttachedFile";
	}
}
