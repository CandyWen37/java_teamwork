package test;

import java.io.FileNotFoundException;

public class Global {
	/*����blob�� tree�� commit�ļ���HEAD�ļ������浱ǰ��֧���ļ���
	 *����·����������Global.java����ļ����У��Ҷ���Ϊ��̬������ȫ�֣���
	 *ע�⣬��Щ·������ô�������ˣ�����ֻͣ�����ڴ��еģ��ϴ��˳�ʱͣ�����ĸ���֧�ǲ���ǵõ�
	 *���У�Tree.java��Blob.java��û���õ���Щȫ�ֱ����ġ�
		*/
		protected static String filePath = "D:\\Users\\chenxling\\Pictures\\pyͼ" ;   //������Ŀ¼
		protected static String objectPath = "D:\\AsimpleGit\\object";      //�������blob�� tree�ļ���Ŀ¼
		protected static String save_current_branch_file = "D:\\AsimpleGit\\current_branch.txt";  //���ڴ�ŵ�ǰ��֧��
		protected static String branches = "D:\\AsimpleGit\\branches";    //���ļ������ڴ�����з�֧�ļ��У���������֧
		protected static String current_branch ;     // "mainCommitPath";     	  //��ǰ��֧��
		protected static String gitPath ;      //= "D:\\AsimpleGit\\branches\\mainCommitPath";  //���commit�ļ���Ŀ¼
	
		Global() throws FileNotFoundException{
			//��ʼ�������ļ��ж�ȡ��ǰ��֧��
			
			//�õ���ǰ��֧�����֣��Լ������ļ���·��
			GetValue t = new GetValue();
			current_branch = t.getValue( Global.save_current_branch_file );
			gitPath = Global.branches + "\\" + current_branch;
			
			
		}	

}
