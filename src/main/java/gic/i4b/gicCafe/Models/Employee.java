package gic.i4b.gicCafe.Models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "employee")
@Table(
    name = "employee_table",
    uniqueConstraints = {@UniqueConstraint( name = "username",  columnNames = "username")}
)
public class Employee {

    @Id
    @SequenceGenerator(
        name = "employee_genderator",
        sequenceName = "employee_genderator",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "employee_genderator"
    )

    @Column(
        name = "id",
        updatable = false
    )
    private Integer id;

    @Column(
        name = "firstname",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
        name = "lastname",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
        name = "sex",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String sex;


    @Column(
        name = "username",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String username;

    @Column(
        name = "password",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String password;

    @Column(
        name = "role",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String role;

    @Column(
        name = "dob",
        nullable = false,
        columnDefinition = "TEXT"
    )
    // @JsonFormat(pattern="yyyy-MM-dd")
    private String dob;

    @Column(
        name = "image_path",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String image_path;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date start_workDate;


    public Employee(String firstname, String lastname, String role, String sex, String dob, String username, String password, String image_path){
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.dob = dob;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.image_path = image_path;
    }

    public Employee(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Date getstart_workDate() {
        return start_workDate;
    }

    public void setstart_workDate(Date start_workDate) {
        this.start_workDate = start_workDate;
    }

}