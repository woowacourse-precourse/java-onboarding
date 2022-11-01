package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int[] claps = new int[number + 1];
        for(int i=1;i<number+1;i++){
            claps[i]= claps[i-1]+clapsInNumber(i);
        }
        int answer = claps[number];
        return answer;
    }

    public static int clapsInNumber(int number) {
        int count = 0;
        while (number > 0) {
            int lastDigit = number%10;
            count+=isClapNumber(lastDigit);
            number /= 10;
        }
        return count;
    }

    public static int isClapNumber(int n) {
        if(n==3||n==6||n==9){
            return 1;
        }
        return 0;
    }
}
