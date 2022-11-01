package onboarding;

public class Problem3 {
    public static final int[] clapPattern = new int[]{3, 6, 9};

    private static boolean existClapPattern(int number){
        for (int pattern : clapPattern){
            if (pattern == number)
                return true;
        }
        return false;
    }

    private static int countClaps(int number){
        int count = 0;
        while (number != 0){
            int remainder = number % 10;
            number /= 10;
            if (existClapPattern(remainder))
                count++;
        }
        return count;
    }

    private static int sumOfClapsFromTo(int start, int end){
        int sum = 0;
        for (int check = start; check <= end; check++){
            sum += countClaps(check);
        }
        return sum;
    }

    public static int solution(int number) {
        return sumOfClapsFromTo(1, number);
    }
}
