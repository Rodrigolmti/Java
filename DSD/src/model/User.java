package model;

/**
 * Model to separted user data, now only have nickname
 * @author Amand Nunes / Rodrigo Lopes
 */
public class User {
    
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
