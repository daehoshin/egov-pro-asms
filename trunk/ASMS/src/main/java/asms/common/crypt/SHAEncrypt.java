package asms.common.crypt;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class SHAEncrypt {
	public static String encrypt(String password) {        
		ShaPasswordEncoder encoder=new ShaPasswordEncoder(256);	 // 암호화 방식인 sha-256 객체구함

		String h=encoder.encodePassword(password, null);

		return h;
	}
}
