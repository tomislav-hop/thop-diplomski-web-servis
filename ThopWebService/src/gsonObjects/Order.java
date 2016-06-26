package gsonObjects;

public class Order {

	private int orderId;
	private String orderOrdered;
	private String orderAdress;
	private String orderDate;
	private String additionalNotes;
	private int orderItemsId;
	private int statusId;

	public Order(int orderId, String orderOrdered, String orderAdress, String orderDate, String additionalNotes, int orderItemsId, int statusId) {
		super();
		this.orderId = orderId;
		this.orderOrdered = orderOrdered;
		this.orderAdress = orderAdress;
		this.orderDate = orderDate;
		this.additionalNotes = additionalNotes;
		this.orderItemsId = orderItemsId;
		this.statusId = statusId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderOrdered() {
		return orderOrdered;
	}

	public void setOrderOrdered(String orderOrdered) {
		this.orderOrdered = orderOrdered;
	}

	public String getOrderAdress() {
		return orderAdress;
	}

	public void setOrderAdress(String orderAdress) {
		this.orderAdress = orderAdress;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public int getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}
