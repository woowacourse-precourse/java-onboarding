package onboarding;

public class Problem4 {


    // 소문자, 대문자 각각을 변환한다.
    private static char transform(char ch){
        if ('a' <= ch && ch <= 'z') return (char) ('a' + (25 - (ch - 'a')));
        else if ('A' <= ch && ch <= 'Z') return (char) ('A' + (25 - (ch - 'A')));
        return '0';
    }


    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++){
            char transformedChar = transform(word.charAt(i));

            // 소문자, 대문자라면 변환
            if (transformedChar != '0'){
                answer += transformedChar;
            }
            // 소문자, 대문자가 아니라면 변환하지 않는다.
            else
                answer += word.charAt(i);
        }

        return answer;
    }
}
