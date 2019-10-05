package user_lambda_stream_optional;
// klasa modelu - determinująca strukturę danych -> tabelka bazodanowa

import java.time.LocalDateTime;

public class User {
    private static Integer global_id = 1;
    private Integer user_id;
    private String login;
    private String password;
    private Role role = Role.USER;
    private Boolean status = true;
    private LocalDateTime registerDate = LocalDateTime.now();
    private Integer loginCounter = 3;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        // autoinkrementacja id
        this.user_id = global_id;
        global_id ++;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", registerDate=" + registerDate +
                '}';
    }

    public Integer getLoginCounter() {
        return loginCounter;
    }

    public void setLoginCounter(Integer loginCounter) {
        this.loginCounter = loginCounter;
    }

    public Integer getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(Integer global_id) {
        this.global_id = global_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
