package onboarding;

public class Problem3 {
    public static int solution(int number) {

    }

    public static int clapCount(String number){
        int sum=0;
        for(int i=0;i<number.length();i++){
            sum+=isClap(number.charAt(i));
        }
        return sum;
    }

}
