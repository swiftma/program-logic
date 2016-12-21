package shuo.laoma.cls.c14;

import java.util.Date;

public class Order {
	//订单号
	private String id;
	
	//购买用户
	private User user;
	
	//购买产品列表及数量
	private OrderItem[] items;
	
	//下单时间
	private Date createtime;
	
	//收货人
	private String  receiver;
	
	//收货地址
	private String address;
	
	//联系电话
	private String phone;
	
	//订单状态
	private String status;
	
	public double computeTotalPrice(){
		double totalPrice = 0;
		if(items!=null){
			for(OrderItem item : items){
				totalPrice+=item.computePrice();
			}
		}
		return totalPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderItem[] getItems() {
		return items;
	}

	public void setItems(OrderItem[] items) {
		this.items = items;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}


