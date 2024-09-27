package org.virtualization.entity

import jakarta.persistence.*

@Entity
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null;
    @Column
    var text: String?=null;
}