package dev.mvc.member;

public class MemberVO {
  /*empno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ename VARCHAR(20) NOT NULL,
  gender VARCHAR(5) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(100) NOT NULL,
  zipcode VARCHAR(10) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL*/
  private int empno;
  private String ename;
  private String gender;
  private int age;
  /** 八祸 + 惑技 林家 */
  private String address;
  /** 八祸 林家  */
  private String address1;
  /** 惑技 林家 */
  private String address2;
  private String zipcode;
  private String phone;
  private String email;
  
  
  public MemberVO() {
  }

  public MemberVO(int empno, String ename, String gender, int age,
      String address, String zipcode, String phone, String email) {
    super();
    this.empno = empno;
    this.ename = ename;
    this.gender = gender;
    this.age = age;
    this.address = address;
    this.zipcode = zipcode;
    this.phone = phone;
    this.email = email;
  }
  
  public int getEmpno() {
    return empno;
  }
  public void setEmpno(int empno) {
    this.empno = empno;
  }
  public String getEname() {
    return ename;
  }
  public void setEname(String ename) {
    this.ename = ename;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress() {
    this.address = this.address1+this.address2;
  }
  
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  
}
