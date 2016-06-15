package asms.sys.history.service;

import java.util.List;

import asms.reg.plc.service.PlaceVO;

public interface HistoryService {
	List historyListSearch(HistoryVO vo) throws Exception;
	int historyListTotCntSearch(HistoryVO vo) throws Exception;
	HistoryVO historyInfoSearch(HistoryVO vo) throws Exception;
	int historyAddAction(HistoryVO vo) throws Exception;
}
