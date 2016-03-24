package asms.common.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import asms.common.main.service.impl.MainDAO;

import org.springframework.stereotype.Service;

import asms.common.login.service.LoginUserVO;
import asms.common.main.service.MainService;

@Service("MainService")
public class MainServiceImpl implements MainService {
	
	@Resource(name="mainDAO")
	private MainDAO mainDAO;
	
	public List selectMenuList_lv1(LoginUserVO loginUserVO) throws Exception {
		return mainDAO.selectMenuList_lv1(loginUserVO);
	}
	
	public List selectMenuList_lv2(LoginUserVO loginUserVO) throws Exception { 
		return mainDAO.selectMenuList_lv2(loginUserVO);
	}
	
	public List selectMenuList_lv3(LoginUserVO loginUserVO) throws Exception { 
		return mainDAO.selectMenuList_lv3(loginUserVO);
	}
	
}
