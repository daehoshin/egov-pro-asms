package asms.reg.plc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
	
	@Override
	public List placeListSearch(PlaceVO vo) throws Exception {
		return placeDAO.placeListSearch(vo);
	}

}
