package sai.daria.helpdesk.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @SequenceGenerator(name="newRec", sequenceName="REQUEST_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newRec")
    @Column(name = "idRequests", unique = true,nullable = false)
    private Integer id;

    @Column(name = "RequestsText", length = 1500,nullable = true)
    private String text;

    @Column(name = "RequestsData", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rdate;

    @Column(name = "RequestsComm", length = 500,nullable = true)
    private String comm;

    @Column(name = "Status_idStatus", nullable = false)
    private Integer status;

    @Column(name = "Theme_idTheme", nullable = false)
    private Integer theme;

    @Column(name = "Users_idUsers", nullable = false)
    private Integer user;

    public Request() {
        //nop
    }

    public Request(String text, Integer status, Integer user, Integer theme, Date rdate, String comm) {
        this.text = text;
        this.status = status;
        this.user = user;
        this.theme = theme;
        this.rdate = rdate;
        this.comm = comm;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser() {
        return user;
    }
    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getTheme() {
        return theme;
    }
    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public Date getRdate() {
        return rdate;
    }
    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getComm() {
        return comm;
    }
    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id: " + id +
                ", Text: '" + text + '\'' +
                ", Status: '" + status + '\'' +
                ", Users: '" + user + '\'' +
                ", Theme: '" + theme + '\'' +
                ", Date: " + rdate + '\'' +
                ", Commentary: '" + comm  +
                '}';
    }
}