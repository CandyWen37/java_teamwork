package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*ʵ�ַ�֧��˼·��
 * Ĭ�Ϸ�֧������֧�����е�commit�ļ���HEAD�ļ���������Global.gitPath���·���¡�
 * ��ʼ���ֿ⣬���ύ��һ��commitʱ������Global.save_current_branch_file����current_commit.txt�ļ���д�뵱ǰ�ķ�֧��
 * 
 * ��Ҫ�����µķ�֧��Ҫ���Ĳ����У�
 * 		��1����Global.branches·���½����µ��ļ��У��ļ����������µķ�֧��
 * 		��2���ѵ�ǰ��֧·���µ�����commit�ļ���HEAD�ļ�ԭ�ⲻ���ظ��Ƶ��µķ�֧�ļ��¡�
 * 			 ���൱���Ǹ��������ļ��еĲ�����������д��һ��������: CopyTree���������������ļ���
 * 		��3�������Ǵ����·�֧���ѣ���û���л���ǰ��֧��
 * 
 *�л���֧ʱ��Ҫ������в�����
	 	��1����current_commit.txt�ļ���д���µķ�֧��������ԭ�е����ݡ�
	 	��2���ûع��İ취���Ѳֿ��л�����һ����֧������״̬
	 	
	 	
	 	
�����ټ�һ��ɾ����֧�Ĺ���	 	
 */


public class Branch {
	protected String current_branch;        //��ǰ��֧������
	protected String current_branch_path;	//��ǰ��֧���ļ���·��
	protected String latest_commit;         //���µ�commit�ļ��������ϣֵ��
	
	
	//���ع��캯��
	public Branch() throws FileNotFoundException{
		//�õ���ǰ��֧�����֣��Լ������ļ���·��
		GetValue t = new GetValue();
		current_branch = t.getValue( Global.save_current_branch_file );
		current_branch_path = Global.branches + "\\" + current_branch;
		
	}
	public Branch( String newBranchName ) throws IOException{
		
		//�õ���ǰ��֧�����֣��Լ������ļ���·��
		Global g = new Global();   //Ҫ��ʼ��
		current_branch = Global.current_branch;
		current_branch_path = Global.gitPath;
		
		gen_branch( newBranchName );
	}
	
	
	//���������ڴ����·�֧
	public void gen_branch(String newBranchName) throws IOException {
		File branch_file = new File ( Global.branches + "\\" + newBranchName );
		branch_file.mkdir();            //�����µķ�֧�ļ��У������Ÿ÷�֧��commit�ļ�
		 
	
		//�ѵ�ǰBranch�ļ��е�ȫ��commit�ļ����Ƶ��µ�Branch�ļ�������
		new CopyTree( current_branch_path, branch_file.getPath());   
		System.out.println("�½���֧�ɹ���");
	}
	
	
	
	//�����������л���֧
	public void change_branch( String branch_name ) throws IOException{  
		File save = new File( Global.save_current_branch_file);
		PrintWriter out = new PrintWriter( save );
		out.write( branch_name );
		out.close();
		
		File the_head_file = new File ( Global.branches + "\\" + branch_name +"\\" + "HEAD");
		Scanner input = new Scanner(the_head_file);
		String s = null;
		while( input.hasNextLine() ) {
			s = input.nextLine();
				
		}   //���whileѭ����Ϊ�˶�ȡHEAD�ļ������һ�У����һ�������µ�Headֵ��
		input.close();
		
		latest_commit = s ;  //�ҵ��÷�֧������commit
		
		new RollBack(latest_commit);
		System.out.println("���л�����֧��" + branch_name);
	
	}
	
	//���ص�ǰ�����з�֧����
	public String listBranch () { 
		File f = new File( Global.branches );
		File[] branchList = f.listFiles();
		StringBuffer allBranch = new StringBuffer();
		
		for( File b: branchList ) {
			allBranch.append(b.getName()).append("\n");
		}
		
		allBranch.deleteCharAt(allBranch.length()-1);  //ɾ�����һ�����з�
		
		return allBranch.toString();
		
	}
	
}
