package com.nhom6.mxh.Models.Post;

import java.time.LocalDateTime;
import java.util.List;

import com.nhom6.mxh.Models.User.User;

import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment {
    @Id
    @Column(name = "idComment")
    private Long id;
    private String content;
    private LocalDateTime createAt;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_send_id", referencedColumnName = "IdUser")
    private User userSend;
  

}
