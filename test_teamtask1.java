package test;
import java.io.*;

//����һ�������ļ�

/* С������һҪʵ�֣�
��װ��һ����
	1. ����value����洢����Ӷ�Ӧ��key-value
	2. ����key�����ҵõ���Ӧ��valueֵ
*/

public class test_teamtask1 {

	public static void main(String[] args)throws IOException, Exception  {
		String filePath = "D:\\Users\\chenxling\\Pictures\\pyͼ\\rrr.txt";
        String newPath = "D:\\Ayingyong5_test";
		TeamTask1 teamtask1 = new TeamTask1( filePath, newPath );  //�����Ѿ�д�õ�TeamTask1�� 
		
		
		System.out.println("ԭʼ·����Ϊ�� " + teamtask1.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + teamtask1.getNewPath() );
		System.out.println("���ļ���keyΪ�� " + teamtask1.getKey() );
		System.out.println("����keyֵ�����ҵ��ļ�������Ϊ�� " +  teamtask1.getValue() );
		
	}

}
