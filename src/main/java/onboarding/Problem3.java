package onboarding;

public class Problem3 {
    // func : check this number contains how many 369s, return is number of 369s
    private static int checkNum(int n) {
        int clap = 0;
        int num = n;
        // get length of num
        int length = (int)Math.log10(num) + 1;
        for (int i=length-1;i>=0;i--){
            int tmp = (int)(num / Math.pow(10,i));
            // if tmp is 3 6 9, add clap
            if((tmp != 0) && (tmp % 3 == 0)) clap += 1;
            // refresh num
            num = (int)(num % Math.pow(10,i));
        }
        return clap;
    }

    // func : count 1 to number, return total clap count
    private static int totalClap(int n) {
        int total = 0;
        for (int i=1;i<=n;i++)
            total += checkNum(i);

        return total;
    }
    public static int solution(int number) {
        int answer = totalClap(number);
        return answer;
    }
}
