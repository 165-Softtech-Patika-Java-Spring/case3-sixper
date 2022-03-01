package com.case3.app.entity;

import com.case3.app.enums.UserType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="USERS")
@Data
public class User {


    @Id
    @GeneratedValue(generator = "productUser")
    @SequenceGenerator(name = "productUser", sequenceName = "PRODUCT_USER_ID_SEQ")
    private Long id;

    @Column(name = "USER_NAME", length = 100, nullable = false)
    private String userName;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 20, nullable = false)
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30, nullable = false)
    private UserType userType;
}
