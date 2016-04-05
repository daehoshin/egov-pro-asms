package asms.sys.department.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.plc.service.PlaceVO;
import asms.sys.department.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.sys.department.service.impl
 * @FileName DeptDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 4.
 */
@Repository("DeptDAO")
public class DeptDAO extends EgovAbstractDAO{
	List deptListSearch(DeptVO vo) throws Exception {
		return list("deptListSearch", vo);
    }

	int deptListTotCntSearch(DeptVO vo) throws Exception {
		return (Integer) selectByPk("deptListTotCntSearch", vo);
	}

	DeptVO deptInfoSearch(DeptVO vo) throws Exception {
		return (DeptVO) selectByPk("deptInfoSearch", vo);
	}
	
	int deptAdd(DeptVO vo) throws Exception {

		int result = 0;
		
		result = update("deptAdd", vo);  
			
		return result;
		
	}
	
}
