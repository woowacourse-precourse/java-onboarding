package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int num = 1 ; num <= number ; num += 1) {
            answer += numOfClap(num);
        }
        return answer;
    }


    private static int numOfClap(int num) {
        int clap = 0;
        while (num != 0) {
            int remain = num%10;
            if (is369(remain)) {
                clap += 1;
            }
            num = num/10;
        }
        return clap;
    }

    private static boolean is369(int remain) {
        if (remain != 0 && remain%3 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
