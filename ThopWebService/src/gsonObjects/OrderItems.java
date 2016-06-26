package gsonObjects;

public class OrderItems {
	private int orderItemId;
	private int itemId;
	private String orderItemEndDate;
	private double orderItemweight;
	private String orderItemStartDate;
	private boolean orderItemDelivery;
	private boolean orderItemCool;
	private boolean orderItemChop;
	private int orderItemPackage;
	private String orderItemAdditionalNotes;
	private String deliveryTime;

	public OrderItems(int orderItemId, int itemId, String orderItemEndDate, double orderItemweight, String orderItemStartDate, boolean orderItemDelivery, boolean orderItemCool, boolean orderItemChop, int orderItemPackage, String orderItemAdditionalNotes, String deliveryTime) {
		super();
		this.orderItemId = orderItemId;
		this.itemId = itemId;
		this.orderItemEndDate = orderItemEndDate;
		this.orderItemweight = orderItemweight;
		this.orderItemStartDate = orderItemStartDate;
		this.orderItemDelivery = orderItemDelivery;
		this.orderItemCool = orderItemCool;
		this.orderItemChop = orderItemChop;
		this.orderItemPackage = orderItemPackage;
		this.orderItemAdditionalNotes = orderItemAdditionalNotes;
		this.deliveryTime = deliveryTime;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getOrderItemEndDate() {
		return orderItemEndDate;
	}

	public void setOrderItemEndDate(String orderItemEndDate) {
		this.orderItemEndDate = orderItemEndDate;
	}

	public double getOrderItemweight() {
		return orderItemweight;
	}

	public void setOrderItemweight(double orderItemweight) {
		this.orderItemweight = orderItemweight;
	}

	public String getOrderItemStartDate() {
		return orderItemStartDate;
	}

	public void setOrderItemStartDate(String orderItemStartDate) {
		this.orderItemStartDate = orderItemStartDate;
	}

	public boolean isOrderItemDelivery() {
		return orderItemDelivery;
	}

	public void setOrderItemDelivery(boolean orderItemDelivery) {
		this.orderItemDelivery = orderItemDelivery;
	}

	public boolean isOrderItemCool() {
		return orderItemCool;
	}

	public void setOrderItemCool(boolean orderItemCool) {
		this.orderItemCool = orderItemCool;
	}

	public boolean isOrderItemChop() {
		return orderItemChop;
	}

	public void setOrderItemChop(boolean orderItemChop) {
		this.orderItemChop = orderItemChop;
	}

	public int getOrderItemPackage() {
		return orderItemPackage;
	}

	public void setOrderItemPackage(int orderItemPackage) {
		this.orderItemPackage = orderItemPackage;
	}

	public String getOrderItemAdditionalNotes() {
		return orderItemAdditionalNotes;
	}

	public void setOrderItemAdditionalNotes(String orderItemAdditionalNotes) {
		this.orderItemAdditionalNotes = orderItemAdditionalNotes;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

}
