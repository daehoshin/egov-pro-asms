package asms.common.asset.service.impl;

import org.springframework.stereotype.Repository;

import asms.common.asset.service.AssetBaseInfoVO;
import asms.common.asset.service.AssetSequenceVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("AssetSequenceDAO")
public class AssetSequenceDAO extends EgovAbstractDAO {
	
	public int AssetSequenceInsertForSearch(AssetSequenceVO assetSequenceVO) throws Exception {
		return (Integer) getSqlMapClientTemplate().insert("AssetSequenceInsertForSearch", assetSequenceVO);
    }
	
	public AssetBaseInfoVO AssetBaseInfoSearch(AssetBaseInfoVO assetBaseInfoVO) throws Exception {
		return (AssetBaseInfoVO) selectByPk("AssetBaseInfoSearch", assetBaseInfoVO);
	}
	
}
