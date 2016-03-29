package asms.reg.common.service.impl;

import org.springframework.stereotype.Repository;

import asms.reg.common.service.SequenceForEqPlMpVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SequenceForEqPlMpDAO")
public class SequenceForEqPlMpDAO extends EgovAbstractDAO {
	
	public int EqPlMpSequenceInsertForSearch(SequenceForEqPlMpVO vo) throws Exception {
		return (Integer) getSqlMapClientTemplate().insert("EqPlMpSequenceInsertForSearch", vo);
    }
	
}
