package test;

import java.security.NoSuchAlgorithmException;

public class Test_Gen_hash {

	public static void main(String[] args) {
		Gen_hash temp = new Gen_hash ();
		String hash1 = temp.hash("C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ\\Charpter6_4.java");
		System.out.println("hash1:" + hash1);
		String hash2 = temp.hashString("");  //���Կ��ַ���
		System.out.println("hash2:" + hash2);
		String hash3 = temp.hashString("435dgdfgf");  //������ͨ�ַ���
		System.out.println("hash3:" + hash3);
	}

}
