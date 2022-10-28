package onboarding;

public class Problem4 {
    /*
    * 청개구리 사전 클래스인 TreeFrog는 청개구리 사전에 따라 알파벳을 반대로 변환해주는 convert 메서드를 포함한다.
    * convert는 전달받은 word를 한글자씩 아스키코드로 소문자, 대문자, 알파벳 외의 경우로 나누고 계산을 통해 청개구리 사전과 같이 변환해줌.
    * StringBuilder 클래스를 활용하여 변환한 문자들을 이어 붙여 String으로 만들어줌.
    * */

    public static String solution(String word) {
        String answer = "";
        TreeFrog tf = new TreeFrog(word);
        tf.convert();
        answer = tf.getAnswer();
        return answer;
    }
}

class TreeFrog {
    String word;
    String answer;
    StringBuilder sb = new StringBuilder();

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
