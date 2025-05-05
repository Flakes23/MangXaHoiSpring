import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import React from 'react';
import './Profile.css';
import Navbar from '../impl/Navbar';
import cover from "../../assets/public/images/cover.jpg";
import avatar from "../../assets/public/images/avatar.jpg";

// Component hiển thị một bài viết đầy đủ như Facebook
const hienkhunganh = () => {
  setIsVisibleavatar(!isVisibleavatar);
};
const Post = ({ post, currentUserAvatar }) => (
    <div className="post-card">
      <div className="post-header">
        <img className="post-avatar" src={post.avatar} alt={`${post.name} avatar`} />
        <div className="post-user-info">
          <strong>{post.name}</strong>
          <div className="post-meta">
            <span className="timestamp">{post.date}</span>
            <i className={`fas ${post.privacyIcon} privacy-icon`}></i>
          </div>
        </div>
        <i className="fas fa-ellipsis-h post-options"></i>
      </div>
  
      <div
        className={`post-content${post.backgroundColor ? ' background-card' : ''}`}
        style={post.backgroundColor ? { backgroundColor: post.backgroundColor } : {}}
      >
        {post.content.split('\n').map((line, i) => (
          <p key={i}>{line}</p>
        ))}
      </div>
  
      <div className="post-reactions">
        {post.reactions.length > 0 && (
          <><i className="far fa-laugh"></i> {post.reactions.join(', ')} và {post.othersLikeCount} người khác</>
        )}
      </div>
  
      <div className="post-actions">
        <span><i className="far fa-thumbs-up"></i> Thích</span>
        <span><i className="far fa-comment"></i> Bình luận</span>
        <span><i className="fas fa-share"></i> Chia sẻ</span>
      </div>
  
      <div className="post-comment-box">
        <img className="comment-avatar" src={currentUserAvatar} alt="Bạn avatar" />
        <input type="text" placeholder="Viết bình luận..." />
      </div>
    </div>
  );

  const posts = [
    {
      id: 1,
      name: 'Nguyễn Văn A',
      avatar: avatar,
      date: '21 tháng 2',
      privacyIcon: 'fa-globe-americas',
      backgroundColor: '#d500f9',
      content: '*Trường đại học siêu tốt thì gọi là gì?*\n- Thì gọi là SGU!!! (Super Good University) 😉😉😉',
      reactions: ['Bạn'],
      othersLikeCount: 7,
    },
    {
      id: 2,
      name: 'Nguyễn Văn A',
      avatar: avatar,
      date: '22 tháng 2',
      privacyIcon: 'fa-user-friends',
      backgroundColor: null,
      content: '😎',
      reactions: [],
      othersLikeCount: 0,
    },
  ];

const Profile = () => {
    const coverSrc = cover;
    const avatarSrc = avatar;

    return (
        <>
            <div className="app-root">
                <Navbar />
                <div className="profile-bgTop">
                    <div className="profile-containerTop">
                        <div className="profile-header">
                            <div
                                className="cover-photo"
                                style={{ backgroundImage: `url(${coverSrc})` }}
                                aria-label="Ảnh bìa cá nhân"
                            />
                            <button className="edit-cover-btn">Chỉnh sửa ảnh bìa</button>
                            <img className="avatar" src={avatarSrc} alt="Avatar cá nhân" />
                        </div>
                        <div className="profile-info">
                            <h1>Nguyễn Văn A</h1>
                            <p>Software Engineer | HCMC, Vietnam</p>
                            <div className="info-details">
                                <div><strong>Sinh nhật:</strong> 1/1/1990</div>
                                <div><strong>Sống tại:</strong> Thành phố Hồ Chí Minh</div>
                                <div><strong>Công việc:</strong> Công ty XYZ</div>
                            </div>
                        </div>
                        <div className="actions-menubar">
                            <a href="#" className="active">Bài viết</a>
                            <a href="#">Bạn bè</a>
                            <a href="#">Hình ảnh</a>
                            <a href="#">Chỉnh sửa cá nhân</a>
                        </div>
                    </div>
                </div>

                <div className="profile-container">
                    <div className="creat-profile-posts">
                        <div className="new-posts">
                            <span className="profile"></span>
                            <input type="text" placeholder="Bạn đang nghĩ gì?" />
                        </div>
                    </div>

                    <div className="profile-posts">
                    {posts.map(post => (
          <Post key={post.id} post={post} currentUserAvatar={avatarSrc} />
        ))}
                    </div>
                </div>
            </div>
        </>
    );
};

export default Profile;