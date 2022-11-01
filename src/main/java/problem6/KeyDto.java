package problem6;

public class KeyDto {
    private String nickname;
    private int start;

    public KeyDto(String nickname, int start) {
        this.nickname = nickname;
        this.start = start;
    }

    public String getNickname() {
        return nickname;
    }

    public int getStart() {
        return start;
    }

}
