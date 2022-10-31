package onboarding;

public class Problem3 {
    static int Return_Count(int num){
        int count = 0;
        int one;
        while(num > 0){
            one = num%10;
            if(one == 3 || one == 6 || one == 9){
                count++;
            }
            num = num/10;
        }
        return count;
    }
    static int Check_num(int num){
        int count = 0;
        if(num < 0 || num > 10000){
            return -1;
        }

        for(int i = 1 ; i <= num ; i++){
            count += Return_Count(i);
        }
        return count;
    }
    public static int solution(int number) {
        int answer = Check_num(number);
        return answer;
    }
}
