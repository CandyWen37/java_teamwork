package test;

/*�������������Ҫ������һ�������࣬Tree_content��
 * 	������
 * 		-���ͣ�blob or tree
 * 		-��ϣ��
 * 		-�ļ�ԭ��������׺����
 * 	������
 * 		+���캯�����������ļ���·���������������������
 * 			���洢ԭ�ļ�����ġ����ļ��������֡������ļ����Ĺ�ϣ�롢�����ļ��������ͣ�blob or tree)
 * 		+String output():
 * 			��ӡ���������������
 * 
 */

import java.io.File;
public class Tree_content {
	private String name;
	private String key;
	private String type;
	
	Tree_content(String f ) {    //�������P1�����ļ�·���� file2[i].getPath()
		File file = new File(f);
		name = file.getName();
		Gen_hash t = new Gen_hash();
		key = t.hash(f);
		if(file.isFile()) 
			type = "Blob";
		else if (file.isDirectory())
			type = "Tree";
	}
	
	public String output() {
		StringBuilder result = new StringBuilder ();
		result.append(this.type).append("\t");
		result.append(this.key).append("\t");
		result.append(this.name).append("\n");	
		return result.toString();
	}

}
