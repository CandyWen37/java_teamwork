package test;

import java.io.*;
import java.util.Scanner;

/*ʵ�ֻع�����
 *��ʵ�����Ǹ���һ���汾�ţ�Ҳ����ĳ��commit���ļ����� ��ȡ���ļ����ĵ�һ�У�
 *�͵õ����Ǵ�commit���ύ���������ļ��е�tree
 *�ٸ���tree��������ݣ�һһ���ļ����Ƶ�Ŀ��·����
 *	���ļ�����blob, �͸������Ĺ�ϣ�룬ȥ���object��·�����ҵ�����Ȼ���Ƶ�Ŀ��·��
 *	���ļ�����Tree, ����Ŀ��·�����½�һ�����ļ��У����Ҹ������Ĺ�ϣ�룬ȥ���object��·�����ҵ���ӦTree�ļ����ݹ顣
 *
 */

/*����һ��object·����
 * 	���ڵ�һ��commit, �����е�tree��blob�浽���·���¡�
 * 		����ǲ�ͬ�ļ�������������ȫ��ͬ�����ļ���ֻ�ᱣ��һ��blob��������������
 * 	���ڵڶ���commit��
 * 		���ĳЩ���ļ��Ķ��ˣ�����ڸ�object·����������Ӧ��tree��blob��ͬʱ�ɵ�tree��blob���ᱻɾ����
 * 		���������ȫ�µ��ļ�������object·���������µ�tree��blob
 * 	�ɴˣ����֪���е���ʷ�汾���ļ����ݡ�
 * 
 */


public class RollBack {
	private String treeKey;
	private String treePath;
	private String goalPath = "D:\\AsimpleGit\\goalPath";  //�ع��������ļ�ȫ���������·����
	private String commitPath = "D:\\AsimpleGit\\commitPath";
	
	RollBack( String commit ) throws IOException {
		File file1 = new File(  commitPath + "\\" + commit );
		Scanner input1 = new Scanner( file1 );
		treeKey = input1.nextLine();
		input1.close();
		treePath = Tree_content.objectPath + "\\" + treeKey;
		gen_file( treePath, this.goalPath );
		System.out.println("�ع��ɹ���");
		
	}
	
	public boolean gen_file( String filePath, String goalPath ) throws IOException {
		File file2 = new File ( filePath );
		Scanner input2 = new Scanner( file2 );
		String oneLine = null;
		Tree_content  read_a_line = new Tree_content();
		
		while ( input2.hasNextLine() ) {
			oneLine = input2.nextLine();         //���ζ�ȡtree�ļ���ÿһ�е�����
			read_a_line.get_tree_content(oneLine);
			
			String copyedPath = Tree_content.objectPath + "\\" + read_a_line.getKey();  //���ǽ�����ԭ���ļ���·��
			
			if (read_a_line.getType().equals("Blob")) {       //����ע�ⲻ����==   
				new CopyBlob( copyedPath, goalPath, read_a_line.getName() );
			}
			else if (read_a_line.getType().equals("Tree")) {
				String sec_file_path = goalPath + "\\" + read_a_line.getName();
				File sec_file = new File( sec_file_path  );
				sec_file.mkdir();        //���������ļ���
				
				gen_file( copyedPath ,sec_file_path  );
			}
						
		}	
		input2.close();	
		return true;
	}
}
