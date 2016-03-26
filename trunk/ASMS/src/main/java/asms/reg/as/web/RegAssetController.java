package asms.reg.as.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName asms.reg.as.web
 * @FileName RegAssetController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 25.
 */
@Controller
public class RegAssetController {
	@RequestMapping("/reg/asset/asset.do")
	public String RegAsset() throws Exception{
		return "/reg/asset/regAsset";
	}
}
