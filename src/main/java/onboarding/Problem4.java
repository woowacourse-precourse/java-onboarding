package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        TreeFrog tf = new TreeFrog(word);
        tf.convert();
        answer = tf.getAnswer();
        return answer;
    }
}

class TreeFrog {
    private String word;
    private String answer;
    private StringBuilder sb = new StringBuilder();

    TreeFrog(String word) {
        this.word = word;
    }

    void setWord(String word) {
        this.word = word;
    }

    String getAnswer() {
        return answer;
    }
    void convert() {
        char appendChar;
        for(char c:word.toCharArray()) {
            if (c >= 65 && c <= 90) {   // 소문자인 경우
                appendChar = (char) (90 - c + 65);
            } else if (c >= 97 && c < 122) {    // 대문자인 경우
                appendChar = (char) (122 - c + 97);
            } else {    // 알파벳 외의 경우
                appendChar = c;
            }
            sb.append(appendChar);
        }
        answer = sb.toString();
    }
}
