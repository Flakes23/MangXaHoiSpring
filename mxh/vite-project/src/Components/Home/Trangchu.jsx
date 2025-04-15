import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import "nprogress/nprogress.css";
function Trangchu() {
  return (
    <>
      <div className="container-fluid" id="wrapper">
        <div className="row newsfeed-size">
          <div className="col-md-12 newsfeed-right-side">
            <nav
              id="navbar-main"
              className="navbar navbar-expand-lg shadow-sm sticky-top"
            >
              <div className="w-100 justify-content-md-center">
                <ul className="navbar-nav mr-5 flex-row" id="main_menu">
                  <a className="navbar-brand nav-item mr-lg-5" th:href="@{/}">
                    <img
                      th:src="@{/images/image.png}"
                      width="40"
                      height="40"
                      className="mr-3"
                      alt="Logo"
                      id="home"
                    />
                  </a>
                  <form className="w-30 mx-2 my-auto d-inline form-inline mr-5 dropdown search-form">
                    <div
                      className="input-group"
                      data-toggle="dropdown"
                      aria-haspopup="true"
                      aria-expanded="false"
                      id="searchDropdown"
                    >
                      <input
                        type="text"
                        className="form-control search-input w-75"
                        placeholder="Search for people, companies, events and more..."
                        aria-label="Search"
                        aria-describedby="search-addon"
                      />
                      <div className="input-group-append">
                        <button className="btn search-button" type="button">
                          <i className="bx bx-search"></i>
                        </button>
                      </div>
                    </div>
                    <ul
                      className="dropdown-menu notify-drop nav-drop shadow-sm"
                      aria-labelledby="searchDropdown"
                    >
                      <div className="notify-drop-title">
                        <div className="row">
                          <div className="col-md-6 col-sm-6 col-xs-6 fs-8">
                            Search Results{" "}
                            <span className="badge badge-pill badge-primary ml-2">
                              29
                            </span>
                          </div>
                        </div>
                      </div>
                      <div className="drop-content">
                        <h6 className="dropdown-header">Peoples</h6>
                        <li className="dropdown-item">
                          <div className="col-md-2 col-sm-2 col-xs-2">
                            <div className="notify-img">
                              <img src="#" alt="Search result" />
                            </div>
                          </div>
                          <div className="col-md-10 col-sm-10 col-xs-10">
                            <a href="#" className="notification-user">
                              Susan P. Jarvis
                            </a>
                            <a
                              href="#"
                              className="btn btn-quick-link join-group-btn border text-right float-right"
                            >
                              Add Friend
                            </a>
                            <p className="time">6 Mutual friends</p>
                          </div>
                        </li>
                        <h6 className="dropdown-header">Groups</h6>
                        <li className="dropdown-item">
                          <div className="col-md-2 col-sm-2 col-xs-2">
                            <div className="notify-img">
                              <img src="#" alt="Search result" />
                            </div>
                          </div>
                          <div className="col-md-10 col-sm-10 col-xs-10">
                            <a href="#" className="notification-user">
                              Tourism
                            </a>
                            <a
                              href="#"
                              className="btn btn-quick-link join-group-btn border text-right float-right"
                            >
                              Join
                            </a>
                            <p className="time">2.5k Members 35+ post a week</p>
                          </div>
                        </li>
                      </div>
                      <div className="notify-drop-footer text-center">
                        <a href="#">See More</a>
                      </div>
                    </ul>
                  </form>
                  <li className="nav-item s-nav dropdown message-drop-li">
                    <a
                      href="#"
                      className="nav-link nav-links message-drop drop-w-tooltip"
                      data-toggle="dropdown"
                      data-placement="bottom"
                      data-title="Messages"
                      role="button"
                      aria-haspopup="true"
                      aria-expanded="false"
                      id="message"
                    >
                      <img
                        th:src="@{/images/icons/navbar/message.png}"
                        className="message-dropdown"
                        alt="navbar icon"
                      />{" "}
                      <span className="badge badge-pill badge-primary">1</span>
                    </a>
                    <ul className="dropdown-menu notify-drop dropdown-menu-right nav-drop shadow-sm">
                      <div className="notify-drop-title">
                        <div className="row">
                          <div className="col-md-6 col-sm-6 col-xs-6 fs-8">
                            Messages | <a href="#">Requests</a>
                          </div>
                          <div className="col-md-6 col-sm-6 col-xs-6 text-right">
                            <a href="#" className="notify-right-icon">
                              Mark All as Read
                            </a>
                          </div>
                        </div>
                      </div>
                      <div className="drop-content">
                        <li>
                          <div className="col-md-2 col-sm-2 col-xs-2">
                            <div className="notify-img">
                              <img
                                th:src="@{/images/users/user-6.png}"
                                alt="notification user image"
                              />
                            </div>
                          </div>
                          <div className="col-md-10 col-sm-10 col-xs-10">
                            <a href="#" className="notification-user">
                              Susan P. Jarvis
                            </a>
                            <a href="#" className="notify-right-icon">
                              <i className="bx bx-radio-circle-marked"></i>
                            </a>
                            <p className="time">
                              <i className="bx bx-check"></i> This party is
                              going to have a DJ, food, and drinks.
                            </p>
                          </div>
                        </li>
                      </div>
                      <div className="notify-drop-footer text-center">
                        <a href="#">See More</a>
                      </div>
                    </ul>
                  </li>
                  <li className="nav-item s-nav dropdown friend-request">
                    <a
                      th:href="@{/listfriend}"
                      className="nav-link nav-links rm-drop-mobile drop-w-tooltip"
                      data-toggle="dropdown"
                      data-placement="bottom"
                      data-title="Friend Requests"
                      role="button"
                      aria-haspopup="true"
                      aria-expanded="false"
                      id="friend-request"
                    >
                      <span className="badge-pill badge-primary">
                        <img
                          className="friend-request-icon"
                          src="/images/icons/navbar/group.png"
                          alt="Friend Request Icon"
                        />
                        <span id="friend-request-count">0</span>
                      </span>
                    </a>
                  </li>
                  <li className="nav-item s-nav dropdown notification">
                    <a
                      href="#"
                      className="nav-link nav-links rm-drop-mobile drop-w-tooltip"
                      data-toggle="dropdown"
                      data-placement="bottom"
                      data-title="Notifications"
                      role="button"
                      aria-haspopup="true"
                      aria-expanded="false"
                      id="notification"
                    >
                      <img
                        th:src="@{/images/icons/navbar/notification.png}"
                        className="notification-bell"
                        alt="navbar icon"
                      />
                      <span
                        id="quantityNotification"
                        className="badge-pill badge-primary unread-messages"
                        // style={{ display: none }}
                      ></span>
                    </a>
                    <ul className="dropdown-menu notify-drop dropdown-menu-right nav-drop shadow-sm">
                      <div className="notify-drop-title">
                        <div className="row">
                          <div className="col-md-6 col-sm-6 col-xs-6 fs-8">
                            Notifications{" "}
                            <span
                              id="quantityNotification"
                              className="badge-pill badge-primary unread-messages"
                              style="display: none;"
                            ></span>
                          </div>
                          <div className="col-md-6 col-sm-6 col-xs-6 text-right">
                            <a href="#" className="notify-right-icon">
                              Mark All as Read
                            </a>
                          </div>
                        </div>
                      </div>
                      <div className="drop-content"> </div>
                      <div className="notify-drop-footer text-center">
                        <a href="#">See More</a>
                      </div>
                    </ul>
                  </li>
                  <li className="nav-item s-nav">
                    <a id="profileLink" className="nav-link nav-links">
                      <div className="menu-user-image">
                        <img
                          id="avartaruser"
                          className="menu-user-img ml-1"
                          alt="Menu Image"
                        />
                      </div>
                    </a>
                  </li>
                  <li className="nav-item s-nav nav-icon dropdown">
                    <a
                      href="#"
                      id="logout-link"
                      className="nav-link logout-link"
                    //   style={{ color: black }}
                    >
                      <i className="fa-solid fa-right-from-bracket"></i>
                    </a>

                    <div
                      className="dropdown-menu dropdown-menu-right settings-dropdown shadow-sm"
                      aria-labelledby="settings-dropdown"
                    >
                      <a className="dropdown-item" href="#">
                        <img
                          th:src="@{/images/icons/navbar/help.png}"
                          alt="Navbar icon"
                        />{" "}
                        Help Center
                      </a>
                      <a
                        className="dropdown-item d-flex align-items-center dark-mode"
                        href="#"
                      >
                        <img
                          th:src="@{/images/icons/navbar/moon.png}"
                          alt="Navbar icon"
                        />{" "}
                        Dark Mode
                        <button
                          type="button"
                          className="btn btn-lg btn-toggle ml-auto"
                          data-toggle="button"
                          aria-pressed="false"
                        >
                          <div className="handle"></div>
                        </button>
                      </a>
                      <a className="dropdown-item" href="#">
                        <img
                          th:src="@{/images/icons/navbar/gear-1.png}"
                          alt="Navbar icon"
                        />{" "}
                        Settings
                      </a>
                      <a className="dropdown-item logout-btn" href="#">
                        <img
                          th:src="@{/images/icons/navbar/logout.png}"
                          alt="Navbar icon"
                        />{" "}
                        Log Out
                      </a>
                    </div>
                  </li>
                </ul>
              </div>
            </nav>
            <div className="row newsfeed-right-side-content mt-3 justify-content-center">
              <div
                className="col-md-6 second-section col-6"
                id="page-content-wrapper"
              >
                <ul className="list-unstyled" style={{ marginbottom: 0 }}>
                  <li className="media post-form w-shadow">
                    <div className="media-body">
                      <div className="central-meta">
                        <div className="new-postbox">
                          <figure>
                            <img src="#" alt="" />
                          </figure>
                          <div className="newpst-input">
                            <form
                              id="uploadPostUser"
                              enctype="multipart/form-data"
                            >
                              <textarea
                                rows="2"
                                placeholder="write something"
                                id="contentPost"
                                name="content"
                              ></textarea>
                              <div className="attachments">
                                <ul>
                                  <li>
                                    <i className="fa fa-image"></i>
                                    <label className="fileContainer">
                                      <input
                                        name="image"
                                        id="imagePost"
                                        type="file"
                                        placeholder="Choose Image"
                                      />
                                    </label>
                                  </li>
                                  <li>
                                    <button type="submit">Post</button>
                                  </li>
                                </ul>
                                <div id="image-preview-container">
                                  <img
                                    id="imagePreview"
                                    src="images/icons/theme/post-image.png"
                                    alt="Image Preview"
                                    style={{
                                      maxWidth: 300,
                                      maxHeight: 300,
                                      display: "none",
                                    }}
                                  />
                                  <span
                                    id="remove-image-span"
                                    style={{
                                      cursor: "pointer",
                                      display: "none",
                                    }}
                                  >
                                    &times;
                                  </span>
                                </div>
                              </div>
                            </form>
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
                <div
                  className="posts-section mt-5 mb-5"
                  id="displaycontent"
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div
        className="border-top pt-3 hide-comments"
        id="commentslist"
        data-id=""
        style={{ display: none }}
      ></div>
    </>
  );
}

export default Trangchu;
