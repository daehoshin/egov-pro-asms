package asms.common.dept.service;

import java.util.List;

/**
 * @PackageName asms.common.dept.service
 * @FileName DeptMdService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
public interface DeptMdService {

	List deptMdListSearch(DeptMdVO vo) throws Exception;
	int deptMdListTotCntSearch(DeptMdVO vo) throws Exception;
	
}
