package asms.common.store.service;

import java.util.List;

/**
 * @PackageName asms.common.store.service
 * @FileName DeptMdService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
public interface StoreMdService {

	List storeMdListSearch(StoreMdVO vo) throws Exception;
	int storeMdListTotCntSearch(StoreMdVO vo) throws Exception;
	
}
