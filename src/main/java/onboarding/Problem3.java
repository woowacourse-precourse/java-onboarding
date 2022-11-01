package onboarding;

public class Problem3 {
    public static int getNumCount369(int number){
        int count = 0;
        while(number > 0){
            if(number % 10 == 3 || number % 10 == 6 || number % 10 == 9){
                count++;
            }
            number = number / 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i = 1;i<=number;i++){
            answer = answer + getNumCount369(i);
        }
        return answer;
    }
}
