package asms.common.login.service;

import asms.common.login.service.LoginUserVO;

public interface LoginService {
	
	LoginUserVO selectLoginUserInfo(String userId) throws Exception;
	
}
