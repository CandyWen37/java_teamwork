package test;

import java.io.IOException;

public class test_teamtask2_new_version   {
	
	public static void main(String[] args) throws IOException, Exception {
		String filePath = "D:\\Users\\chenxling\\Pictures\\pyͼ";
	    String newPath = "D:\\Ayingyong5_test";
		Tree  temp = new Tree( filePath, newPath );  
		
		System.out.println("ԭʼ·����Ϊ�� " + temp.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + temp.getNewFilePath() );
		System.out.println("���ļ���keyΪ�� " + temp.getKey() );
		System.out.println("�����ɵ��ļ�����Ϊ��\n" +  temp.getValue() );
		
		
	}
	
	
	
}
