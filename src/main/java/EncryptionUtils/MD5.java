package EncryptionUtils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5 {


    public String encryption(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        return base64en.encode(md5.digest(password.getBytes("utf-8")));
    }

    public String getMD5(String password) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPassword(int length) {
        Random random = new Random();
        String num = "1,2,3,4,5,6,7,8,9,0,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z," +
                "A,Q,Z,X,S,W,E,D,C,V,F,R,T,G,B,N,H,Y,U,J,M,K,I,O,L,P," +
                "/,*,-,+,.,\\,[,],{,},;,',:,\",?,<,>,),(,*,&,^,%,$,#,@,!,`,~,=,_";
        String[] c = num.split(",");
        String print = "";
        for (int i = 0; i < length; i++) {
            int rad = random.nextInt(c.length);
            print += c[rad];
        }
        return print;
    }
}
