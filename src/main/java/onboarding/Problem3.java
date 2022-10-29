package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = oneToNumberCount(number);
        return answer;
    }

    private static int oneToNumberCount(int number) {
        int allCount = 0;
        for(int index = 1; index<= number; index++){
            allCount += count369(index);
        }
        return allCount;
    }

    public static int count369(int number){
        int count = 0;
        while(number>0){
            int tmp = number%10;
            if(tmp == 3 || tmp ==6 || tmp==9)count++;
            number/=10;
        }
        return count;
    }
}
