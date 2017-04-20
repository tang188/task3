package com.huaweisoft.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author tangzh
 *
 */
@Service
public class ContactBook {
	@Autowired
    private int id;
	@Autowired
    private int userId;
	@Autowired
    private int type;
	@Autowired
    private String contact;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * ���ι��캯��
     * @param id
     * @param userId
     * @param type
     * @param contact
     */
    @Autowired
    public ContactBook(int id, int userId, int type, String contact) {
        super();
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.contact = contact;
    }
	@Override
	public String toString() {
		return "ContactBook [id=" + id + ", userId=" + userId + ", type="
				+ type + ", contact=" + contact + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + id;
		result = prime * result + type;
		result = prime * result + userId;
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
		ContactBook other = (ContactBook) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
