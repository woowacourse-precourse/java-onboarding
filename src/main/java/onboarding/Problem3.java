package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i =1;i<=number;i++){
            answer+=check(i);
        }



        return answer;
    }
    public static int check(int a){
        int sum=0;
        while (a != 0) {
            if((a % 10==3)||(a % 10==6)||(a % 10==9)){
                sum++;
            }
            a/= 10;
        }

        return sum;
    }
}
