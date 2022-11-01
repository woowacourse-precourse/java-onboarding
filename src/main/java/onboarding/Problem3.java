package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalClap = 0;

        for(int i = 1; i <= number; i++){
            totalClap += doClap(i);
        }
        return totalClap;
    }

    private static int doClap(int number) {
        int clapCnt = 0;
        for(String digit : String.valueOf(number).split("")){
            if(digit.equals("3") || digit.equals("6") || digit.equals("9")){
                clapCnt++;
            }
        }

        return clapCnt;
    }
}
