package asms.common.mp.service.Imple;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.mp.service.MpMdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.common.mp.service.Imple
 * @FileName MpMdDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Repository("MpMdDAO")
public class MpMdDAO extends EgovAbstractDAO{
	
	List mpMdListSearch(MpMdVO vo) throws Exception {
		return list("mpMdListSearch", vo);
    }

	int mpMdListTotCntSearch(MpMdVO vo) throws Exception {
		return (Integer) selectByPk("mpMdListTotCntSearch", vo);
	}
	
}
