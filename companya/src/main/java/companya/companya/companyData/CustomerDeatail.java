package companya.companya.companyData;

import javax.persistence.*;

@Entity
@Table(name = "companya")
public class CustomerDeatail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String personal_id;
    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private String credit_card;
    private String gender;

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

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public CustomerDeatail(int id, String username, String password, String email, String id_card_number, String fname, String lname, String address, String phone, String credit_card, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.personal_id = id_card_number;
        this.first_name = fname;
        this.last_name = lname;
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
        this.personal_id = id_card_number;
        this.first_name = fname;
        this.last_name = lname;
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
                ", idCard=" + this.personal_id + '\'' +
                ", firstName=" + this.first_name + '\'' +
                ", lastName=" + this.last_name + '\'' +
                ", address=" + this.address + '\'' +
                ", phone=" + this.phone + '\'' +
                ", creditCard=" + this.credit_card + '\'' +
                ", gender=" + this.gender + '\'' +
                '}';
    }
}
