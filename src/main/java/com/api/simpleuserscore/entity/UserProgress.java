package com.api.simpleuserscore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/23/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int level;
    private float score;
    @OneToOne(cascade=CascadeType.DETACH, optional = false)
    private User user;
}
