package test;

import java.io.*;
import java.util.Scanner;

//要建立一个存储最新HEAD的文件，否则commit记录只停留在内存中，下次无法找到
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
			System.out.println("Commit成功，HEAD文件已建立。");
		}
		else {
			commit = "\n" + commit;
			FileOutputStream output = new FileOutputStream( head_file, true );  //HEAD文件会保存过往所有的commit
			output.write( commit.getBytes() );            //最新的commit在最后一行
			output.close();
			System.out.println("Commit成功，HEAD文件已更新。");
		}
	}
	
	public String get_head() throws FileNotFoundException {
		if( !head_file.exists() ) {
			return null;
		}
		else {
			Scanner input = new Scanner(head_file);
			String s = null;
			while( input.hasNextLine() ) {
				s = input.nextLine();
				
			}   //这个while循环是为了读取HEAD文件的最后一行，最后一行是最新的Head值。
			input.close();
			head = s;
			return head;
		}
	}
	
	public String get_last_tree_key() throws FileNotFoundException {
		if( !this.head_file.exists() )
			return null;
		else {
			File last_commit = new File(gitPath + "\\"+ this.head);	
			Scanner input = new Scanner( last_commit );
			String last_tree_key = input.nextLine();   //上一次的commit文件里的第一行就是存放着tree_key  
			input.close();
			return last_tree_key;
		}
	}
	
}
