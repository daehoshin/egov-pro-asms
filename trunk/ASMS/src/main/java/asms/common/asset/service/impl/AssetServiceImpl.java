package asms.common.asset.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetService;

@Service("AssetService")
public class AssetServiceImpl implements AssetService{
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		return assetSequenceDAO.AssetBaseInfoSearch(assetBaseInfoVO);
	}
	
}
