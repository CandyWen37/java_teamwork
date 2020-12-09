package test;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;

/* С������һҪʵ�֣�
��װ��һ����
	1. ����value����洢����Ӷ�Ӧ��key-value
	2. ����key�����ҵõ���Ӧ��valueֵ

����һ��TeamTask1�࣬

������
	ԭʼ�ļ���·����filePath
	���ļ��Ĺ�ϣֵ��key
	�µ��ļ�·����newPath
	�ļ������ݣ�value

������
	1 ���ع�ϣֵ�ġ��ַ����顱��ʾ��public static byte[] SHA1Checksum(InputStream is) throws Exception
	2 ���ַ���������ʮ�����ƹ�ϣֵ�ĺ���: public static String convertToHexString(byte data[])
	3 ���ļ�·�����õ��ļ����ݵĹ�ϣֵ��hash(String filePath)
	4 ����value����洢����Ӷ�Ӧ��key-value�ĺ�����Ҳ���Ǵ���ͬ�����ݵ��ļ���Ϊkey�����ļ���addFile(String filePath)
	5 ����key�����Ҷ�Ӧ��value�ĺ���,���ص����ļ���key����ַ�����ʽ��ȫ�����ݣ�getValue(String key)	
*/

public class TeamTask1 {
	
	public String filePath;
	public String newPath;
	public String key;
	public String value;
	
	//���캯��������ԭʼ·����������Ҫ�Ž��ļ�����·����
	TeamTask1( String filePath, String newPath) throws IOException{
	
		
		this.filePath = filePath;
		this.newPath = newPath;
		key = addFile( filePath );
		value = getValue(key);
	}
	

	 public static byte[] SHA1Checksum( InputStream is ) throws Exception {   //�β����ļ�������
	        
	        byte[] buffer = new byte[1024];    // ���ڼ���hashֵ���ļ�������
	        
	        MessageDigest complete = MessageDigest.getInstance("SHA-1");  // ʹ��SHA1��ϣ/ժҪ�㷨
	        int numRead = 0;
	        do {
	            numRead = is.read(buffer);   // ��is�������ж�ȡbuffer.length��������Ƕ�ȡ�����ޣ��ֽڣ��浽buffer��
	            							//����ʵ�ʶ�ȡ�����ֽ������ظ�numRead��
	            							//����ȡ���ļ�ĩβʱ������-1��
	            if (numRead > 0) {
	                
	                complete.update(buffer, 0, numRead);   
	                	//�ú���update����һ��������ʾ��Ҫ���ӵ�complete�����ݣ�
	                	//�ڶ�����������buffer�Ķ�ȡ��ʼ�㣬��������������buffer��ȡ�೤��
	            } 
	        } while (numRead != -1);    // numRead == -1�����ļ���ȡ�����
	        //is.close();      			// �ر������� ??�����ܹأ����滹Ҫ�õ� 
	        return complete.digest(); 
	        // ����SHA1��ϣֵ,����MessageDigest�����digest()�������ص����ַ����飬����ȥ��Ҫת����16����
	    }
	 
	 public static String convertToHexString(byte data[]) { 
	    	// ����MessageDigest�����digest()�������ص����ַ����飬
	    	//Ҫ�õ�ʮ�����Ƶ�sha1ֵ����ҪתΪ�ַ���  
	    	StringBuffer strBuffer = new StringBuffer(); 
	    	for (int i = 0; i < data.length; i++) {
	    		strBuffer.append(Integer.toHexString(0xff & data[i])); // ��ʮ��������oxff��ĳ���ֽ�ֵ����λ�����㣬
											// ֻ������32λ�����8λ����֤����ת����ʮ�����Ʋ������
	    		}
	    	return strBuffer.toString();
	}
	 
	 //3 ���ļ�·�����õ��ļ����ݵĹ�ϣֵ��hash(String filePath)
	 public static String hash ( String path) {
		 try {
			 File file = new File ( path);   //���ļ�·��ת�����ļ���Ķ���
			 FileInputStream is = new FileInputStream (file);
			 byte[] sha1 = SHA1Checksum(is);     //�β����ļ�������
			 String result_hash = convertToHexString( sha1);
			 return result_hash;
		 }
		 
		 catch(Exception e) {
			 return "error! ·��������";
		 }
	
	 }
	 
	//4 ����value��ԭ�ļ�������洢����Ӷ�Ӧ��key-value�ĺ�����addFile(String filePath)�����ص���ԭ�ļ���key
	 public  String addFile(String filePath) throws IOException{
		 String key = hash (filePath);
		 File newFile = new File( newPath + key);   //�����е����µ��ļ�·����
		 newFile.createNewFile();
		
		 FileInputStream fileis = new FileInputStream(filePath);
		 FileOutputStream fileos = new FileOutputStream(newFile);
		 
		 byte[] buffer = new byte[1024];  //����һ���ֽڻ�����
		 int numRead = 0;
		 
		 do {
			 numRead = fileis.read(buffer);
			 if( numRead > 0 ) {
				fileos.write(buffer, 0, numRead); 
				 
			 }
		 } while ( numRead != -1);
		 
		fileis.close();
		fileos.close();
		 
		 
		 return key;
	 }
	 
	 //5 ����key�����Ҷ�Ӧ��value�ĺ���,���ص����ļ���key����ַ�����ʽ��ȫ�����ݣ�getValue(String key)
	 public  String getValue ( String key )  throws FileNotFoundException {
		 File file = new File (newPath + key);
		 try {
			 Scanner fileInput = new Scanner (file); // ɨ����������·�����ļ�������
			 StringBuffer stringbuffer = new StringBuffer();
			 while (fileInput.hasNextLine()) {
				 stringbuffer.append( fileInput.nextLine()).append('\n');
			 }
			 fileInput.close();
			 return stringbuffer.toString();
		 }
		 catch (Exception c) {
			 System.out.println("key��Ӧ���ļ�������");
			 return null;
		 }
		 
	 }
	 
	

}
