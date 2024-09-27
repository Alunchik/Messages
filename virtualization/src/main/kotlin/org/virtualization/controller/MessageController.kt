package org.virtualization.controller

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.virtualization.entity.Message
import org.virtualization.repository.MessageRepository
import java.nio.file.Paths
import kotlin.io.path.readBytes

@RestController
@Slf4j
class MessageController {

    val messageRepository: MessageRepository;

    @Autowired constructor(messageRepository: MessageRepository){
        this.messageRepository = messageRepository;
    }

    @GetMapping("/")
    fun getAllMessages(): Iterable<Message>{
        return messageRepository.findAll();
    }
    @PostMapping("/")
    fun addMessage(@RequestBody message: Message): Iterable<Message>{
        messageRepository.save(message);
        return messageRepository.findAll();
    }
    @GetMapping("/logo", produces = arrayOf(MediaType.IMAGE_JPEG_VALUE))
    fun getLogo(): ByteArray{
        var path = Paths.get("/usr/local/lib/logo.png");
        return path.readBytes();
    }
}