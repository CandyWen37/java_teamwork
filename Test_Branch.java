package test;

import java.io.IOException;

public class Test_Branch {

	public static void main(String[] args) throws IOException {
		//Branch t =new Branch ("git_13_49");
		Branch t = new Branch();
		System.out.println("�����ǵ�ǰ�����з�֧��");
		System.out.println( t.listBranch() );
		t.change_branch("git_13_49");
	}

}
