package asms.common.asset.service.impl;

import org.springframework.stereotype.Repository;

import asms.common.Constants;
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
	
	public int exportSequenceInsertForSearch(AssetSequenceVO assetSequenceVO) throws Exception {
		return (Integer) getSqlMapClientTemplate().insert("ExportSequenceInsertForSearch", assetSequenceVO);
    }
}
