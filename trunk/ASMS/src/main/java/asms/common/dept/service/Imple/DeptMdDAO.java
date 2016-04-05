package asms.common.dept.service.Imple;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.dept.service.DeptMdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.common.dept.service.Imple
 * @FileName DeptMdDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 5.
 */
@Repository("DeptMdDAO")
public class DeptMdDAO extends EgovAbstractDAO{
	
	List deptMdListSearch(DeptMdVO vo) throws Exception {
		return list("deptMdListSearch", vo);
    }

	int deptMdListTotCntSearch(DeptMdVO vo) throws Exception {
		return (Integer) selectByPk("deptMdListTotCntSearch", vo);
	}
	
}
