package asms.reg.eq.service;

import java.util.List;

/**
 * @PackageName asms.reg.eq.service
 * @FileName EquipmentService.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
public interface EquipmentService {
	List equipmentListSearch(EquipmentVO vo) throws Exception;
	int equipmentListTotCntSearch(EquipmentVO vo) throws Exception;
	int equipmentAddAction(EquipmentVO vo) throws Exception;
	EquipmentVO equipmentInfoSearch(EquipmentVO vo) throws Exception;
	int equipmentModAction(EquipmentVO vo) throws Exception;
	int equipmentRegFinishAction(EquipmentVO vo) throws Exception;
	EquipmentVO equipmentBaseInfoSearch(EquipmentVO vo) throws Exception;
	int EquipmentDelAction(EquipmentVO vo) throws Exception;
	int EquipmentSelectDelAction(EquipmentVO vo) throws Exception;
}
