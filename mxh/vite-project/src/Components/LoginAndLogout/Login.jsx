import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'nprogress/nprogress.css';
import './Login.css'
import { SignIn } from "../ApiFunctions";
import { useState } from "react";
import { useNavigate } from "react-router-dom"; // Thêm useNavigate để chuyển trang

function Login() {
    const navigate = useNavigate(); // Khai báo navigate để chuyển trang
  const [taikhoan, setTaikhoan] = useState("");
  const [matkhau, setMatkhau] = useState(""); 

  const handleLogin = async (e) => {
    e.preventDefault();
  
    const success = await SignIn(taikhoan, matkhau);
    if (success) {
      navigate("/tc");
    }
  };
  
  
      

    return (  
        <div className="container">
            <div className="row">
                <div className="offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3">
                    <div className="panel border bg-white">
                        <div className="panel-heading">
                            <h3 className="pt-3 font-weight-bold">Login</h3>
                        </div>
                        <div className="panel-body p-3">
                            <form onSubmit={handleLogin} method="POST" id="formLogin">
                                <div className="form-group py-2">
                                    <div className="input-field">
                                        <span className="far fa-user p-2"></span>
                                        <input name="username" id="inputEmail4" type="text" placeholder="Username or Email" 
                                        value={taikhoan}
                                        onChange={(e) => setTaikhoan(e.target.value)}
                                        />
                                    </div>
                                    <div className="error errorEmail" style={{ color: "red", display: "none" }}></div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field">
                                        <span className="fas fa-lock px-2"></span>
                                        <input name="password" id="inputPassword4" type="password" placeholder="Enter your Password" 
                                                        value={matkhau} onChange={(e) => setMatkhau(e.target.value)}

                                        />
                                    </div>
                                    <div className="error errorPassword" style={{ color: "red" }}></div>
                                </div>
                                <div className="form-inline">
                                    <a href="#" id="forgot" className="font-weight-bold">Forgot password?</a>
                                </div>
                                <button type="submit" className="btn btn-primary btn-block mt-3" id="loginBtn">Login</button>
                                <div className="text-center pt-4 text-muted">
                                    Don't have an account? <a href="/register" id="registerLink">Sign up</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
