package asms.sys.history.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.reg.plc.service.PlaceVO;
import asms.sys.history.service.HistoryVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("HistoryDAO")
public class HistoryDAO extends EgovAbstractDAO{
	List historyListSearch(HistoryVO vo) throws Exception {
		return list("historyListSearch", vo);
    }

	int historyListTotCntSearch(HistoryVO vo) throws Exception {
		return (Integer) selectByPk("historyListTotCntSearch", vo);
	}

	HistoryVO historyInfoSearch(HistoryVO vo) throws Exception {
		return (HistoryVO) selectByPk("historyInfoSearch", vo);
	}
	
	int historyAdd(HistoryVO vo) throws Exception {

		int result = 0;
		
		result = update("historyAdd", vo);  
			
		return result;
		
	}
	
}
