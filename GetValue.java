package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


//���࣬���ڶ�ȡһ���ļ��е�ȫ�����ݣ������ַ�����ʽ��value
public class GetValue {
	
	 public  String getValue ( String path)  throws FileNotFoundException {
		 File file = new File ( path );
		 try {
			FileInputStream fileis = new FileInputStream(file);
			 byte[] buffer = new byte[1024];  //����һ���ֽڻ�����
			 int numRead = 0;
			 StringBuffer stringbuffer = new StringBuffer();
			
			 do {
				 numRead = fileis.read(buffer);
				 if( numRead > 0 ) {
					 stringbuffer.append( new String(buffer) ,0, numRead );  //ע������һ���ַ�����û��toString����
					 //stringbuffer.append( new String(buffer)  );     //ע������������д����������ȡ��ĩβ���кܶ�ո�
					 /*ע����������append( new String(buffer) ,0, numRead )���ַ����У�����ļ������д������ģ���ȡ�����ļ�ĩβ��Ȼ����7��13���ո�
						�һ�û����������������Ǹ���Scanner(File)�е�input.hasNextLine������û����Щ��ֵ�����*/
				 }
			 } while ( numRead != -1);
			fileis.close(); 
			return stringbuffer.toString();
		 }
		 catch (Exception c) {
			 System.out.println("·����Ӧ���ļ�������");
			 return null;
		 }	 
	 }
	 
	 //����
	 public  String getValue ( File file)  throws FileNotFoundException {
		 try {
			FileInputStream fileis = new FileInputStream(file);
			 byte[] buffer = new byte[1024];  //����һ���ֽڻ�����
			 int numRead = 0;
			 StringBuffer stringbuffer = new StringBuffer();
			
			 do {
				 numRead = fileis.read(buffer);
				 if( numRead > 0 ) {
					 stringbuffer.append( new String(buffer));
				 }
			 } while ( numRead != -1);
			fileis.close(); 
			return stringbuffer.toString();
		 }
		 catch (Exception c) {
			 System.out.println("·����Ӧ���ļ�������");
			 return null;
		 }	 
	 }
	 
	 
}
