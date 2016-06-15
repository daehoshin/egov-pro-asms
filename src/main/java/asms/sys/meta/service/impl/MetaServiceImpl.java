package asms.sys.meta.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;
import asms.sys.meta.service.MetaService;
import asms.sys.meta.service.MetaVO;

@Service("MetaService")
public class MetaServiceImpl implements MetaService{

	@Resource(name="MetaDAO")
	private MetaDAO metaDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List metaListSearch(MetaVO vo) throws Exception {
		return metaDAO.metaListSearch(vo);
	}

	@Override
	public int metaListTotCntSearch(MetaVO vo) throws Exception {
		return metaDAO.metaListTotCntSearch(vo);
	}

	@Override
	public MetaVO metaInfoSearch(MetaVO vo) throws Exception {
		return metaDAO.metaInfoSearch(vo);
	}

	@Override
	public int metaAddAction(MetaVO vo) throws Exception {
		
		int result = 0;

		result = metaDAO.metaAdd(vo);
		
		return result;
	}
	
}
