package test;
import java.io.*;

/*
 * ��������
 * ʵ��Commit
	����һ��������Ŀ¼�����ɶ�Ӧ��blob��tree(���������)�Լ�commit
	��ʾ��
	��Ҫ�洢ָ��ǰ����commit��HEADָ��
	ÿ��������һ��commitǰ����Ҫ�Ѹ�Ŀ¼��tree key�����е�����commit��tree key���бȽϣ����ֲ���ͬʱ�����ļ������˱䶯����������commit
 * 
 * Commit��
	������Ŀ¼tree�����key   //��һ��
	����ǰһ��commit��key����ǰһ��commit���ļ���    //�ڶ���
	�������й��ɱ���commit��value������commit��key���������������ݵĹ�ϣ
	��һ��commitû��ǰһ�ε�commit.   
	
 */



/*���˼·
 * ����һ������Commit���ࣺ
 * ������
 * -String filePath           //������Ŀ¼
 * -String gitPath            //���commit�ļ���Ŀ¼
 * -String current_tree_key   //����Ҫcommit���ļ��еĹ�ϣֵtree key
 * -String last_tree_key       //��һ��commit��tree key
 * -String head                 //��һ�����ɵ�commit�ļ����ļ���
 * -String current_commit_key        //�����ɵ�commit�ļ����ļ���
 * -String value                     //����commit�ļ���value   
 * 
 *������
 *+���캯��Commit(path1, path2)�����ù��캯�������������Ҫ����
 *+gen_commit()�������캯������
 *+getValue():   ��ñ���commit��value
 * 
 * 
 * //ԭ���������ʹ�þ�̬����count������������Ϊ0ʱ��û���ύ����
	 * ������ֻ�����ڴ��У��޷�������������������д��һ��HEAD�࣬���ڣ�
	 * ��1�����ɻ���º�������commit��ϣֵ��HEAD�ļ���update_head()
	 * ��2�����HEAD�ļ���������ݣ���֮ǰ���µ�commit�Ĺ�ϣֵ��get_head()
	 * ��3�������һ��commit��tree_key: get_last_tree_key()
 */

public class Commit {
	private static String filePath;   //������Ŀ¼
	static String gitPath ;          //���commit�ļ���Ŀ¼����˽�У����Թ�HEAD.java�ļ�ʹ�� 
	private String head;             //��һ�����ɵ�commit�ļ����ļ�����Ҳ������Ϊ last_commit_key
	private String current_tree_key;   //�����ɵ�commit�ļ����ļ���
	private String last_tree_key;         //��һ��commit��tree key
	private String current_commit_key;     //�����ɵ�commit�ļ����ļ���
	private StringBuffer value = new StringBuffer();    //����commit�ļ�������
	
	
	Commit(){};
	Commit(String  path1, String path2 ) throws IOException{
		Commit.filePath = path1;
		Commit.gitPath = path2;
		new Tree( path1, path2 );   //��������ɹ�����Ŀ¼����һ��Tree�ļ�����¼������������
		gen_commit();
	}
	
	public void gen_commit() throws IOException {
		Gen_hash t = new Gen_hash();     //����Gen_hash����ļ���ϣֵ
		this.current_tree_key = t.hash(filePath);   //���ɱ���Ҫ�ύ���ļ��еĹ�ϣֵ
		
		HEAD g = new HEAD();            //����HEAD�࣬���֮ǰ���µ�commit�й���Ϣ
		this.head = g.head;
		this.last_tree_key = g.get_last_tree_key();
		
		if( !current_tree_key.equals(last_tree_key) )  {        //�޸ģ����ж����ݣ��������ж��ַ����ĵ�ַ
			File commit = new File(gitPath + "\\" + "temporary" );
			PrintWriter p = new PrintWriter (commit);
			this.value.append( this.current_tree_key );
			this.value.append( "\n" );
			this.value.append( this.head );
			//System.out.println(value.toString());
			p.write( this.value.toString() );  
			p.close();                 //��������Ҫ��ʱ�رգ������Ӱ��������ļ�����������
			
			String newName = t.hash(commit.getPath());
			File dest = new File ( gitPath + "\\" + newName );
			boolean rename = commit.renameTo(dest);   //�����µ�commit�ļ�������Ϊ����value�Ĺ�ϣֵ
			
			current_commit_key = dest.getName();
			g.update_head( current_commit_key );   //����HEAD�ļ�
			
		}
			
		else {
			System.out.println("����commit�޸��¡�");
		}
	}
	
	public String getValue() {
		return this.value.toString();
	}
	

}
