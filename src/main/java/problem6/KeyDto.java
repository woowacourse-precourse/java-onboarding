package problem6;

public class KeyDto {
    private String nickname;
    private int start;
    private int end;

    public KeyDto(String nickname, int start, int end) {
        this.nickname = nickname;
        this.start = start;
        this.end = end;
    }

    public String getNickname() {
        return nickname;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
