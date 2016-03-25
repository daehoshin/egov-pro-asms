package asms.reg.as.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegAssetController {
	@RequestMapping("/rgst/asset.do")
	public String RegAsset() throws Exception{
		return "/reg/asset/regAsset";
	}
}
