package asms.sys.menu.service;

import java.util.List;

import asms.sys.department.service.DeptVO;

/**
 * @PackageName asms.sys.menu.service
 * @FileName MenuService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
public interface MenuService {
	List menuListSearch(MenuVO vo) throws Exception;
	int menuListTotCntSearch(MenuVO vo) throws Exception;
	int menuAddAction(MenuVO vo) throws Exception;
	MenuVO menuInfoSearch(MenuVO vo) throws Exception;
}
