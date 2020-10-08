package com.thoughtworks.rslist.Po;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    private String gender;
    private Integer age;
    private String email;
    private String phone;
    private Integer vote = 10;
}
