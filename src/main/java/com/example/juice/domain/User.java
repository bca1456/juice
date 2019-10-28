package com.example.juice.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) // 1 - чтобы не заморачиваться в создании таблиц для enum в бд
                                                                            // жадная подгрузка - быстрее, но больше памяти жрет. Использовать , когда мало данных в бд
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id")) //данное поле будет храниться в таблице, для которой не описывали мэпинг
    //позволяет создать таблицу для roles с именем user_role , которая будет соединяться с текущей по user_id
    @Enumerated(EnumType.STRING) //хотим хранить enum в видео строки
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
