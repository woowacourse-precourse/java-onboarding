package onboarding;

import java.util.List;

class Problem1 {
    public static boolean checkValid(int left, int right){
        if (left < 1 || left > 400 || right < 1 || right > 400)
            return false;
        if (left % 2 == 0 || right % 2 != 0)
            return false;
        if (right - left != 1)
            return false;
        return true;
    }

    public static int getMaxNumOfSumOrMulti(int num){
        int sum = 0;
        int multi = 1;

        while (num != 0) {
            sum += num % 10;
            multi *= num % 10;
            num /= 10;
        }

        return Math.max(sum, multi);
    }

    public static int getMaxNumOfLeftOrRight(List<Integer> nums) {
        int left = nums.get(0);
        int right = nums.get(1);

        if (!checkValid(left, right))
            return -1;

        return Math.max(Problem1.getMaxNumOfSumOrMulti(left), Problem1.getMaxNumOfSumOrMulti(right));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            int pobiNum = Problem1.getMaxNumOfLeftOrRight(pobi);
            int crongNum = Problem1.getMaxNumOfLeftOrRight(crong);
            if (pobiNum == -1 || crongNum == -1)
                return -1;

            if (pobiNum > crongNum)
                answer = 1;
            else if (pobiNum < crongNum)
                answer = 2;
            else
                answer = 0;
        }catch (Exception e){
            return -1;
        }

        return answer;
    }
}