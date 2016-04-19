package asms.test.cjh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.reg.plc.service.impl.PlaceDAO;
import asms.test.cjh.service.TestService;

/**
 * @PackageName asms.reg.plc.service.impl
 * @FileName TestServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Service("TestService")
public class TestServiceImpl implements TestService{

	@Resource(name="TestDAO")
	private TestDAO testDAO;
	
	@Override
	public List testListSearch() throws Exception {
		List testDao = testDAO.testMethod();
		return testDao;
	}

	

}
