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
 * 
 */

import java.io.File;
import java.io.IOException;
public class Tree_content {
	private String name;
	private String key;
	private String type;
	
	Tree_content(String f ) throws IOException {    //�������P1�����ļ�·���� file2[i].getPath()
		File file = new File(f);
		name = file.getName();
		Gen_hash t = new Gen_hash();
		
		if(file.isFile()) {
			type = "Blob";
			key = t.hash(f);
			 new Blob( file.getPath(), "D:\\Ajava_object" );   //Ҫ������Blob�ļ���������, ���ع�ʹ��
				                 
		}
			
		
		else if (file.isDirectory()) {
			type = "Tree";
			Tree tree = new Tree( f, "D:\\Ajava_object" );            //Ҫ������Tree�ļ���������, ���ع�ʹ��
			String treeValue =tree.getValue();
			key = t.hashString(  treeValue );
		}
			
		
	}
	
	public String output() {
		StringBuilder result = new StringBuilder ();
		result.append(this.type).append("\t");
		result.append(this.key).append("\t");
		result.append(this.name).append("\n");	
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

}
