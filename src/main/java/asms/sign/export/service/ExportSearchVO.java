package asms.sign.export.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;


/**
 * @PackageName asms.sign.export.web
 * @FileName ExportVO.java
 * @Author Jinho Jung
 * @Since 2016. 4. 09.
 * 반출신청서 VO
 */
public class ExportSearchVO extends ExportVO{
	private String mp_id;
	private String app_dt_st;       //신청일자 시작
	private String app_dt_ed;       //신청일자 종료
	private String confirm_dt_st;   //처리일자 시작
	private String confirm_dt_ed;   //처리일자 종료
	
	
	public String getMp_id() {
		return mp_id;
	}
	public void setMp_id(String mp_id) {
		this.mp_id = mp_id;
	}
	public String getApp_dt_st() {
		return app_dt_st;
	}
	public void setApp_dt_st(String app_dt_st) {
		this.app_dt_st = app_dt_st;
	}
	public String getApp_dt_ed() {
		return app_dt_ed;
	}
	public void setApp_dt_ed(String app_dt_ed) {
		this.app_dt_ed = app_dt_ed;
	}
	public String getConfirm_dt_st() {
		return confirm_dt_st;
	}
	public void setConfirm_dt_st(String confirm_dt_st) {
		this.confirm_dt_st = confirm_dt_st;
	}
	public String getConfirm_dt_ed() {
		return confirm_dt_ed;
	}
	public void setConfirm_dt_ed(String confirm_dt_ed) {
		this.confirm_dt_ed = confirm_dt_ed;
	}
	
	@Override
	public String toString() {
		String result = "";
		try{
			Method[] methodArr = getClass().getMethods();
			for(Method method : methodArr){
				if(method.getName().startsWith("get")){
					Object value = method.invoke(this);
					String fieldInfo = method.getName().replace("get","").toLowerCase() + " = " + value;
					result += fieldInfo + "\n";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
