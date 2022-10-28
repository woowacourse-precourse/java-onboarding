package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            System.out.println(pobi.get(1) - pobi.get(0));
            System.out.println(crong.get(1) - crong.get(0));
            return -1;
        }
        int sumLeftPobi = 0;
        int sumRightPobi = 0;
        int sumLeftCrong = 0;
        int sumRightCrong = 0;

        System.out.println(sumLeftPobi +","+ sumRightPobi +","+ sumLeftCrong +","+ sumRightCrong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}w