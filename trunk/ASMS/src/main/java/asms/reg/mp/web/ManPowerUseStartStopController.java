package asms.reg.mp.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asms.common.Constants;
import asms.common.login.service.LoginUserVO;
import asms.common.util.DateUtils;
import asms.reg.mp.service.ManPowerService;
import asms.reg.mp.service.ManPowerVO;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.mp.web
 * @FileName RegManPowerFinishController.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 9.
 */
@Controller
public class ManPowerUseStartStopController {

	@Resource(name = "ManPowerService")
    protected ManPowerService manPowerService;
	
	@RequestMapping("/rgst/manpower/ManPowerUseStartStopAction.do")
	public String ManPowerUseStartStop(@RequestParam("update_flag")String update_flag,@RequestParam("mp_id")String mp_id, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		ManPowerVO manPowerVO = new ManPowerVO();
		
		manPowerVO.setMp_id(mp_id);
		manPowerVO.setUse_flag(update_flag);
		manPowerVO.setSys_id(loginUserVO.getMp_id());
		manPowerVO.setSys_nm(loginUserVO.getMp_nm());
		
		int result = manPowerService.manPowerUseStartStopAction(manPowerVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}

	@RequestMapping("/rgst/manpower/manPowerSelectUseStartAction.do")
	public String ManPowerSelectUseStart(@ModelAttribute("ManPowerVO") ManPowerVO manPowerVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		String[] mp_id_array = manPowerVO.getMp_id().split(",");
		manPowerVO.setMp_id_array(mp_id_array);
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		manPowerVO.setUse_flag(Constants.UserStatus_true);
		manPowerVO.setSys_id(loginUserVO.getMp_id());
		manPowerVO.setSys_nm(loginUserVO.getMp_nm());
		manPowerVO.setSys_dt(currentDate);
		
		int result = manPowerService.ManPowerSelectUseStartAction(manPowerVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}
	
	@RequestMapping("/rgst/manpower/manPowerSelectUseStopAction.do")
	public String ManPowerSelectUseStop(@ModelAttribute("ManPowerVO") ManPowerVO manPowerVO, HttpSession session, ModelMap map) throws Exception{
		
		String resultMsg = "";
		
		String[] mp_id_array = manPowerVO.getMp_id().split(",");
		manPowerVO.setMp_id_array(mp_id_array);
		LoginUserVO loginUserVO = (LoginUserVO)session.getAttribute(Constants.LoginUserVO);
		String currentDate = DateUtils.CurrentDate();
		
		manPowerVO.setUse_flag(Constants.UserStatus_false);
		manPowerVO.setSys_id(loginUserVO.getMp_id());
		manPowerVO.setSys_nm(loginUserVO.getMp_nm());
		manPowerVO.setSys_dt(currentDate);
		
		int result = manPowerService.ManPowerSelectUseStopAction(manPowerVO);
		
		if(result==1){
			resultMsg = "success";
		} else {
			resultMsg = "fail";
		}
		
		map.addAttribute("resultMsg", resultMsg);
		
		return "jsonView";
	}

}
