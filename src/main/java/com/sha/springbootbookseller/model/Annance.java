package com.sha.springbootbookseller.model;

import lombok.Data;

import javax.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 3.07.2021
 * @time 17:36
 */
@Data
@Entity
@Table(name = "Annance")
public class Annance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "price", nullable = false)
    private Double price;
    
    @Enumerated(EnumType.STRING)
	private Category category;
    
    @Column(name = "isExpired", nullable = false)
    private String isExpired;
    
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;
    
    
    @ManyToOne()
    @JoinColumn(
			name = "UserId",
			referencedColumnName = "id")
    private User user;
    
    
}
