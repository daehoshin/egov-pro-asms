package asms.sys.department.service;

import java.util.List;

import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.sys.department.service
 * @FileName DeptService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 4.
 */
public interface DeptService {
	List deptListSearch(DeptVO vo) throws Exception;
	int deptListTotCntSearch(DeptVO vo) throws Exception;
	DeptVO deptInfoSearch(DeptVO vo) throws Exception;
	int deptAddAction(DeptVO vo) throws Exception;
}
