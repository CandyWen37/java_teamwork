package test;
import java.io.*;

//����һ�������ļ�

/* С������һҪʵ�֣�
��װ��һ����
	1. ����value����洢����Ӷ�Ӧ��key-value
	2. ����key�����ҵõ���Ӧ��valueֵ
*/

public class Test_Blob {

	public static void main(String[] args)throws IOException, Exception  {
		String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ\\Charpter6_4.java";
		//String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\��ʵ��Ŀ��ļ�.txt";  //���Կ��ļ�
        String gitPath = "D:\\AsimpleGit\\object";
		Blob teamtask1 = new Blob( filePath, gitPath );  //�����Ѿ�д�õ�TeamTask1�� 
		
		
		System.out.println("ԭʼ·����Ϊ�� " + teamtask1.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + teamtask1.getObjectPath() );
		System.out.println("���ļ���keyΪ�� " + teamtask1.getKey() );
		System.out.println("����keyֵ�����ҵ��ļ�������Ϊ��\n" +  teamtask1.getValue() );
		
	}

}
