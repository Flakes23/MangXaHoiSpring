import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import React from 'react';
import './Profile.css';

const posts = [
    { id: 1, content: 'Chào mọi người! Đây là bài đăng đầu tiên của mình.' },
    { id: 2, content: 'Hôm nay trời đẹp, mình đi dạo công viên.' },
];

const Profile = () => {
    const coverSrc = '/images/cover.jpg';
    const avatarSrc = '/images/avatar.jpg';

    return (
        <>
            <div className="app-root">
                <header className="fb-navbar">
                    <div>
                        <nav>
                            <div className="nav-left">
                                <img src="./images/logo.png" alt="Logo" />
                                <input type="text" placeholder="Tìm Kiếm..." />
                            </div>
                            <div className="nav-middle">
                                <a href="#">
                                    <i className="fa-solid fa-home"></i>
                                </a>
                                <a href="#">
                                    <i className="fa-solid fa-user-friends"></i>
                                </a>
                                <a href="#">
                                    <i className="fa-solid fa-play-circle"></i>
                                </a>
                                <a href="#">
                                    <i className="fa-solid fa-users"></i>
                                </a>
                            </div>
                            <div className="nav-right">
                                <a href="#">
                                    <i className="fas fa-ellipsis-h"></i>
                                </a>
                                <a href="#">
                                    <i className="fas fa-bell"></i>
                                </a>
                                <span className="profile"></span>
                            </div>
                        </nav>
                    </div>
                </header>

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
                        <div>
                            
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


                    <div className="profile-posts">
                        {posts.map(post => (
                            <div key={post.id} className="post-card">
                                <p>{post.content}</p>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </>
    );
};

export default Profile;