package asms.common.mp.service;

import java.util.List;

/**
 * @PackageName asms.common.mp.service
 * @FileName DeptMdService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
public interface MpMdService {

	List mpMdListSearch(MpMdVO vo) throws Exception;
	int mpMdListTotCntSearch(MpMdVO vo) throws Exception;
	
}
