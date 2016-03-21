package asms.common.code.service;

public class CommonCodeVO {
	
	private String  type;           // 코드 타입
	private String  code;           // 코드값
    private String  name;           // 코드명
    private String  use;            // 사용여부
    private String  operation;      // 코드 조회를 위해 사용할 오퍼레이션 명
    private String[]	exCode;      // 제외코드

    /* 기본 생성자 */
    public CommonCodeVO() {
        super();
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String[] getExCode() {
		return exCode;
	}


	public void setExCode(String[] exCode2) {
		this.exCode = exCode2;
	}

}
