package asms.sys.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.sys.department.service.DeptVO;
import asms.sys.department.service.impl.DeptDAO;
import asms.sys.menu.service.MenuService;
import asms.sys.menu.service.MenuVO;

/**
 * @PackageName asms.sys.menu.service.impl
 * @FileName MenuServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 13.
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService{
	@Resource(name="MenuDAO")
	private MenuDAO menuDAO;
	
	@Override
	public List menuListSearch(MenuVO vo) throws Exception {
		return menuDAO.menuListSearch(vo);
	}

	@Override
	public int menuListTotCntSearch(MenuVO vo) throws Exception {
		return menuDAO.menuListTotCntSearch(vo);
	}
	
	@Override
	public int menuAddAction(MenuVO vo) throws Exception {
		
		int result = 0;

		result = menuDAO.menuAdd(vo);
		
		return result;
	}
	
	@Override
	public MenuVO menuInfoSearch(MenuVO vo) throws Exception {
		return menuDAO.menuInfoSearch(vo);
	}
	
}
