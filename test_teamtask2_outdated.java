package test;
import java.io.IOException;

//�ɰ������������������--

public class test_teamtask2_outdated {

	public static void main(String[] args) throws IOException {
		String path1 = "C:\\Users\\chenxling\\Desktop\\workspace\\Java�γ���ҵ";
		String path2 = "D:\\Ayingyong5_test";
		
		TeamTask2_outdated  temp = new TeamTask2_outdated( path1, path2 );
		//�ɹ��캯�������Ѿ������ȫ���ļ���д�����
		
		System.out.println("ԭʼ·����Ϊ�� " + temp.getFilePath() );
		System.out.println("�µ�·����Ϊ�� " + temp.getNewPath() );
		System.out.println("���ļ���keyΪ�� " + temp.getKey() );

		

	}

}

