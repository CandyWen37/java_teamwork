package test;

import java.io.File;
import java.io.IOException;

//������һ�������࣬���ڸ����ļ��е�ȫ������

public class CopyTree {
	
	    //filePath��ԭ�ļ��е�·����
	    //goalPath�����ļ��е�·����      //����֮ǰ���ļ����Ѵ��ڣ�����ǿ��ļ��У���û��ǿ��Ҫ��
	CopyTree( String filePath, String goalPath ) throws IOException{
		gen_file(filePath, goalPath);	
	}
	CopyTree(){};
	
	public void gen_file( String filePath, String goalPath) throws IOException {
		File file = new File (filePath);
		File[] fileList = file.listFiles();
		
		for( int i=0; i<fileList.length; i++) {
			if( fileList[i].isFile() )
				new CopyBlob(fileList[i], goalPath );
			else if ( fileList[i].isDirectory() ) {
				File sec_file = new File( goalPath + "\\" + fileList[i].getName() );
				sec_file.mkdir();
				gen_file( fileList[i].getPath(), sec_file.getPath() );
				
				
			}
		}		
	}	
}
