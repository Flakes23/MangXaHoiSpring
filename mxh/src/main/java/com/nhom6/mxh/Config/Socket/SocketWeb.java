package com.nhom6.mxh.Config.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.nhom6.mxh.DTO.MessageDTO;
import com.nhom6.mxh.DTO.UserDTO;
import com.nhom6.mxh.DTO.UserMessageDTO;
import com.nhom6.mxh.Models.Message.Message;
import com.nhom6.mxh.Models.User.Notification;
import com.nhom6.mxh.Models.User.Relationship;
import com.nhom6.mxh.Models.User.User;
import com.nhom6.mxh.Services.Service.User.RelationshipService;

@Component
public class SocketWeb {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RelationshipService relationshipService;

    public void sendMessage(Message message) {
        UserMessageDTO userMessageDTO = new UserMessageDTO(message.getUserFrom());
        Relationship relationship = relationshipService.findRelationship(message.getUserFrom(), message.getUserTo());
        MessageDTO messageDTO = MessageDTO.builder()
                                          .id(relationship.getId())
                                          .content(message.getContent())
                                          .createAt(message.getCreateAt())
                                          .userFrom(userMessageDTO)
                                          .build();
        simpMessagingTemplate.convertAndSendToUser(message.getUserTo().getEmail(), "/queue/messages", messageDTO);//Gửi tin nhắn đến userTo
    }

    public void setActive(User user) {
        UserDTO userDTO =UserDTO.builder()
                                .id(user.getId())
                                .isActive(true)
                                .build();
        simpMessagingTemplate.convertAndSend("/queue/active", userDTO); //Gửi thông báo active đến tất cả user
    }

    public void setSeen(Relationship relationship, User user) {
        
        simpMessagingTemplate.convertAndSendToUser(user.getEmail(), "/queue/seen", relationship.getId()); //Gửi thông báo seen đến user
    }

    public void sendFriendRequestNotification(Notification notification) {
        simpMessagingTemplate.convertAndSendToUser(notification.getUser().getEmail(), "/queue/addfriend", notification);
    }
}
