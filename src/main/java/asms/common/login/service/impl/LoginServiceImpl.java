package asms.common.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import asms.common.login.service.LoginService;
import asms.common.login.service.LoginUserVO;

/**
 * @PackageName asms.common.login.service.impl
 * @FileName LoginServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 24.
 */
@Service("LoginService")
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService {
	
	@Resource(name="LoginDAO")
	private LoginDAO LoginDAO;
	
	public LoginUserVO selectLoginUserInfo(String userId) throws Exception {
		return LoginDAO.selectLoginUserInfo(userId);
	}

}
