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

/*���Ŀ�꣺
 * (P1��ԭʼ·����P2��Ŀ��·��)
 * (1)��P1��������һ���ļ�blob�����blob��P1������P2�����ݲ��䣬�ļ����ĳ�blob�Ĺ�ϣ��
 * (2)��P1��������һ���ļ���tree������P2������һ��txt�ļ����ļ�����Ϊ:
 * 		ԭ�ļ���������ļ������֡����ļ��Ĺ�ϣ�롢���ļ������ͣ�blob or tree)
 * 		P2������ļ�������Ϊ�������ݵĹ�ϣֵ
 * 
 */

/*���˼·��
 * 	����һ��������������ࣺ
 * 	������
 * 		-�ܵ�key
 * 		-ԭʼ·��P1
 * 		-��·��P2
 * 			
 * ������
 * 		+���췽��( P1, P2 )
 * 		+goal
 * 
 * �ٶ���һ�������࣬Tree_content��
 * 	������
 * 		-���ͣ�blob or tree
 * 		-��ϣ��
 * 		-�ļ�ԭ��������׺����
 * 	������
 * 		+���캯�����������ļ���·���������������������
 * 			���洢ԭ�ļ�����ġ����ļ��������֡������ļ����Ĺ�ϣ�롢�����ļ��������ͣ�blob or tree)
 * 		+String output():
 * 			��ӡ���������������
 * 		+getFilePath
		+getNewFilePath
		+getKey
 */



import java.io.*;
import java.util.Scanner;

public class TeamTask2_new_version {
	
	private String gross_key;
	private String filePath;
	private String newFilePath;
	
	TeamTask2_new_version(String P1, String P2){
		this.filePath = P1;
		this.newFilePath = P2;
		Gen_hash t = new Gen_hash();
		gross_key = t.hash(P1);
		gen_tree_file();
		
	};
	
	public void gen_tree_file() {
		//�ֳ����������1.filePath���ļ�blob��2.filePath���ļ���
		File file1 = new File( filePath );
 
		try {
			if( file1.isFile()) {
				new TeamTask1( filePath, newFilePath );
			}
			else if (file1.isDirectory()) {
				File newFile = new File( newFilePath + "\\"+ gross_key);   
				newFile.createNewFile();
				FileOutputStream fos = new FileOutputStream( newFile );
				File[] file2 = file1.listFiles();
		
				for(int i=0; i<file2.length; i++) {
					Tree_content g = new Tree_content( file2[i].getPath());
					fos.write( g.output().getBytes() );
				}
			fos.close();	
			}	
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		
	}
	
	public  String getValue ( )  throws FileNotFoundException {
		 File file = new File ( newFilePath + "\\"+ gross_key );
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
			 System.out.println("key��Ӧ���ļ�������");
			 return null;
		 }
		 
	 }
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getNewFilePath() {
		return newFilePath;
	}
	
	public String getKey() {
		return gross_key;
	}
	
	

}
