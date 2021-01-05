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
 *+get_all_commit(): ������ʷ����commit�Ĺ�ϣֵ�����ع�ʱʹ��
 * 
 * 
 * //ԭ���������ʹ�þ�̬����count������������Ϊ0ʱ��û���ύ����
	 * ������ֻ�����ڴ��У��޷�������������������д��һ��HEAD�࣬���ڣ�
	 * ��1�����ɻ���º�������commit��ϣֵ��HEAD�ļ���update_head()
	 * ��2�����HEAD�ļ���������ݣ���֮ǰ���µ�commit�Ĺ�ϣֵ��get_head()
	 * ��3�������һ��commit��tree_key: get_last_tree_key()
 */

public class Commit {

	protected String filePath ;   //������Ŀ¼
	protected String gitPath;      //���commit�ļ���Ŀ¼
	
	private String head;             //��һ�����ɵ�commit�ļ����ļ�����Ҳ������Ϊ last_commit_key
	private String current_tree_key;   //�����ɵ�commit�ļ����ļ���
	private String last_tree_key;         //��һ��commit��tree key
	private String current_commit_key;     //�����ɵ�commit�ļ����ļ���
	private StringBuffer value = new StringBuffer();    //����commit�ļ�������
	
	
	Commit(){};  //������Ĭ�ϵ�filePath��gitPath
	
	Commit(String  path1, String gitPath ) throws IOException{
		this.filePath = path1;
		this.gitPath = gitPath;
		gen_commit();
	}
	
	public void gen_commit() throws IOException {
		Gen_hash t = new Gen_hash();     //����Gen_hash����ļ���ϣֵ
		Tree tree = new Tree( filePath, Global.objectPath );   //������Ŀ¼�������µ�Tree��Blob��Ҫ����ͬһ��Object�ļ����С�
	
		this.current_tree_key = t.hashString( tree.getValue() );   //���ɱ���Ҫ�ύ���ļ��еĹ�ϣֵ
	
		
		
		HEAD g = new HEAD();            //����HEAD�࣬���֮ǰ���µ�commit�й���Ϣ
		this.head = g.head;
		this.last_tree_key = g.get_last_tree_key();
		
		if( !current_tree_key.equals(last_tree_key) )  {      //�ж�����Ҫ��equal���������ж��ַ����ĵ�ַ==
			this.value.append(this.current_tree_key);
			this.value.append("\n");
			this.value.append(this.head);
			current_commit_key = t.hashString( value.toString() );
			File commit = new File (gitPath + "\\" + current_commit_key );
			commit.createNewFile();
			PrintWriter p = new PrintWriter (commit);
			p.write( this.value.toString() );  
			p.close();                            //�����Ҫ��ʱ�ر�
			g.update_head( current_commit_key );  //����HEAD�ļ������ĸ���֧���棬��д�뵽�ĸ���֧�ļ����µ�HEAD.txt
			
		}
			
		else {
			System.out.println("����commit�޸��¡�");
		}
	}
	
	public String getValue() {
		return this.value.toString();
	}
	
	//������ʷ����commit�Ĺ�ϣֵ�����ع�ʱʹ��
	public String get_all_commit() throws FileNotFoundException { 
		
		//�õ���ǰ��֧Branch���ļ���·��
		GetValue t = new GetValue();
		String current_branch_path = Global.branches + "\\" + t.getValue( Global.save_current_branch_file );
		
		//�õ���ǰ��֧�µ�HEAD�ļ�����
		String all_commit = t.getValue( current_branch_path + "\\" + "HEAD" );
		return all_commit;
	}
	

}
