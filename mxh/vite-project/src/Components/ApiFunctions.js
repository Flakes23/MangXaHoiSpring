import axios from "axios"

export const api=axios.create({
    baseURL:"http://localhost:8080"
})

export async function SignIn(taikhoan, matkhau) {
    const formData = new FormData();
    formData.append("taikhoan", taikhoan);
    formData.append("matkhau", matkhau);
    try {
        const response = await api.post("/api/usercurrent", formData);
        if (response.status === 200) {
            alert("Đăng nhập thành công!");
            return true;
        }
    } catch (error) {
        alert("Sai tài khoản hoặc mật khẩu!");
        return false;
    }
}
