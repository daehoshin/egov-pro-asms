package asms.common.asset.service;

/**
 * @PackageName asms.common.asset.service
 * @FileName AssetService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
public interface AssetService {
	AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception;
	int AssetDelAction(AssetBaseInfoVO assetBaseInfoVO) throws Exception;
}
