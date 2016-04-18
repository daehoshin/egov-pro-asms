package asms.reg.eq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.eq.service.EquipmentService;
import asms.reg.eq.service.EquipmentVO;

/**
 * @PackageName asms.reg.eq.service.impl
 * @FileName EquipmentServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
@Service("EquipmentService")
public class EquipmentServiceImpl implements EquipmentService{

	@Resource(name="EquipmentDAO")
	private EquipmentDAO equipmentDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List equipmentListSearch(EquipmentVO vo) throws Exception {
		return equipmentDAO.equipmentListSearch(vo);
	}

	@Override
	public int equipmentListTotCntSearch(EquipmentVO vo) throws Exception {
		return equipmentDAO.equipmentListTotCntSearch(vo);
	}

	@Override
	public int equipmentAddAction(EquipmentVO vo) throws Exception {
		
		int result = 0;
		int mainResult = 0;
		int detailResult = 0;
		
		AssetSequenceVO assetSequenceVO = new AssetSequenceVO();
		
		String currentDate = DateUtils.CurrentDate();
		
		assetSequenceVO.setSeq_dt(currentDate);
		vo.setReg_dt(currentDate);
		vo.setSys_dt(currentDate);
			
		int pk = assetSequenceDAO.AssetSequenceInsertForSearch(assetSequenceVO);
		StringBuffer sb = new StringBuffer();
		sb.append(Constants.Equipment_MngNo_Code);
		sb.append("-");
		sb.append(StringUtils.leftPad(Integer.toString(pk), 7, "0"));
		
		vo.setEqm_id(Integer.toString(pk));
		vo.setEqm_mng_no(sb.toString());
		vo.setReg_status(Constants.RegStatus_Temporarily);
		
		mainResult = equipmentDAO.equipmentMainAdd(vo);
		detailResult = equipmentDAO.equipmentDetailAdd(vo);
		
		if(mainResult==1&&detailResult==1){
			result = 1;
		}
			
		return result;
	}
	
	@Override
	public EquipmentVO equipmentInfoSearch(EquipmentVO vo) throws Exception{
		return equipmentDAO.equipmentInfoSearch(vo);
	}
	
	@Override
	public int equipmentModAction(EquipmentVO vo) throws Exception {
		
		int result = 0;
		int mainResult = 0;
		int detailResult = 0;
		
		String currentDate = DateUtils.CurrentDate();
		
		vo.setSys_dt(currentDate);
		
			
		mainResult = equipmentDAO.equipmentMainMod(vo);
		detailResult = equipmentDAO.equipmentDetailMod(vo);
		
		if(mainResult==1&&detailResult==1){
			result = 1;
		}
			
		return result;
	}

	@Override
	public int EquipmentDelAction(EquipmentVO vo) throws Exception{
		
		int result = 0;
		
		result = equipmentDAO.EquipmentDelAction(vo);
			
		return result;
	}

	@Override
	public int EquipmentSelectDelAction(EquipmentVO vo) throws Exception{
		
		int result = 0;
		
		result = equipmentDAO.EquipmentSelectDelAction(vo);
			
		return result;
	}

	@Override
	public int equipmentRegFinishAction(EquipmentVO vo) throws Exception {
		
		int result = 0;
		
		String currentDate = DateUtils.CurrentDate();
		
		vo.setSys_dt(currentDate);
		vo.setReg_status(Constants.RegStatus_Finish);
			
		result = equipmentDAO.equipmentRegFinishAction(vo);
			
		return result;
	}
	
	@Override
	public EquipmentVO equipmentBaseInfoSearch(EquipmentVO vo) throws Exception{
		return equipmentDAO.equipmentBaseInfoSearch(vo);
	}

}
