package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            if(i<10) answer += check_num(i);
            else{
                answer += separation_num(i);
            }
        }

        return answer;
    }

    static int check_num(int num) {

        if ((num == 3) || (num == 6) || (num == 9)) return 1;
        else return 0;

    }

    static int separation_num(int num){
        int count = 0;

        while(num>0){
            count += check_num(num%10);
            num /= 10;
        }

        return count;
    }

}
