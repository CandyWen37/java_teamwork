package test;
import java.io.*;

//����һ�������ļ�

/* С������һҪʵ�֣�
��װ��һ����
	1. ����value����洢����Ӷ�Ӧ��key-value
	2. ����key�����ҵõ���Ӧ��valueֵ
*/



public class test_teamwork1 {

	public static void main(String[] args)throws IOException, Exception  {
		String filePath = "D:\\Atest_teamtask1\\introduce.txt";
        String newPath = "D:\\Ayingyong5_test\\";
		TeamTask1 teamtask1 = new TeamTask1( filePath, newPath );  //�����Ѿ�д�õ�TeamTask1�� 
		
		String test_key = teamtask1.key;
		String content = teamtask1.getValue(test_key);
		
		System.out.println("ԭʼ·����Ϊ�� " + teamtask1.filePath );
		System.out.println("�µ�·����Ϊ�� " + teamtask1.newPath );
		System.out.println("���ļ���keyΪ�� " + test_key);
		System.out.println("����keyֵ�����ҵ��ļ�������Ϊ�� " +  content);
		
		
		
		
		

	}

}
