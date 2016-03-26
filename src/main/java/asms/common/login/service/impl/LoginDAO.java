package asms.common.login.service.impl;

import asms.common.login.service.LoginUserVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.common.login.service.impl
 * @FileName LoginDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 24.
 */
@Repository("LoginDAO")
public class LoginDAO extends EgovAbstractDAO{
	
	public LoginUserVO selectLoginUserInfo(String userId) throws Exception {
		return (LoginUserVO) selectByPk("selectLoginUserInfo", userId);
    }
	
}
