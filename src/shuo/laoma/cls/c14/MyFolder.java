package shuo.laoma.cls.c14;

import java.util.Date;

public class MyFolder {
	//文件夹名称
	private String name;
	
	//创建时间
	private Date createtime;
		
	//上级文件夹
	private MyFolder parent;
	
	//包含的文件
	private MyFile[] files;
	
	//包含的子文件夹
	private MyFolder[] subFolders;
	
	public int totalSize(){
		int totalSize = 0;
		if(files!=null){
			for(MyFile file : files){
				totalSize+=file.getSize();
			}
		}
		if(subFolders!=null){
			for(MyFolder folder : subFolders){
				totalSize+=folder.totalSize();
			}
		}
		return totalSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public MyFolder getParent() {
		return parent;
	}

	public void setParent(MyFolder parent) {
		this.parent = parent;
	}

	public MyFile[] getFiles() {
		return files;
	}

	public void setFiles(MyFile[] files) {
		this.files = files;
	}

	public MyFolder[] getSubFolders() {
		return subFolders;
	}

	public void setSubFolders(MyFolder[] subFolders) {
		this.subFolders = subFolders;
	}
	
}

