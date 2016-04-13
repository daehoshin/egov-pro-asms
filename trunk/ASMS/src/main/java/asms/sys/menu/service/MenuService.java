package asms.sys.menu.service;

import java.util.List;

import asms.sys.department.service.DeptVO;

public interface MenuService {
	List menuListSearch(MenuVO vo) throws Exception;
	int menuListTotCntSearch(MenuVO vo) throws Exception;
	int menuAddAction(MenuVO vo) throws Exception;
}
