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

/**
 * @PackageName asms.common.code.web
 * @FileName CommonSelectTag.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 24.
 */
public class CommonSelectTag extends RequestContextAwareTag {
	
	private static final long serialVersionUID = 4126918815338257441L;

	private CommonCodeService commonCodeService;
    
	private String codeType; 				// 공통 코드 타입 
    private String otherCd;					// 다른 코드 
    private boolean use = false;			// 사용 여부
    private boolean disabled = false;		// selectbox disabled 여부
    private String defaultCode ="";			// 기본 코드 값 
    private String name = "";				// 컨트롤 이름 
    private String id = "";					// 컨트롤 ID 
    private String size = "1";				// 크기 
    private String onChange = "";			// onChange 핸들러 
    private String css = "";				// css 이름
    private String optionHead = "";			// 기본 optionHead 
	private String excludingCode ="";		// 제외코드들에 대해 NOT IN 처리함 
	private String onKeyPress = "";			// 기본 onKeyPress
	
	@Override
	protected int doStartTagInternal() throws Exception {
		
		if (commonCodeService == null) {
			// WebApplicationContext 를 얻는다.
			WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
			commonCodeService = ctx.getBean(CommonCodeService.class);
		}
		
		try {
            StringBuffer html = new StringBuffer();
            
            makeSelectTagHead(html);
            makeSelectTagBody(html);
            makeSelectTagTail(html);
            this.pageContext.getOut().println(html.toString());
        }catch(IOException ex) {
            throw new JspException(ex);
        }
        return SKIP_BODY;
	}
	
	private void makeSelectTagHead(StringBuffer html) {
        html.append("<select name='" + this.getName() + "'");
        
        if (StringUtils.isNotEmpty(id)) {
        	html.append(" id='" + this.getId() + "'");
        }
        
        if (!this.getCss().equals("")){
        	html.append(" class='" + this.getCss() + "'");
        }
        
        if (!getSize().equals("")) {
            try {
                Integer.parseInt(getSize());
            } catch(NumberFormatException ex) {
                setSize("1");
            }
            
            html.append(" size=" + Integer.parseInt(getSize()) + "");
        }
        
        if (isDisabled()) {
            html.append(" disabled");
        }
        
        if (!getOnChange().equals("")) {
            html.append(" onChange=\"" + getOnChange() + "\"");
        }
        
        if (!getOnKeyPress().equals("")) {
            html.append(" onKeyPress=\"" + getOnKeyPress() + "\"");
        }
        
        html.append(">");    
    }
	
	private void makeSelectTagBody(StringBuffer html) throws Exception {
		if (!getOptionHead().equals("")) {
            html.append(" <option value=''>" + getOptionHead() + "</option>");
        }
		
        Iterator iterator = findComCdList().iterator();

        while(iterator.hasNext()) {
            makeOptionTag(html, (CommonCodeVO)iterator.next());
        }
    }
	
	private List findComCdList() throws Exception {
        
		CommonCodeVO comCdVO = new CommonCodeVO();
        
        if (getOtherCd() == null || getOtherCd().trim().equals("")) {            
            
        	comCdVO.setType(getCodeType());
            comCdVO.setUse(isUse() ? "1" : "");
            
            String[] exCode ;
    		
            if (!getExcludingCode().equals("")) {
    			exCode = getExcludingCode().split(",");
    			comCdVO.setExCode(exCode);
    		}
            
            return commonCodeService.findComCdList(comCdVO);
        }else{
            comCdVO.setOtherCd(getOtherCd());
            return commonCodeService.findOtherCdList(comCdVO);            
        }
	}
	
	private void makeOptionTag(StringBuffer html, CommonCodeVO comCd) throws JspException {
        html.append("<option value='" + comCd.getCode() + "'");
        if (getDefaultCode().equals(comCd.getCode())) {
            html.append(" selected");
        }
        html.append(">"+comCd.getName() + "</option>");
    }
	
	private void makeSelectTagTail(StringBuffer html) {
        html.append("</select>");
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

	public String getOtherCd() {
		return otherCd;
	}

	public void setOtherCd(String otherCd) {
		this.otherCd = otherCd;
	}

	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getOptionHead() {
		return optionHead;
	}

	public void setOptionHead(String optionHead) {
		this.optionHead = optionHead;
	}

	public String getExcludingCode() {
		return excludingCode;
	}

	public void setExcludingCode(String excludingCode) {
		this.excludingCode = excludingCode;
	}

	public String getOnKeyPress() {
		return onKeyPress;
	}

	public void setOnKeyPress(String onKeyPress) {
		this.onKeyPress = onKeyPress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
