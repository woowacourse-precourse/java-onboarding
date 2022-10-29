package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean inputExceptionChecker(int number){
        // 1. Input이 1 이상 10000이하가 아닌 경우
        if(!isBetween(1,10000, number))
            return true;
        return false;
    }

    /**
     *
     * Target이 min 이상 max 이하에 있는 값인지 검사
     * @param min 검사하고 싶은 범위 중 작은 값
     * @param max 검사하고 싶은 범위 중 큰 값
     * @param target 검사하고 싶은 값
     * @return 사이에 존재한다면 true, 아니라면 false를 반환
     */
    private static boolean isBetween(int min, int max, int target){
        if(min<=target && target<=max)
            return true;
        else
            return false;
    }
}
