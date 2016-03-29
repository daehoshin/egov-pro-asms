package asms.reg.common;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SequenceForEqPlMpDAO")
public class SequenceForEqPlMpDAO extends EgovAbstractDAO {
	
	public String EqPlMpSequenceInsertForSearch(String currentTime) throws Exception {
		return (String) insert("EqPlMpSequenceInsertForSearch", currentTime);
    }
	
}
