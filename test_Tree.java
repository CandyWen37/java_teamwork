package test;

import java.io.IOException;

public class test_Tree   {
	
	public static void main(String[] args) throws IOException, Exception {
		String filePath = "D:\\Users\\chenxling\\Pictures\\pyͼ";
		//String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ";
	    String objectPath = "D:\\Ajava_object";
		Tree  temp = new Tree( filePath, objectPath );  
				
		System.out.println("ԭʼ·����Ϊ�� " + temp.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + temp.getNewFilePath() );
		System.out.println("���ļ���keyΪ�� " + temp.getKey() );
		System.out.println("�����ɵ��ļ�����Ϊ��\n" +  temp.getValue() );
		
		
	}
	
	
	
}
