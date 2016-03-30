package asms.reg.plc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
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
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List placeListSearch(PlaceVO vo) throws Exception {
		return placeDAO.placeListSearch(vo);
	}

	@Override
	public int placeAddAction(PlaceVO vo) throws Exception {
		
		int result = 0;
		int mainResult = 0;
		int detailResult = 0;
		
		AssetSequenceVO assetSequenceVO = new AssetSequenceVO();
		
		String currentDate = DateUtils.CurrentDate();
		
		assetSequenceVO.setSeq_dt(currentDate);
		vo.setReg_dt(currentDate);
		vo.setSys_dt(currentDate);
		
		try {
			
			int pk = assetSequenceDAO.AssetSequenceInsertForSearch(assetSequenceVO);
			StringBuffer sb = new StringBuffer();
			sb.append(Constants.Place_MngNo_Code);
			sb.append("-");
			sb.append(StringUtils.leftPad(Integer.toString(pk), 7, "0"));
			
			vo.setPlc_id(Integer.toString(pk));
			vo.setPlc_mng_no(sb.toString());
			vo.setReg_status(Constants.RegStatus_Temporarily);
			
			mainResult = placeDAO.placeMainAdd(vo);
			detailResult = placeDAO.placeDetailAdd(vo);
			
			if(mainResult==1&&detailResult==1){
				result = 1;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public PlaceVO placeInfoSearch(PlaceVO vo) throws Exception{
		return placeDAO.placeInfoSearch(vo);
	}
	
	@Override
	public int placeModAction(PlaceVO vo) throws Exception {
		
		int result = 0;
		int mainResult = 0;
		int detailResult = 0;
		
		String currentDate = DateUtils.CurrentDate();
		
		vo.setSys_dt(currentDate);
		
		try {
			
			mainResult = placeDAO.placeMainMod(vo);
			detailResult = placeDAO.placeDetailMod(vo);
			
			if(mainResult==1&&detailResult==1){
				result = 1;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int placeRegFinishAction(PlaceVO vo) throws Exception {
		
		int result = 0;
		
		String currentDate = DateUtils.CurrentDate();
		
		vo.setSys_dt(currentDate);
		vo.setReg_status(Constants.RegStatus_Finish);
		
		try {
			
			result = placeDAO.placeRegFinishAction(vo);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

}
