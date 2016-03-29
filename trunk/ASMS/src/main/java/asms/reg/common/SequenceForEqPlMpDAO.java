package asms.reg.common;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SequenceForEqPlMpDAO")
public class SequenceForEqPlMpDAO extends EgovAbstractDAO {
	
	public int EqPlMpSequenceInsertForSearch(SequenceForEqPlMpVO vo) throws Exception {
		return update("EqPlMpSequenceInsertForSearch", vo);
    }
	
}
