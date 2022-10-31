package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for(int i = 1 ; i <= number; i++){
            int num = i;
            while(num > 0 ){
                int remain = num % 10;
                if(remain == 3 || remain == 6 || remain == 9){
                    clap += 1;
                }
                num /= 10;
            }
        }
        return clap;
    }
    public static void main(String args[]){
        int number = 33;
        System.out.println(solution(number));
    }
}
