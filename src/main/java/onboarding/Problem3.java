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

    private static int isClap(char c){
        if(c=='3'||c=='6'||c=='9'){
            return 1;
        }
        return 0;
    }
}
