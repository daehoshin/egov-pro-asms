package asms.sys.department.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import asms.common.Constants;
import asms.common.asset.service.AssetSequenceVO;
import asms.common.asset.service.impl.AssetSequenceDAO;
import asms.common.util.DateUtils;
import asms.reg.plc.service.PlaceVO;
import asms.sys.department.service.DeptService;
import asms.sys.department.service.DeptVO;

/**
 * @PackageName asms.sys.department.service.impl
 * @FileName DeptServiceImpl.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 4.
 */
@Service("DeptService")
public class DeptServiceImpl implements DeptService{

	@Resource(name="DeptDAO")
	private DeptDAO deptDAO;
	
	@Resource(name="AssetSequenceDAO")
	private AssetSequenceDAO assetSequenceDAO;
	
	@Override
	public List deptListSearch(DeptVO vo) throws Exception {
		return deptDAO.deptListSearch(vo);
	}

	@Override
	public int deptListTotCntSearch(DeptVO vo) throws Exception {
		return deptDAO.deptListTotCntSearch(vo);
	}

	@Override
	public DeptVO deptInfoSearch(DeptVO vo) throws Exception {
		return deptDAO.deptInfoSearch(vo);
	}

	@Override
	public int deptAddAction(DeptVO vo) throws Exception {
		
		int result = 0;

		result = deptDAO.deptAdd(vo);
		
		return result;
	}
	
}
