package asms.sys.menu.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.sys.department.service.DeptVO;
import asms.sys.menu.service.MenuVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("MenuDAO")
public class MenuDAO extends EgovAbstractDAO{
	List menuListSearch(MenuVO vo) throws Exception {
		return list("menuListSearch", vo);
    }

	int menuListTotCntSearch(MenuVO vo) throws Exception {
		return (Integer) selectByPk("menuListTotCntSearch", vo);
	}
	
	int menuAdd(MenuVO vo) throws Exception {

		int result = 0;
		
		result = update("menuAdd", vo);  
			
		return result;
		
	}
}
