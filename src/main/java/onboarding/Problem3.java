package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(number <1 || number >10000) return -1;
        if(number<3) return 0;

        int answer = 0;

        for(int i=3; i<=number; i++){
            answer += factorsOfThree(i);
        }

        return answer;
    }

    public static int factorsOfThree(int number){
        int count = 0;
        while(number>=1){
            int onesDigit = number % 10;
            if(onesDigit%3==0 && onesDigit!=0) count++;
            number /= 10;
        }
        return count;
    }

}
