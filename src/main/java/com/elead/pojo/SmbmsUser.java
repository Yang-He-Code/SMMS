package com.elead.pojo;

import java.util.Date;

public class SmbmsUser {
    private Long id;

    private String usercode;

    private String username;

    private String userpassword;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Long userrole;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    
    @Override
    public String toString() {
        return "SmbmsUser [id=" + id + ", usercode=" + usercode + ", username=" + username + ", userpassword="
                + userpassword + ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", address="
                + address + ", userrole=" + userrole + ", createdby=" + createdby + ", creationdate=" + creationdate
                + ", modifyby=" + modifyby + ", modifydate=" + modifydate + "]";
    }


    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getUsercode() {
        return usercode;
    }

    
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getUserpassword() {
        return userpassword;
    }

    
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    
    public Integer getGender() {
        return gender;
    }

    
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    
    public Date getBirthday() {
        return birthday;
    }

    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
    public String getPhone() {
        return phone;
    }

    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public Long getUserrole() {
        return userrole;
    }

    
    public void setUserrole(Long userrole) {
        this.userrole = userrole;
    }

    
    public Long getCreatedby() {
        return createdby;
    }

    
    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    
    public Date getCreationdate() {
        return creationdate;
    }

    
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    
    public Long getModifyby() {
        return modifyby;
    }

    
    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    
    public Date getModifydate() {
        return modifydate;
    }

    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
    
    

    
   
}