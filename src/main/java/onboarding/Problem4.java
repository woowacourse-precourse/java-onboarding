package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] code = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P',
                'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        for(int i=0; i < word.length(); i++){
            char tmp = word.charAt(i);

            // 대문자인 경우
            if( (65 <= tmp) && (tmp <= 90)){
                answer += code[tmp-65];
            } // 소문자인 경우
            else if ((97 <= tmp) && (tmp <= 122)) {
                answer += Character.toString(code[tmp-97]).toLowerCase();
            } // 그 외의 경우
            else {
                answer += tmp;
            }
        }

        return answer;
    }
}
