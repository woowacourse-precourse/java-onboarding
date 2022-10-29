package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        // 3개 이상  연속한 것 지우기

        String answer = "answer";

        // 연속 중복 문자를 삭제하기

        // 스택을 이용해서 가장 위의 값과 삽입하려는 값이 같으면 삭제
        StringBuffer sb = new StringBuffer();

        // 연속해서 지우는 중인가?
        boolean isChainDelete = false;
        char checkAlphabet = cryptogram.charAt(0);

        for (int i = 1; i < cryptogram.length(); i++) {
            // 만약 가장 뒤의 값과 삽입하려는 값이 같으면 -> 삭제
            if (cryptogram.charAt(i) == checkAlphabet) {
                isChainDelete = true;
            }

            // 아니라면 삽입
            else {
                if (!isChainDelete) {
                    sb.append(checkAlphabet);
                }
                isChainDelete = false;
                checkAlphabet = cryptogram.charAt(i);
            }
        }
        if (!isChainDelete) {
            sb.append(checkAlphabet);
        }

        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("bcdaaaa"));
    }
}
