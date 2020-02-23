package rv.lesson.model;

import java.util.Date;

public class Order {
	private Integer id;
	private Integer userId;
	private String deliveryAddress;
	private Date createDate;
	
	public Order(Integer id, Integer userId, String deliveryAddress, Date createDate) {
		this.id = id;
		this.userId = userId;
		this.deliveryAddress = deliveryAddress;
		this.createDate = createDate;
	}

	public Order(Integer userId, String deliveryAddress, Date createDate) {
		this.userId = userId;
		this.deliveryAddress = deliveryAddress;
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (deliveryAddress == null) {
			if (other.deliveryAddress != null)
				return false;
		} else if (!deliveryAddress.equals(other.deliveryAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", deliveryAddress=" + deliveryAddress + ", createDate="
				+ createDate + "]";
	}

	
}


