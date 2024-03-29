package companyb.companyb.companyData;

import javax.persistence.*;

@Entity
@Table(name = "companyb")
public class CustomerDeatail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "id_card_number")
    private String id_card_number;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "credit_card")
    private String credit_card;

    @Column(name = "gender")
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public CustomerDeatail(int id, String username, String password, String email, String id_card_number, String fname, String lname, String address, String phone, String credit_card, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.id_card_number = id_card_number;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.credit_card = credit_card;
        this.gender = gender;
    }

    public CustomerDeatail() {
    }

    public CustomerDeatail(String username, String password, String email, String id_card_number, String fname, String lname, String address, String phone, String credit_card, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id_card_number = id_card_number;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.credit_card = credit_card;
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "CustomerDetail{" +
                "id=" + this.id +
                ", username=" + this.username + '\''+
                ", password='" + this.password + '\'' +
                ", email=" + this.email + '\'' +
                ", idCard=" + this.id_card_number + '\'' +
                ", firstName=" + this.fname + '\'' +
                ", lastName=" + this.lname + '\'' +
                ", address=" + this.address + '\'' +
                ", phone=" + this.phone + '\'' +
                ", creditCard=" + this.credit_card + '\'' +
                ", gender=" + this.gender + '\'' +
                '}';
    }
}
