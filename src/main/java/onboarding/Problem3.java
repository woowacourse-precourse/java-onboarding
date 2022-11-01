package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(input_exception(number)) return -1;

        return getTotalClap(number);
    }

    private static int getTotalClap(int num){
        int result=0;
        for(int i=1;i<=num;i++){
            result+=getClap(i);
        }
        return result;
    }

    private static int getClap(int num) {
        int result=0;
        while(num!=0){
            int term=num%10;
            if(term==3||term==6||term==9) result++;
            num/=10;
        }
        return result;
    }

    private static boolean input_exception(int input){
        //true is 'exception excution'
        if(input<1||input>1000) return true;
        return false;
    }
}
