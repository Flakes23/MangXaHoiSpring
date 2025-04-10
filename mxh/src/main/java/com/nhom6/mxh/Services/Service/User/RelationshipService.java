package com.nhom6.mxh.Services.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.DTO.RelationshipDTO;
import com.nhom6.mxh.Models.Message.Message;
import com.nhom6.mxh.Models.User.Relationship;
import com.nhom6.mxh.Models.User.StatusRelationship;
import com.nhom6.mxh.Models.User.User;

@Service
public interface RelationshipService {
    List<Relationship> findAllByUserOne(User user1);
    void addUser(Relationship relationship);
    Relationship findById(Long id);
    Relationship findRelationship(User userOne, User userTwo);
    List<Relationship> findAllByUserOneId(User user);
    List<RelationshipDTO> orderByCreateAt(List<RelationshipDTO> relationships);
    Relationship findByMessage(List<Message> messages);
    List<User> findFriends(User user);
    List<Relationship> findRelationshipPending(User user);
    List<User> findNotFriends(User user);
    int countMutualFriends(User user, Long friendId);
    int countfriend(User user, StatusRelationship status);
    
}
