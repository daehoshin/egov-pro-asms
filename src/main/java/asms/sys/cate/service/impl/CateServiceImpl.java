package asms.sys.cate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;
import asms.sys.cate.service.CateService;
import asms.sys.cate.service.CateVO;

@Service("CateService")
public class CateServiceImpl implements CateService{

	@Resource(name="CateDAO")
	private CateDAO cateDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List cateListSearch(CateVO vo) throws Exception {
		return cateDAO.cateListSearch(vo);
	}

	@Override
	public int cateListTotCntSearch(CateVO vo) throws Exception {
		return cateDAO.cateListTotCntSearch(vo);
	}

	@Override
	public CateVO cateInfoSearch(CateVO vo) throws Exception {
		return cateDAO.cateInfoSearch(vo);
	}

	@Override
	public int cateAddAction(CateVO vo) throws Exception {
		
		int result = 0;

		result = cateDAO.cateAdd(vo);
		
		return result;
	}
	
}
