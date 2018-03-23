package com.user.pojo;

import java.io.Serializable;

public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5448929205316457059L;

	private String id;

    private String name;

    private Integer age;

    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}