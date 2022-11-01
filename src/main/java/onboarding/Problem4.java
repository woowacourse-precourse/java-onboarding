package onboarding;

public class Problem4 {

    // 대문자일 경우
    public static Integer changeUpper(Character word){
        return 'Z' - word + 'A';
    }
    // 소문자일 경우
    public static Integer changeLower(Character word){
        return 'z' - word + 'a';
    }
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++){

            // 공백일 경우
            if(word.charAt(i) == ' '){
                answer += ' ';
            }

            // 공백 아닌 경우(알파벳인 경우)
            else if(word.charAt(i) != ' '){

                // 아스키 값 저장
                int temp = 0;

                // 대문자일 경우
                if(word.charAt(i) <= 'Z'){
                    temp = changeUpper(word.charAt(i));
                }

                // 소문자일 경우
                else if(word.charAt(i) <= 'z'){
                    temp = changeLower(word.charAt(i));
                }

                answer += (char)temp;
            }
        }

        // 정답
        return answer;
    }
}