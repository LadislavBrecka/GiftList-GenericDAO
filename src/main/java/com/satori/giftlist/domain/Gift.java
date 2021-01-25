package com.satori.giftlist.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@Table(name="gift")
public class Gift {
    @Id
    @Nullable
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NonNull
    @Column(name="user_id")
    private Integer userId;

    @NonNull
    @Column(name="name")
    private String name;

    @NonNull
    @Column(name="receiver")
    private String receiverName;

    @NonNull
    @Column(name="price")
    private Double price;

    public Gift() {
    }

    public Gift(@NonNull Integer userId, @NonNull String name, @NonNull String receiverName, @NonNull Double price) {
        this.userId = userId;
        this.name = name;
        this.receiverName = receiverName;
        this.price = price;
    }
}
