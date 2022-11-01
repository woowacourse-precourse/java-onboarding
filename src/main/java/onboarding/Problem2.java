package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        // 3개 이상  연속한 것 지우기

        String answer = "answer";

        // 연속 중복 문자를 삭제하기

        // 스택을 이용해서 가장 위의 값과 삽입하려는 값이 같으면 삭제
        StringBuffer sb = new StringBuffer();

        sb.append(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            char thisChar = cryptogram.charAt(i);
            if (sb.charAt(sb.length() - 1) == thisChar) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(thisChar);
            }
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));


    }
}
