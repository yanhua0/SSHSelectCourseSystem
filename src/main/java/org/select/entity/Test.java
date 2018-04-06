package org.select.entity;
import javax.persistence.*;

@Entity
@Table(name="test")
public class Test {

    @Column(name="id",nullable = false)
    private int id;
    @Id
    @Column(name="username",length = 20)
    private String username;

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
}
