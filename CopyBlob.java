package test;

import java.io.*;

public class CopyBlob {
	
	private String filePath;     //��ԭ�ļ���·��+�ļ���
	private String goalPath;     //�����ļ���·����
	private String newName;      //�����ļ����ļ���
	
	public CopyBlob(String filePath, String goalPath, String newName ) throws IOException {
		this.filePath = filePath;
		this.goalPath = goalPath;
		this.newName = newName;
		gen_file();
		
	}
	//������
	public CopyBlob(File file, String goalPath, String newName ) throws IOException {
		this.filePath = file.getPath();
		this.goalPath = goalPath;
		this.newName = newName;
		gen_file();		
	}
	
	//���أ������ļ������ļ�����
	public CopyBlob(String filePath, String goalPath ) throws IOException {
		this.filePath = filePath;
		this.goalPath = goalPath;
		File file = new File (filePath);
		this.newName = file.getName();
		gen_file();		
		
	}
	
	//���أ������ļ������ļ�����
	public CopyBlob(File file, String goalPath ) throws IOException {
		this.filePath = file.getPath();
		this.goalPath = goalPath;
		this.newName = file.getName();
		gen_file();		
		
	}
	

	public void gen_file() throws IOException {    
		File goalFile =new File( goalPath + "\\" + newName);
		goalFile.createNewFile();
		FileInputStream fileis = new FileInputStream(filePath);
		FileOutputStream fileos = new FileOutputStream(goalFile);
		 
		byte[] buffer = new byte[1024];  //����һ���ֽڻ�����
		int numRead = 0;
		 
		do {
			 numRead = fileis.read(buffer);
			 if( numRead > 0 ) {
				fileos.write(buffer, 0, numRead); 
				 
			 }
		} while ( numRead != -1);
		 
		fileis.close();
		fileos.close(); 
		
	}
	
}
