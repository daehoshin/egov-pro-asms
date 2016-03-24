package asms.common.code.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import asms.common.code.service.CommonCodeVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import asms.common.code.service.CommonCodeService;

public class commonRadioTag extends RequestContextAwareTag {
	
	private static final long serialVersionUID = 4126918815338257441L;

	private CommonCodeService commonCodeService;

	private String codeType;				// 공통 코드 타입
	private boolean use;					// 사용 여부
	private boolean disabled = false;		// 비활성화 여부
	private String defaultCode = "";		// 기본코드
	private String name = "";				// 컨트롤 이름
	private String addNameValue = "";		// 이름을 동적으로 생성 시 필요한 값
	private String onChange = "";			// onChange 핸들러
	private String onClick = "";			// onClick 핸들러
	private String excludingCode ="";		// 제외코드들에 대해 NOT IN 처리함

	@Override
	protected int doStartTagInternal() throws Exception {

		if (commonCodeService == null) {
			WebApplicationContext ctx = getRequestContext()
					.getWebApplicationContext();
			commonCodeService = ctx.getBean(CommonCodeService.class);
		}
		try {
			StringBuffer html = new StringBuffer();
			makeRadioTag(html);
			this.pageContext.getOut().println(html.toString());

		} catch (IOException ex) {
			throw new JspException(ex);
		}

		return SKIP_BODY;
	}

	private void makeRadioTag(StringBuffer html) throws Exception {
		Iterator iterator = findComCdList().iterator();

		while (iterator.hasNext()) {
			makeRadioTag(html, (CommonCodeVO) iterator.next());
		}
	}

	private List findComCdList() throws Exception {

		CommonCodeVO comCdVO = new CommonCodeVO();
		comCdVO.setType(getCodeType());
		comCdVO.setUse(isUse() ? "1" : "");
		
		String[] exCode ;
		if (!getExcludingCode().equals("")) {
			exCode = getExcludingCode().split(",");
			comCdVO.setExCode(exCode);
		}

		return commonCodeService.findComCdList(comCdVO);
	}

	private void makeRadioTag(StringBuffer html, CommonCodeVO comCdVO)
			throws JspException {

		html.append("<label class ='radio-inline'><input type='radio' name='" + this.getName() + this.getAddNameValue() + "' value='"
				+ comCdVO.getCode() + "'");

		if (getDefaultCode().equals(comCdVO.getCode())) {
			html.append(" checked");
		}

		if (isDisabled()) {
			html.append(" disabled");
		}

		if (!getOnChange().equals("")) {
			html.append(" onChange=\"" + getOnChange() + "\"");
		}
		
		if (!getOnClick().equals("")) {
			html.append(" onClick=\"" + getOnClick() + "\"");
		}

		html.append("> " + comCdVO.getName() + "</label>");
	}

	public CommonCodeService getCommonCodeService() {
		return commonCodeService;
	}

	public void setCommonCodeService(CommonCodeService commonCodeService) {
		this.commonCodeService = commonCodeService;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getDefaultCode() {
		return defaultCode;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddNameValue() {
		return addNameValue;
	}

	public void setAddNameValue(String addNameValue) {
		this.addNameValue = addNameValue;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getExcludingCode() {
		return excludingCode;
	}

	public void setExcludingCode(String excludingCode) {
		this.excludingCode = excludingCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
