package onboarding;

public class Problem3 {

    public static int countClap(int a){

        int checkClap = 0 ;
        while(a > 0){
            int num = a % 10;
            if(num ==3 || num == 6 || num == 9){
                checkClap++;
            }
            a = a/10;
        }
        return checkClap;
    }
    public static int solution(int number) {
        int answer = 0;

        for(int i =1; i<=number; i++){
            answer += countClap(i);
        }
        return answer;
    }
}
