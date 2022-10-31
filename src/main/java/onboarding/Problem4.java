package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String upper = "";
        String lower = "";
        for(int i=65; i<91; i++) // 알파벳 소문자, 대문자 문자열 생성
        {
            upper += (char)i;
            lower += (char)(i+32);
        }
        for(int j=0; j<word.length(); j++)
        {
            if (word.charAt(j) == ' ') answer += " "; // 띄어쓰기일 경우
            else if (Character.isUpperCase(word.charAt(j))) // 대문자일 경우
                answer += upper.charAt(upper.length()-1-(upper.indexOf(word.charAt(j))));
            else if (Character.isLowerCase(word.charAt(j))) // 소문자일 경우
                answer += lower.charAt(lower.length()-1-(lower.indexOf(word.charAt(j))));
        }
        return answer;
    }
}
