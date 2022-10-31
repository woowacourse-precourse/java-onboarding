package onboarding;

import java.util.regex.Pattern;

public class User {
    private int index;

    private String email;

    private String nickName;

    public User(String email,String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public void validEmail(){
        String pattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com$";
        if(!Pattern.matches(pattern,email)) throw new IllegalArgumentException("잘못된 이메일입니다.");
    }

    public void validNickName(){
        String pattern="^[가-힣ㄱ-ㅎㅏ-ㅣ]*$";
        if(!Pattern.matches(pattern,nickName)) throw new IllegalArgumentException("잘못된 닉네임입니다.");
    }
}
