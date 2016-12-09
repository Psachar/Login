package com.praj.bean;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public abstract class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EncryptDecrypt ed = EncryptDecrypt.getInstance();
		System.out.println(ed.encrypt("praj@12"));
		System.out.println(ed.decrypt(ed.encrypt("praj@12")));
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		System.out.println("Secret Key is"+secretKey);

	}

}
