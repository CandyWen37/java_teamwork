package test;
import java.io.*;

//这是一个测试文件

/* 小组任务一要实现：
封装成一个类
	1. 给定value，向存储中添加对应的key-value
	2. 给定key，查找得到对应的value值
*/

public class Test_Blob {

	public static void main(String[] args)throws IOException, Exception  {
		String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\Java课程作业\\Charpter6_4.java";
		//String filePath = "C:\\Users\\chenxling\\Desktop\\workspace\\做实验的空文件.txt";  //测试空文件
        String gitPath = "D:\\AsimpleGit\\object";
		Blob teamtask1 = new Blob( filePath, gitPath );  //调用已经写好的TeamTask1类 
		
		
		System.out.println("原始路径名为： " + teamtask1.getFilePath() );
		System.out.println("新的路径名为： " + teamtask1.getObjectPath() );
		System.out.println("该文件的key为： " + teamtask1.getKey() );
		System.out.println("给定key值，查找到文件的内容为：\n" +  teamtask1.getValue() );
		
	}

}
