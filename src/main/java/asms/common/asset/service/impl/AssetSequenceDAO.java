package asms.common.asset.service.impl;

import org.springframework.stereotype.Repository;

import asms.common.Constants;
import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetSequenceVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.common.asset.service.impl
 * @FileName AssetSequenceDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 30.
 */
@Repository("AssetSequenceDAO")
public class AssetSequenceDAO extends EgovAbstractDAO {
	
	public int AssetSequenceInsertForSearch(AssetSequenceVO assetSequenceVO) throws Exception {
		return (Integer) getSqlMapClientTemplate().insert("AssetSequenceInsertForSearch", assetSequenceVO);
    }
	
	public AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		
		AssetBaseInfoVO resultVO = new AssetBaseInfoVO();
		
		if(Constants.Place_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			resultVO = (AssetBaseInfoVO) selectByPk("AssetPlaceBaseInfoSearch", assetBaseInfoVO);
		} else if(Constants.ManPower_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			resultVO = (AssetBaseInfoVO) selectByPk("AssetManPowerBaseInfoSearch", assetBaseInfoVO);
		} else if(Constants.Equipment_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			resultVO = (AssetBaseInfoVO) selectByPk("AssetEquipmentBaseInfoSearch", assetBaseInfoVO);
		}
		return resultVO;
	}
	
	public int AssetDelAction(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		
		int result  = 0;
		
		if(Constants.Place_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			result = update("AssetPlaceDelAction", assetBaseInfoVO);
		} else if(Constants.ManPower_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			result = update("AssetManPowerDelAction", assetBaseInfoVO);
		} else if(Constants.Equipment_MngNo_Code.equals(assetBaseInfoVO.getAsset_type())){
			result = update("AssetEquipmentDelAction", assetBaseInfoVO);
		}
		
		return result;
	}
	
}
