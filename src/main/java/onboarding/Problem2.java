package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);

        boolean flag = true;
        while (flag) {
            flag = false; //삭제된 문자가 있었다면 true;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {// 지금 문자와 다음 문자가 같은 경우
                    flag = true;
                    sb.delete(i, i + 2); //지금 문자를 삭제한다.
                }
                //끝까지 순회한다.
            }
        } //문자열을 순회한 뒤 중복문자가 있었다면 다시 반복한다.

        answer = sb.toString();
        return answer;
    }
}
