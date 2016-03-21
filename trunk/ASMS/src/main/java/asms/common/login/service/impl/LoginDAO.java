package asms.common.login.service.impl;

import asms.common.login.service.LoginUserVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("LoginDAO")
public class LoginDAO extends EgovAbstractDAO{
	
	public LoginUserVO selectLoginUserInfo(String userId) throws Exception {
		return (LoginUserVO) selectByPk("selectLoginUserInfo", userId);
    }
	
}
