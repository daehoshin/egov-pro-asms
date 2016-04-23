package asms.common.crypt;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * @PackageName asms.common.crypt
 * @FileName SHAEncrypt.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 4. 18.
 */
public class SHAEncrypt {
	public static String encrypt(String password) {        
		ShaPasswordEncoder encoder=new ShaPasswordEncoder(256);	 // 암호화 방식인 sha-256 객체구함

		String h=encoder.encodePassword(password, null);

		return h;
	}
}
