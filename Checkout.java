package test;
/*�����Խ�һ��ʵ�ֵĹ���
 * 	1.ɾ����ǰ��֧
 * 	
 * 

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*Checkout.java��Ҫʵ���л���֧�Ĺ��ܣ��������£�
 *	1.�ҵ�Ŀ���֧������commit�ļ�
 *	2.�ع�����commit�ļ���Ӧ�Ĳֿ�״̬ 
 *	3.��current_commit.txt�ļ���д���µķ�֧��������ԭ�е����ݡ�	
 * 
 */

public class Checkout {
	
	public Checkout(String a_branch){
		
	}
		
	
	
	
	
	
	/*�л���֧ʱ��Ҫ������������
	 * 1.��current_commit.txt�ļ���д���µķ�֧��������ԭ�е����ݡ�
	 * 2.�ûع��İ취���Ѳֿ��л�����һ����֧������״̬
	 * 
	 * 
	 */
	public void change_branch( String branch_name ) throws FileNotFoundException{  
		File save = new File( Global.save_current_branch_file);
		PrintWriter out = new PrintWriter( save);
		out.write( branch_name );
		out.close();	
	
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
