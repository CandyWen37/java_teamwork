package test;

import java.io.IOException;

public class test_teamtask2_new_version   {
	
	public static void main(String[] args) throws IOException, Exception {
		String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ";
	    String newPath = "D:\\Ayingyong5_test";
		TeamTask2_new_version  temp = new TeamTask2_new_version( filePath, newPath );  
		
		System.out.println("ԭʼ·����Ϊ�� " + temp.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + temp.getNewFilePath() );
		System.out.println("���ļ���keyΪ�� " + temp.getKey() );
		//System.out.println("�����ɵ��ļ�����Ϊ��\n" +  temp.getValue() );
	}
	
	
	
}
