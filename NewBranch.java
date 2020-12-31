package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


/*ʵ�ַ�֧��˼·��
 * ԭ�ȵķ�֧Ĭ��������֧�����е�commit�ļ���HEAD�ļ���������"D:\\AsimpleGit\\branches\\mainCommitPath"���·���¡�
 * �ύ��һ��commitʱ������"D:\\AsimpleGit"·���µ�current_commit.txt�ļ���д�뵱ǰ�ķ�֧��
 * ��Ҫ�����µķ�֧��Ҫ���Ĳ����У�
 * 		��1����"D:\\AsimpleGit\\branches\\"·���½����µ��ļ��У��ļ����������µķ�֧��
 * 		��2���ѵ�ǰ��֧·���µ�����commit�ļ���HEAD�ļ�ԭ�ⲻ���ظ��Ƶ��µķ�֧�ļ��¡�
 * 			 ���൱���Ǹ��������ļ��еĲ�����������д��һ��������: CopyTree���������������ļ���
 * 		��3����current_commit.txt�ļ���д���µķ�֧��������ԭ�е����ݡ�
 * 		 
 * 
 */


public class NewBranch {
	private String newBranchName;   //�µķ�֧��
	public String save_current_branch_file = "D:\\AsimpleGit\\current_branch.txt";  //���ļ����ڴ�ŵ�ǰ��֧��
	public String branches = "D:\\AsimpleGit\\branches";    //���ļ������ڴ�����з�֧�ļ��У���������֧
	
	NewBranch( String newBranchName) throws IOException{
		this.newBranchName = newBranchName;
		change_branch( newBranchName );
		gen_branch();
		
		
	}
	
	public void gen_branch() throws IOException {
		File branch_file = new File ( this.branches + "\\" + newBranchName );
		branch_file.mkdir();            //�����µķ�֧�ļ��У������Ÿ÷�֧��commit�ļ�
		 
		//�õ���ǰ��֧��
		GetValue t = new GetValue();
		String branch = this.branches + "\\" + t.getValue( this.save_current_branch_file );

		new CopyTree( branch, branch_file.getPath());
		
	}
	
	//��current_commit.txt�ļ���д���µķ�֧��������ԭ�е����ݡ�
	private void change_branch( String branch_name ) throws FileNotFoundException{  
		//File save = new File( save_current_branch_file);
		PrintWriter out = new PrintWriter(branch_name);
		out.write( branch_name );
		out.close();
			
	}
	

}
