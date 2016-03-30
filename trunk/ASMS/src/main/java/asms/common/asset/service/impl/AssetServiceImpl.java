package asms.common.asset.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetService;

/**
 * @PackageName asms.common.asset.service.impl
 * @FileName AssetServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Service("AssetService")
public class AssetServiceImpl implements AssetService{
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		return assetSequenceDAO.AssetBaseInfoSearch(assetBaseInfoVO);
	}

	@Override
	public int AssetDelAction(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		return assetSequenceDAO.AssetDelAction(assetBaseInfoVO);
	}
	
}
