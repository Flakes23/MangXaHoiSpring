package com.nhom6.mxh.Services.Service.Message;

import com.nhom6.mxh.Models.Message.Message;
import com.nhom6.mxh.Models.User.Relationship;
import com.nhom6.mxh.Models.User.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    List<Message> messageFromUser(User userFrom,User userTo);
    void sendMessage(Message message);
    List<Message> findByContent(String content);
    Message findLatestMessage(User userFrom,User userTo);
    void seenMessage(Relationship relationships, User user);
    List<Object[]> countMessageBetweenTwoUserIsSeen(User user);
    Message findById(Long id);
    List<Object[]> countUnseenMessageByUserTo(User userTo);
}
