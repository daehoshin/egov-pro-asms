package asms.common.main.service;

import java.util.List;

import asms.common.login.service.LoginUserVO;

public interface MainService {

	List selectMenuList_lv1(LoginUserVO loginUserVO) throws Exception;
	List selectMenuList_lv2(LoginUserVO loginUserVO) throws Exception;
	List selectMenuList_lv3(LoginUserVO loginUserVO) throws Exception;
	
}
