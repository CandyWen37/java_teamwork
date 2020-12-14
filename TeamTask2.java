package test;
/*
С������2��
	����һ���ļ���Ŀ¼������ת��������tree��blob
	������ȱ�����Ŀ¼
	�������ļ���ת����blob������
	�������ļ��о͵ݹ�������ڲ������ļ�/�ļ��������tree������

	ʹ������1�ṩ�Ľӿ� --- hash��
	��Ԫ����
 */

/*
 * ����һ��TeamTask2�ࣺ
 * ������
 * 	-filePath ��������ļ���Ŀ¼
 *  -newFilePath �������ɵ��ļ���Ŀ¼
 * 
 * ������
 * +void  gen_file()  ʵ����Ҫ����
 * +String getKey()
 * +String getFilePath()
 * +String getNewFilePath()
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TeamTask2 {
	private  String filePath;   
	private  String newFilePath;
	private  String key;   
	//public   boolean flag;
	
	
	TeamTask2( String filePath, String newFilePath ) throws IOException{
		this.filePath = filePath;
		this.newFilePath = newFilePath;
		Gen_hash t = new Gen_hash();
		this.key = t.hash(filePath);
		gen_file( filePath, newFilePath);
	}
	
	public boolean gen_file( String filePath, String newFilePath  ) {
		//�ֳ����������1.���ļ�blob��2.���ļ��У�����ȫ��blob, 3. �ļ����ﻹ���ļ���
		try {
			File file1 = new File( filePath );  //file1��ԭʼĿ¼
		
			if(file1.isFile()) {  //ֱ�����ļ��Ļ�
				new TeamTask1( filePath, newFilePath );
				return true;
			}
			else if( file1.isDirectory() ) {
				File[] fileList = file1.listFiles();
				Gen_hash t2 = new Gen_hash();
				key = t2.hash(filePath);
				
				File file2 = new File ( newFilePath + "\\" + key );
				file2.mkdir();
				
				for ( int i=0; i<fileList.length; i++) {
					
					if( fileList[i].isFile() ) {
						new TeamTask1( fileList[i].getPath(), file2.getPath() );
					}
		
					if ( fileList[i].isDirectory() ) {
						gen_file( fileList[i].getPath(), file2.getPath() );
					}					
				}
				
				return true;
						
			}			
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		return false;

	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getNewPath() {
		return newFilePath;
	}
	
	public String getKey() {
		return key;
	}
	

}
