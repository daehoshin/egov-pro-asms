package asms.sign.export.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.sign.export.service.ExportEquipmentVO;
import asms.sign.export.service.ExportSearchVO;
import asms.sign.export.service.ExportVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.sign.export.service.impl
 * @FileName TestDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Repository("ExportDAO")
public class ExportDAO extends EgovAbstractDAO{

	int exportAdd(ExportVO vo) throws Exception {
		
		int result = 0;
		result = update("exportAdd", vo);  
			
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	List exportListSearch(ExportSearchVO vo) throws Exception {
		return list("exportListSearch", vo);
    }

	int exportListTotCntSearch(ExportSearchVO vo) throws Exception {
		return (Integer) selectByPk("exportListTotCntSearch", vo);
	}

	ExportVO exportInfoSearch(ExportVO vo) throws Exception{
		return (ExportVO)selectByPk("exportInfoSearch", vo);
	}
	
	@SuppressWarnings("rawtypes")
	List exportEquipmentListSearch(ExportEquipmentVO vo) throws Exception {
		return list("exportEquipmentListSearch", vo);
    }

	int exportEquipmentListTotCntSearch(ExportEquipmentVO vo) throws Exception {
		return (Integer) selectByPk("exportEquipmentListTotCntSearch", vo);
	}
}
