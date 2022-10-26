package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getGameResult(pobi, crong);
        return answer;
    }

    private static int getGameResult(List<Integer> userA, List<Integer> userB){
        int userAPoint = getMaxPoint(userA);
        int userBPoint = getMaxPoint(userB);


        if(userAPoint == -1 || userBPoint == -1){
            return -1;
        } else if (userAPoint>userBPoint) {
            return 1;
        } else if (userAPoint<userBPoint) {
            return 2;
        } else if (userAPoint == userBPoint) {
            return 0;
        }
        return -1;
    }

}