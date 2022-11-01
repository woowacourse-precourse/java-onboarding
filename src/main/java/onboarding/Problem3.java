package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = getCountClap(number);
        return answer;
    }

    static int countClap(int number){
        int count=0;
        while(number!=0){
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9)
                count++;
            number /= 10;
        }
        return count;
    }

    static int getCountClap(int number){
        int result = 0;
        for(int i=1;i<=number;i++){
            result+=countClap(i);
        }
        return result;
    }
}
