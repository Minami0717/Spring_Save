package com.example.jpa1.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity//PK를무조건지정해줘야해서 빨간줄생길거다
@Table(name ="product")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)//부모값까지 투스트링해서 출력해준다
@EqualsAndHashCode(callSuper = true)//부모값까지 같아야 함 즉 완벽히 같은지
public class ProductEntity extends BaseEntity {
//동일성 : 주소값같고 동등성: 안에 값이 같냐

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private Long number;

    @Column(nullable = false,length = 10)// not null 주기
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;
}
