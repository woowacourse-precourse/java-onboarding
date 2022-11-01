package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(input_exception(number)) return -1;

        return getTotalClap(number);
    }

    private static int getTotalClap(int num){
        int result=0;
        for(int i=0;i<num;i++){
            result+=getClap(i);
        }
        return result;
    }

    private static int getClap(int num) {
        
    }

    private static boolean input_exception(int input){
        //true is 'exception excution'
        if(input<1||input>1000) return true;
        return false;
    }
}
