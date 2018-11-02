package main.java.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
 
public class AppMD5Util {
	
	
	 /**
     * 瀵瑰瓧绗︿覆md5鍔犲瘑(灏忓啓瀛楁瘝+鏁板瓧)
     *
     * @param str 浼犲叆瑕佸姞瀵嗙殑瀛楃涓�
     * @return  MD5鍔犲瘑鍚庣殑瀛楃涓�
     */
	
    public static String getMD5(String str) {
        try {
            // 鐢熸垚涓�涓狹D5鍔犲瘑璁＄畻鎽樿
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 璁＄畻md5鍑芥暟
            md.update(str.getBytes());
            // digest()鏈�鍚庣‘瀹氳繑鍥瀖d5 hash鍊硷紝杩斿洖鍊间负8涓哄瓧绗︿覆銆傚洜涓簃d5 hash鍊兼槸16浣嶇殑hex鍊硷紝瀹為檯涓婂氨鏄�8浣嶇殑瀛楃
            // BigInteger鍑芥暟鍒欏皢8浣嶇殑瀛楃涓茶浆鎹㈡垚16浣峢ex鍊硷紝鐢ㄥ瓧绗︿覆鏉ヨ〃绀猴紱寰楀埌瀛楃涓插舰寮忕殑hash鍊�
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
    
    /**
     * 瀵瑰瓧绗︿覆md5鍔犲瘑(澶у啓瀛楁瘝+鏁板瓧)
     *
     * @param str 浼犲叆瑕佸姞瀵嗙殑瀛楃涓�
     * @return  MD5鍔犲瘑鍚庣殑瀛楃涓�
     */
    
    public static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
 
        try {
            byte[] btInput = s.getBytes();
            // 鑾峰緱MD5鎽樿绠楁硶鐨� MessageDigest 瀵硅薄
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 浣跨敤鎸囧畾鐨勫瓧鑺傛洿鏂版憳瑕�
            mdInst.update(btInput);
            // 鑾峰緱瀵嗘枃
            byte[] md = mdInst.digest();
            // 鎶婂瘑鏂囪浆鎹㈡垚鍗佸叚杩涘埗鐨勫瓧绗︿覆褰㈠紡
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
}

