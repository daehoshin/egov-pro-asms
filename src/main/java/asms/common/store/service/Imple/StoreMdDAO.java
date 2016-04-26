package asms.common.store.service.Imple;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.store.service.StoreMdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.common.store.service.Istorele
 * @FileName StoreMdDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 26.
 */
@Repository("StoreMdDAO")
public class StoreMdDAO extends EgovAbstractDAO{
	
	List storeMdListSearch(StoreMdVO vo) throws Exception {
		return list("storeMdListSearch", vo);
    }

	int storeMdListTotCntSearch(StoreMdVO vo) throws Exception {
		return (Integer) selectByPk("storeMdListTotCntSearch", vo);
	}
	
}
