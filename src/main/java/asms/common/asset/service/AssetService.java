package asms.common.asset.service;

public interface AssetService {
	AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception;
	int AssetDelAction(AssetBaseInfoVO assetBaseInfoVO) throws Exception;
}
