package onboarding;
//## PROBLEM3 기능 구현 정리
//        1. 예외처리 :
//        초반 예외 :word 길이 1이상 10000 이하 검증
//        2. 1 ~ number까지 반복문을 돌리며 3,6,9 포함한 수 갯수 체크:
//        - 숫자를 문자열로 변환
//        - 문자열에서 contains 메서드를 통해 3,6,9 체크
//        있다면 cnt+1
//        없다면 continue
//        3. 결과 리턴
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(checkLengthException(number)){
            return 0;
        }
        return answer;
    }

    private static boolean checkLengthException(int number){
        if(number >= 1 && number <= 10000){
            return false;
        }
        return true;
    }

    private static boolean checkNumberHas369(int num){
        String strNum = String.valueOf(num);
        if(strNum.contains("3") || strNum.contains("6") || strNum.contains("9")){
            return true;
        }
        return false;
    }
}
