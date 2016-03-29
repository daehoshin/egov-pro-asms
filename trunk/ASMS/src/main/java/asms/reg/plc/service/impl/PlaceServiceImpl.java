package asms.reg.plc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import asms.common.util.DateUtils;
import asms.reg.common.SequenceForEqPlMpDAO;
import asms.reg.common.SequenceForEqPlMpVO;
import asms.reg.plc.service.PlaceService;
import asms.reg.plc.service.PlaceVO;

/**
 * @PackageName asms.reg.plc.service.impl
 * @FileName PlaceServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService{

	@Resource(name="PlaceDAO")
	private PlaceDAO placeDAO;
	
	@Resource(name="SequenceForEqPlMpDAO")
	private SequenceForEqPlMpDAO sequenceForEqPlMpDAO;
	
	@Override
	public List placeListSearch(PlaceVO vo) throws Exception {
		return placeDAO.placeListSearch(vo);
	}

	@Override
	public int placeAddAction(PlaceVO vo) throws Exception {
		
		int result = 0;
		
		SequenceForEqPlMpVO seqVO = new SequenceForEqPlMpVO();
		
		String currentDate = DateUtils.CurrentDate();
		
		seqVO.setSeq_dt(currentDate);
		vo.setReg_dt(currentDate);
		vo.setSys_dt(currentDate);
		
		try {
			
			int pk = sequenceForEqPlMpDAO.EqPlMpSequenceInsertForSearch(seqVO);
			vo.setPlc_id(Integer.toString(pk));
			
			result = placeDAO.placeAddAction(vo);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

}
