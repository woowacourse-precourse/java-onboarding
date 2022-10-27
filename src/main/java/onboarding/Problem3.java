package onboarding;

public class Problem3 {
    // 처음 아이디어
    // 문자열로 숫자들을 계속 추가하는 함수 생성
    // 문자열에서 3,6,9가 들어간 개수 추출하기

    public static String numberToString(int number) {
        String numbers = "";
        for(int i=0; i<number; i++) {
            numbers += Integer.toString(i);
        }
        return numbers;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
