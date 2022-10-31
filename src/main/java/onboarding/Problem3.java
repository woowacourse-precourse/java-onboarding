package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 입력으로 받은 숫자를 문자열로 바꾸어 각 자릿 수에 3, 6, 9이 들어있을 때마다 카운팅한다.
        for(int i = 1; i <= number; i++){
            String str = String.valueOf(i);

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') answer++;
            }
        }

        return answer;
    }
}
