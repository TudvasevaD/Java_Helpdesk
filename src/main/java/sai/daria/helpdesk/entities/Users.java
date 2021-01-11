package sai.daria.helpdesk.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @SequenceGenerator(name="newRec", sequenceName="USER_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newRec")
    @Column(name = "idUsers", unique = true,nullable = false)
    private Integer id;

    @Column(name = "UsersName", length = 20,nullable = true)
    private String name;

    @Column(name = "UsersCabinet", length = 10,nullable = true)
    private String cabinet;

    @Column(name = "UsersPassword", length = 30,nullable = true)
    private String password;

    public Users() {
        //nop
    }

    public Users(String name, String cabinet) {
        this.name = name;
        this.cabinet = cabinet;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCabinet() {
        return cabinet;
    }
    public void setComm(String comm) {
        this.cabinet = cabinet;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id: " + id +
                ", Name: '" + name + '\'' +
                ", Cabinet: '" + cabinet +
                '}';
    }
}
