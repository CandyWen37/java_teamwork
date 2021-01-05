package test;

import java.io.File;
import java.io.IOException;

/*ʵ�ַ�֧��˼·��
 * Ĭ�Ϸ�֧������֧�����е�commit�ļ���HEAD�ļ���������Global.gitPath���·���¡�
 * ��ʼ���ֿ⣬���ύ��һ��commitʱ������Global.save_current_branch_file����current_commit.txt�ļ���д�뵱ǰ�ķ�֧��
 * ��Ҫ�����µķ�֧��Ҫ���Ĳ����У�
 * 		��1����Global.branches·���½����µ��ļ��У��ļ����������µķ�֧��
 * 		��2���ѵ�ǰ��֧·���µ�����commit�ļ���HEAD�ļ�ԭ�ⲻ���ظ��Ƶ��µķ�֧�ļ��¡�
 * 			 ���൱���Ǹ��������ļ��еĲ�����������д��һ��������: CopyTree���������������ļ���
 * 		��3�������Ǵ����·�֧���ѣ���û���л���ǰ��֧��
 */

//�������ڴ����·�֧
public class NewBranch {
	//���಻��Ҫ������

	public NewBranch(){}
	public NewBranch( String newBranchName ) throws IOException{
		gen_branch( newBranchName );
	}
	
	public void gen_branch(String newBranchName) throws IOException {
		File branch_file = new File ( Global.branches + "\\" + newBranchName );
		branch_file.mkdir();            //�����µķ�֧�ļ��У������Ÿ÷�֧��commit�ļ�
		 
		//�õ���ǰ��֧Branch���ļ���·��
		GetValue t = new GetValue();
		String current_branch_path = Global.branches + "\\" + t.getValue( Global.save_current_branch_file );

		//�ѵ�ǰBranch�ļ��е�ȫ��commit�ļ����Ƶ��µ�Branch�ļ�������
		new CopyTree( current_branch_path, branch_file.getPath());    	
	}
	
}
