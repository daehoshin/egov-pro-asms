package asms.common.dept.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.dept.service.DeptMdService;
import asms.common.dept.service.DeptMdVO;

/**
 * @PackageName asms.common.dept.service.Imple
 * @FileName DeptMdServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Service("DeptMdService")
public class DeptMdServiceImpl implements DeptMdService{

	@Resource(name="DeptMdDAO")
	private DeptMdDAO deptMdDAO;
	
	@Override
	public List deptMdListSearch(DeptMdVO vo) throws Exception {
		return deptMdDAO.deptMdListSearch(vo);
	}

	@Override
	public int deptMdListTotCntSearch(DeptMdVO vo) throws Exception {
		return deptMdDAO.deptMdListTotCntSearch(vo);
	}
}
