package com.nongzi.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class MD5 {
private static final String DEFAULT_PASSWORD_CRYPT_KEY = "__jDlog_";

private static final String DES = "DES";
private static Cipher cipher = null;

static {
// Cipher对象实际完成加密操作
try {
cipher = Cipher.getInstance(DES);
} catch (Exception e) {
e.printStackTrace();
}
}

public MD5() {

}

public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
// DES算法要求有一个可信任的随机数源
SecureRandom sr = new SecureRandom();

// 从原始密匙数据创建DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);

// 创建一个密匙工厂，然后用它把DESKeySpec转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
SecretKey securekey = keyFactory.generateSecret(dks);

// 用密匙初始化Cipher对象
cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

// 正式执行加密操作
return cipher.doFinal(src);
}

public static byte[] decrypt(byte[] src, byte[] key) throws Exception {

// DES算法要求有一个可信任的随机数源
SecureRandom sr = new SecureRandom();

// 从原始密匙数据创建一个DESKeySpec对象
DESKeySpec dks = new DESKeySpec(key);

// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
// 一个SecretKey对象
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
SecretKey securekey = keyFactory.generateSecret(dks);

// 用密匙初始化Cipher对象
cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

// 正式执行解密操作
return cipher.doFinal(src);
}

public static String decrypt(String data) {
try {
return new String(decrypt(hex2byte(data.getBytes()),
       DEFAULT_PASSWORD_CRYPT_KEY.getBytes()));
} catch (Exception e) {
e.printStackTrace();;
}
return null;
}

public static String decrypt(String data, String key) {
try {
return new String(decrypt(hex2byte(data.getBytes()), key.getBytes()));
} catch (Exception e) {
e.printStackTrace();;
}
return null;
}

public static String encrypt(String data) {
try {
return byte2hex(encrypt(data.getBytes(), DEFAULT_PASSWORD_CRYPT_KEY.getBytes()));
} catch (Exception e) {
e.printStackTrace();
}
return null;
}

public static String encrypt(String data, String key) {
try {
return byte2hex(encrypt(data.getBytes(), key.getBytes()));
} catch (Exception e) {
e.printStackTrace();;
}
return null;
}

public static String byte2hex(byte[] b) {
String hs = "";
String stmp = "";

for (int n = 0; n < b.length; n++) {
stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
if (stmp.length() == 1) {
           hs = hs + "0" + stmp;
            } else {
           hs = hs + stmp;
            }
}

return hs.toUpperCase();
}

public static byte[] hex2byte(byte[] b) {
if ((b.length % 2) != 0) {
       throw new IllegalArgumentException("长度不是偶数");
        }

byte[] b2 = new byte[b.length / 2];
for (int n = 0; n < b.length; n += 2) {
String item = new String(b, n, 2);
b2[n / 2] = (byte) Integer.parseInt(item, 16);
}

return b2;
}
}
