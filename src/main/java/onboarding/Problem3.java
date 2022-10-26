package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    public static boolean validationCheck(int number) {
        if (number < 1 || number > 10000) {
            return false;
        }
        return true;
    }

}


/*
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 1 이상 10000 이하의 자연수인지 체크
2. 주어진 숫자가 3, 6, 9 키워드를 몇개 포함하고 있는지 체크하는 기능
3. 총 3, 6, 9 키워드가 몇개인지 계산하는 기능
*/