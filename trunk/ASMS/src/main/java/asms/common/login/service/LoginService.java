package asms.common.login.service;

import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.common.login.service
 * @FileName LoginService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 24.
 */
public interface LoginService {
	
	LoginUserVO selectLoginUserInfo(String userId) throws Exception;
	
}
