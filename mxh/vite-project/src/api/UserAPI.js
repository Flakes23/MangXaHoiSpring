import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080"
});

export async function SignIn(taikhoan, matkhau) {
  try {
    const response = await api.post("/api/login", {  
      email: taikhoan, 
      password: matkhau
    });
    console.log(response.data); // In ra dữ liệu trả về từ server
    if (response.status === 200) {
      return true;
    }
  } catch (error) {
    console.error("Login failed:", error);
    throw error;
  }
}
export async function register(lastName, firstName, password, email) {
  const url = "http://localhost:8080/api/register";  // Đảm bảo URL đúng với đường dẫn của bạn
  
  try {
    const response = await axios.post(url, null, {
      params: {
        lastName: lastName,
        firstName: firstName,
        password: password,
        email: email,
      },
    });
    if (response.status === 200) {
      return true;
    }
    else {
      return false;
    }
  } catch (error) {
    console.error("Error during registration:", error.response.data);
  }
}