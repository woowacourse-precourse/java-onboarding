package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Decryption decryption = new Decryption(cryptogram);
        decryption.replaceChar();
        answer = decryption.getAnswer();
        return answer;
    }
}

class Decryption {
    private String cryptogram;
    private String answer;

    Decryption(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    String getAnswer() {
        return answer;
    }

    // 연속하는 중복 문자를 삭제하는 메서드 replaceChar
    void replaceChar(){
        String tmp;
        answer = cryptogram.replaceAll("([a-z])\\1", "");
        while(true) {
            tmp = answer;
            answer = answer.replaceAll("([a-z])\\1", "");

            // 이전과 결과가 같을경우 반복문 탈출
            if(answer.equals(tmp)) {
                break;
            }
        }
    }




}
