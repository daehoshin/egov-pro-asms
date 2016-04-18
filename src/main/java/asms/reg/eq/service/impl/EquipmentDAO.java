package asms.reg.eq.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import asms.common.login.service.LoginUserVO;
import asms.reg.eq.service.EquipmentVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @PackageName asms.reg.eq.service.impl
 * @FileName EquipmentDAO.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Repository("EquipmentDAO")
public class EquipmentDAO extends EgovAbstractDAO{
	
	List equipmentListSearch(EquipmentVO vo) throws Exception {
		return list("equipmentListSearch", vo);
    }

	int equipmentListTotCntSearch(EquipmentVO vo) throws Exception {
		return (Integer) selectByPk("equipmentListTotCntSearch", vo);
	}

	int equipmentMainAdd(EquipmentVO vo) throws Exception {
		
		int result = 0;

		result = update("equipmentMainAdd", vo);  
			
		return result;
	}
	
	int equipmentDetailAdd(EquipmentVO vo) throws Exception {

		int result = 0;
		
		result = update("equipmentDetailAdd", vo);  
			
		return result;
		
	}
	
	EquipmentVO equipmentInfoSearch(EquipmentVO vo) throws Exception {
		return (EquipmentVO) selectByPk("equipmentInfoSearch", vo);
	}
	
	int equipmentMainMod(EquipmentVO vo) throws Exception {
		
		int result = 0;
			
		result = update("equipmentMainMod", vo);  
		
		return result;
	}
	
	int equipmentDetailMod(EquipmentVO vo) throws Exception {

		int result = 0;
		
		result = update("equipmentDetailMod", vo);  
		
		return result;
		
	}
	
	int equipmentRegFinishAction(EquipmentVO vo) throws Exception {
		
		int result = 0;
			
		result = update("equipmentRegFinishAction", vo);  
			
		return result;
		
	}
	
	EquipmentVO equipmentBaseInfoSearch(EquipmentVO vo) throws Exception {
		return (EquipmentVO) selectByPk("equipmentBaseInfoSearch", vo);
	}

	int EquipmentDelAction(EquipmentVO vo) throws Exception {
		return update("EquipmentDelAction", vo);
	}

	int EquipmentSelectDelAction(EquipmentVO vo) throws Exception {
		return update("EquipmentSelectDelAction", vo);
	}

}
