package shuo.laoma.cls.c14;

import java.util.Date;

public class MyFile {
	//文件名称
	private String name;
	
	//创建时间
	private Date createtime;
	
	//文件大小
	private int size;
	
	//上级目录
	private MyFolder parent;

	public int getSize() {
		return size;
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

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
