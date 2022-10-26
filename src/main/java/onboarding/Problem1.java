package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int left = 0;
        int right = 1;

        int answer = Integer.MAX_VALUE;

        //pobi findMaxNum
        findMaxNum(pobi.get(left), pobi.get(right));
        //crng findMaxNum
        findMaxNum(crong.get(left), crong.get(left));

        return answer;
    }

    //자리수 구하기
    public static int[] digit(int num)
    {
        int []value = null;
        int i = 0;

        while(num > 0)
        {
            value[i] = num % 10;
            num /= 10;
        }
        return value;
    }

}
