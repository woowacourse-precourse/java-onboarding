package onboarding;

public class Problem3 {
    // 기능 구현 목록
    // 1. 예외처리
    // 2. 문자열에서 특정문자의 개수를 구하는 메소드 정의하여 손뼉치는 횟수 구하는 기능 구현
    public static int solution(int number) {

        // 예외처리
        // 1. number는 1 이상 10,000이하인 자연수가 아니라면
        if (!(1 <= number) && (10000 >= number)){
            return -1;
        }

        // 결과를 저장할 변수 선언 및 초기화
        int result = 0;



        // 결과 리턴
        int answer = result;
        return answer;
    }

    // 문자열에서 특정문자의 개수를 구하는 메소드 정의
    private static int countParticularchar(String s, char c) {
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                count += 1;
            }
        }

        return count;
    }

}
