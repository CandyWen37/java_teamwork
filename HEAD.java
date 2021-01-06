package test;

import java.io.*;
import java.util.Scanner;

//Ҫ����һ���洢����HEAD���ļ�������commit��¼ֻͣ�����ڴ��У��´��޷��ҵ�
public class HEAD {

	private String gitPath;
	private File head_file;
	protected String head;       				//���µ�commit�ļ��������ϣֵ��
	public String save_current_branch_file = Global.save_current_branch_file;  //���ļ����ڴ�ŵ�ǰ��֧��
	
	HEAD() throws FileNotFoundException{
	
		Global g = new Global();   //Ҫ��ʼ��
		this.gitPath = Global.branches + "\\"+  Global.current_branch;
		this.head_file = new File(gitPath + "\\" + "HEAD");
		
		this.head = get_head();
	}
	
	public void update_head ( String commit ) throws IOException {
		if( !head_file.exists() ) {  
			//���HEAD.txt�ļ������ڣ�˵�������ڳ�ʼ���ֿ⣬ͬʱ���е�һ��commit��Ĭ�Ϸ�֧Ϊ����֧
			head_file.createNewFile();
			PrintWriter output = new PrintWriter(head_file);
			output.print( commit );        
			output.close();
			System.out.println("Commit�ɹ���HEAD�ļ��ѽ�����");
			
			File save = new File( save_current_branch_file );  //Ĭ�Ϸ�֧Ϊ����֧��д��current_branch.txt
			PrintWriter out = new PrintWriter( save);
			out.write( "mainCommitPath" );
			out.close();
			System.out.println("��ǰ��֧��main��֧��");
		}
		else {
			commit = "\n" + commit;
			FileOutputStream output = new FileOutputStream( head_file, true );  //HEAD�ļ��ᱣ��������е�commit
			output.write( commit.getBytes() );            //���µ�commit�����һ��
			output.close();
			System.out.println("Commit�ɹ���HEAD�ļ��Ѹ��¡�");
		}
	}
	
	//���ص�ǰ��֧������Commit����
	public String get_head() throws FileNotFoundException {
		if( !head_file.exists() ) {
			return null;
		}
		else {
			Scanner input = new Scanner(head_file);
			String s = null;
			while( input.hasNextLine() ) {
				s = input.nextLine();
				
			}   //���whileѭ����Ϊ�˶�ȡHEAD�ļ������һ�У����һ�������µ�Headֵ��
			input.close();
			head = s;
			return head;
		}
	}
	
	
	//���ص�ǰ��֧������Commit����Ӧ��Tree�ļ��Ĺ�ϣֵ���ļ�����
	public String get_last_tree_key() throws FileNotFoundException {
		if( !this.head_file.exists() )
			return null;
		else {
			File last_commit = new File(gitPath + "\\"+ this.head);	
			Scanner input = new Scanner( last_commit );
			String last_tree_key = input.nextLine();   //��һ�ε�commit�ļ���ĵ�һ�о��Ǵ����tree_key  
			input.close();
			return last_tree_key;
		}
	}
	
}
