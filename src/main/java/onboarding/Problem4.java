package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(); //문자열 저장을 위한 스트링 빌더
        for (int i = 0; i < word.length(); i++){ // 각 문자열 확인
           answer.append(reverseAlpa(word.charAt(i))); // 뒤집어서 추가
        }
        return answer.toString();
    }
    public static char reverseAlpa(char alpha){ // 각 문자열을 뒤집어서 추가 하는 함수
        if (alpha >= 'a' && alpha <= 'z') return (char) ('z' - alpha + 'a'); // 소문자라면 소문자로
        if (alpha >= 'A' && alpha <= 'Z') return (char) ('Z' - alpha + 'A'); // 대문자라면 대문자로
        return alpha;
    }
}
