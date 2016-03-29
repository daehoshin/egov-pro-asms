package asms.reg.plc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import asms.reg.common.SequenceForEqPlMpDAO;
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
	public String RegPlaceAddAction(PlaceVO vo) throws Exception {
		
		String result = "";
		String currentTime = "";
		try {
			String pk = sequenceForEqPlMpDAO.EqPlMpSequenceInsertForSearch(currentTime);
			placeDAO.RegPlaceAddAction(vo);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

}
