package org.virtualization.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.virtualization.entity.Message

interface MessageRepository: JpaRepository<Message, Long> {
}