package asms.test.cjh.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.login.service.LoginUserVO;
import asms.reg.plc.service.PlaceVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.reg.plc.service.impl
 * @FileName TestDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Repository("TestDAO")
public class TestDAO extends EgovAbstractDAO{
	
	public List testMethod(){
		return list("testListSearch", null);
		
	}

}
