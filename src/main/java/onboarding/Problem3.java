package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = checkNumber(number);

        return answer;
    }
    public static int checkNumber(int number){
        int count = 0;
        for(int i=1;i<=number;i++){
            int current = i;
            count = getCount(count, current);
        }
        return count;
    }

    private static int getCount(int count, int current) {
        while (current != 0){
            count = increseCounts(count, current);
            current /=10;
        }
        return count;
    }

    private static int increseCounts(int count, int current) {
        if((current %10)==3||(current %10)==6||(current %10)==9){
            count++;
        }
        return count;
    }
    
}
