package test;

import java.io.IOException;

/*
С������2��
	����һ���ļ���Ŀ¼������ת��������tree��blob
	������ȱ�����Ŀ¼
	�������ļ���ת����blob������
	�������ļ��о͵ݹ�������ڲ������ļ�/�ļ��������tree������

	ʹ������1�ṩ�Ľӿ� --- hash��
	��Ԫ����
 * 
 * 
 */
public class test_teamtask2 {

	public static void main(String[] args) throws IOException {
		String path1 = "C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ";
		String path2 = "D:\\Ayingyong5_test";
		
		TeamTask2  temp = new TeamTask2( path1, path2 );
		//�ɹ��캯�������Ѿ������ȫ���ļ���д�����
		
		System.out.println("ԭʼ·����Ϊ�� " + temp.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + temp.getNewPath() );
		System.out.println("���ļ���keyΪ�� " + temp.getKey() );

		

	}

}

