package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetValue {
	
	 public  String getValue ( String path)  throws FileNotFoundException {
		 File file = new File ( path );
		 try {
			 Scanner fileInput = new Scanner (file); // ɨ����������·�����ļ�������
			 StringBuffer stringbuffer = new StringBuffer();
			 while (fileInput.hasNextLine()) {
				 stringbuffer.append( fileInput.nextLine()).append('\n');
			 }
			 fileInput.close();
			 return stringbuffer.toString();
		 }
		 catch (Exception c) {
			 System.out.println("·����Ӧ���ļ�������");
			 return null;
		 }
		 
	 }
}
