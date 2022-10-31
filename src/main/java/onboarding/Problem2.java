package onboarding;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
    }
    public static String solution(String cryptogram) {
       if (cryptogram.length() < 2) return cryptogram; // 길이가 2 미만이면 중복이 존재하지 않는다.
       StringBuilder answer = new StringBuilder(); // 정답을 저장할 스트링빌더 선언
       for(int i = 1; i < cryptogram.length(); i++){ // 모든 문자를 비교를 위한 반복문
           if (cryptogram.charAt(i - 1) != cryptogram.charAt(i)){ // 다음 문자와 현 문자과 같지 않다면
               answer.append(cryptogram.charAt(i-1)); // 스트링 빌더에 추가
           }
           else while (i < cryptogram.length() && cryptogram.charAt(i - 1) == cryptogram.charAt(i)){ // 같다면 건너뛰기, 길이를 넘었다면
               i++; // 건너뛰기
           }
       }
        if (cryptogram.charAt(cryptogram.length() - 1) != cryptogram.charAt(cryptogram.length() - 2)) // 마지막 문자가 중복이 아니라면 리스트에 추가.
            answer.append(cryptogram.charAt(cryptogram.length() - 1));
        if (answer.length() == cryptogram.length()) return answer.toString(); // 길이가 같다면 중복이 없다.
        return solution(answer.toString()); // 중복을 체크한다.
    }
}
