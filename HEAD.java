package test;

import java.io.*;
import java.util.Scanner;

//Ҫ����һ���洢����HEAD���ļ�������commit��¼ֻͣ�����ڴ��У��´��޷��ҵ�
public class HEAD {

	private static String gitPath;
	private File head_file;
	public String head;
	
	HEAD() throws FileNotFoundException{
		gitPath = Commit.gitPath;
		this.head_file = new File(gitPath + "\\" + "HEAD");
		this.head = get_head();
	}
	
	public void update_head ( String commit ) throws IOException {
		if( !head_file.exists() ) {
			head_file.createNewFile();
			PrintWriter output = new PrintWriter(head_file);
			output.print( commit );        
			output.close();
			System.out.println("HEAD�ļ��ѽ�����");
		}
		else {
			PrintWriter output = new PrintWriter(head_file);
			output.print( commit );        //�Ḳ��֮ǰ�����ݡ�HEAD�ļ���Զֻ�������µ�һ��commit
			output.close();
			System.out.println("HEAD�ļ��Ѹ��¡�");
		}
	}
	
	public String get_head() throws FileNotFoundException {
		if( !head_file.exists() ) {
			return null;
		}
		else {
			/*
			 * GetValue gg = new GetValue();  //���һ�����з�������
				String head = gg.getValue(gitPath + "\\" + "HEAD");
			 */
			Scanner input = new Scanner(head_file);
			head = input.nextLine();
			input.close();
			return head;
		}
	}
	
	public String get_last_tree_key() throws FileNotFoundException {
		if( !this.head_file.exists() )
			return null;
		else {
			File last_commit = new File(gitPath + "\\"+ this.head);	
			Scanner input = new Scanner( last_commit );
			String last_tree_key = input.nextLine();   //��һ�о��Ǵ����tree_key  
			input.close();
			return last_tree_key;
		}
	}
	
}
