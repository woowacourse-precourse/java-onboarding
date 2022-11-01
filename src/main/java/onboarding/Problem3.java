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

        // 손뼉치는 횟수 구하기
        for (int i = 1; i <= number; i++){
            String temp_number = Integer.toString(i); // 해당 차례의 숫자에서 3,6,9 개수를 세기 위해 String 타입으로 변환
            result += countParticularchar(temp_number,'3'); // 해당 숫자에서 3의 개수 구하기
            result += countParticularchar(temp_number,'6'); // 해당 숫자에서 6의 개수 구하기
            result += countParticularchar(temp_number,'9'); // 해당 숫자에서 9의 개수 구하기
        }

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
