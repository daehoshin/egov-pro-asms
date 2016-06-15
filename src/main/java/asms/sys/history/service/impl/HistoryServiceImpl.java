package asms.sys.history.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;
import asms.sys.history.service.HistoryService;
import asms.sys.history.service.HistoryVO;

@Service("HistoryService")
public class HistoryServiceImpl implements HistoryService{

	@Resource(name="HistoryDAO")
	private HistoryDAO historyDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List historyListSearch(HistoryVO vo) throws Exception {
		return historyDAO.historyListSearch(vo);
	}

	@Override
	public int historyListTotCntSearch(HistoryVO vo) throws Exception {
		return historyDAO.historyListTotCntSearch(vo);
	}

	@Override
	public HistoryVO historyInfoSearch(HistoryVO vo) throws Exception {
		return historyDAO.historyInfoSearch(vo);
	}

	@Override
	public int historyAddAction(HistoryVO vo) throws Exception {
		
		int result = 0;

		result = historyDAO.historyAdd(vo);
		
		return result;
	}
	
}
