package onboarding;

public class Problem3 {
    /**
     [기능목록]
     1. 숫자를 문자 배열로 만들기
     2. 문자 배열에서 3, 6, 9인 값 찾아서 1 더하기
     */
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            // 숫자를 문자 배열로 만들기
            for(char c : String.valueOf(i).toCharArray()) {
                // 문자 배열에서 3, 6, 9인 값 찾아서 1 더해주기
                if(c == '3' || c == '6' || c == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
