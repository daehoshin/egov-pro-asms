package asms.sign.export.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.sign.export.service.ExportSearchVO;
import asms.sign.export.service.ExportService;
import asms.sign.export.service.ExportVO;

/**
 * @PackageName asms.reg.plc.service.impl
 * @FileName PlaceServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 26.
 */
@Service("ExportService")
public class ExportServiceImpl implements ExportService{

	@Resource(name="ExportDAO")
	private ExportDAO exportDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;

	@Override
	public int exportAddAction(ExportVO vo) throws Exception {
		
		AssetSequenceVO assetSequenceVO = new AssetSequenceVO();
		
		String currentDate = DateUtils.CurrentDate();
		
		assetSequenceVO.setSeq_dt(currentDate);
		int pk = assetSequenceDAO.exportSequenceInsertForSearch(assetSequenceVO);
		
		StringBuffer sb = new StringBuffer();
		sb.append(Constants.Export_MngNo_Code);
		sb.append("-");
		sb.append(String.format("%010d",pk));
		vo.setReg_dt(currentDate);
		vo.setSys_dt(currentDate);
		vo.setApp_id(Integer.toString(pk));
		vo.setApp_no(sb.toString());
		vo.setApp_cd(Constants.RegStatus_Temporarily);
		
		int result = exportDAO.exportAdd(vo);
	
		return result;
	}

	@Override
	public List exportListSearch(ExportSearchVO vo) throws Exception {
		return exportDAO.exportListSearch(vo);
	}

	@Override
	public int exportListTotCntSearch(ExportSearchVO vo) throws Exception {
		return exportDAO.exportListTotCntSearch(vo);
	}
	
	

}
