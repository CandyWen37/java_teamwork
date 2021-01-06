package test;

/*�������������Ҫ������һ��������Tree_content��
 * 	������
 * 		-���ͣ�blob or tree
 * 		-��ϣ��
 * 		-�ļ�ԭ��������׺����
 * 	������
 * 		+���캯�����������ļ���·���������������������
 * 			���洢ԭ�ļ�����ġ����ļ��������֡������ļ����Ĺ�ϣ�롢�����ļ��������ͣ�blob or tree)
 * 		+String output(): �������������������
 * 		+String getName();
 * 		+String getKey();
 * 		+String getType();
 * 		+void get_tree_content( String line)   //�����������ʽΪTree�ļ��е�һ�� 
 * 				//���ع�ʹ�ã��õ�tree��ÿһ�е�������Ϣ
 */

import java.io.File;
import java.io.IOException;

public class Tree_content {
	private String name;
	private String key;
	private String type;
	protected String objectPath = Tree.objectPath;
	
	
	Tree_content(){};
	Tree_content(String f ) throws IOException {    //�������P1�����ļ�·���� file2[i].getPath()
		File file = new File(f);
		name = file.getName();
		Gen_hash t = new Gen_hash(); 
		
		if(file.isFile()) {
			type = "Blob";
			key = t.hash(f);
			new Blob( file.getPath(), objectPath );   //Ҫ������Blob�ļ���������, ���ع�ʹ��
				                 
		}
			
		
		else if (file.isDirectory()) {
			type = "Tree";
			Tree tree = new Tree( f, objectPath );      //Ҫ������Tree�ļ���������, ���ع�ʹ��
			String treeValue = tree.getValue();
			key = t.hashString(  treeValue );
		}	
	}
	
	public String output() {
		StringBuilder result = new StringBuilder ();
		result.append(this.type).append("\t");
		result.append(this.key).append("\t");
		result.append(this.name);	          //ĩβ��Ҫ�ӻ��з���Ҫ��Tree.java�ļ���ĺ����У����ڸ��еĿ�ͷ��
		return result.toString();
	}
	
	public String getType() {
		return this.type;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getKey() {
		return this.key;
	}
	
	//���ع�ʹ�ã��õ�tree��ÿһ�е�������Ϣ
	public void get_tree_content( String line) {    //�����������ʽΪTree�ļ��е�һ��  
		this.type = line.substring(0,4);
		this.key = line.substring(5,45);
		this.name = line.substring(46);	
	}     
	

}
