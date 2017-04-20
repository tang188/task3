package com.huaweisoft.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author tangzh
 */
@Service
public class User {

	@Autowired
    private int id;
	@Autowired
    private String name;
	@Autowired
    private String sex;
	@Autowired
    private String birthday;
	@Autowired
    private float height;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    /**
     * ���ι��캯��
     * @param id
     * @param name
     * @param sex
     * @param birthday
     * @param height
     */
    @Autowired
    public User(int id, String name, String sex, String birthday, float height) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.height = height;
    }
    /**
     * �޲ι��캯��
     */
    @Autowired
    public User() {
        
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", height=" + height + "]";
    }
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
    
}
