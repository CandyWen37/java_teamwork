package test;

import java.io.File;


public class DeleteFolder {

		DeleteFolder( String folderPath ){
			delete_file (  folderPath );		
		}
		
		//����
		DeleteFolder( File folder ){
			delete_file ( folder.getPath() );	
		}
		
		
		//��һ�汾��ɾ�ļ��к����������·��ֻ�����ļ���·�����������ļ�
		public void delete_file( String folderPath ) {
			File folder = new File( folderPath );
			File[] fileList = folder.listFiles();
			if( fileList != null ) {
				for(File f: fileList) {
					if( f.isFile() )
						f.delete();
					else if (f.isDirectory()){
						delete_file_completely( f.getPath() ); 
					}
				}
			}
			
			
		}
		
		//�����ǵڶ��汾��ɾ���ļ�����
		//����ɾ�������ļ��л��ļ��������������ļ��У������������ļ���Ҳɾ��
		public void delete_file_completely ( String folderPath ) { 
			File folder = new File( folderPath);
			if(folder.isFile()) {
				folder.delete();
			}
			else if(folder.isDirectory()) {
				File[] fileList = folder.listFiles();
				if( fileList != null ) {
					for(File f: fileList) {
						if(f.isFile()) 
							f.delete();
						else if(f.isDirectory())
							delete_file_completely( f.getPath());
					}
				}
				folder.delete();
			}
		}
	
	
}
