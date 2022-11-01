package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return 0;
    }

    private static int needClapCount(int number){
        int result = 0;
        String numberStr = String.valueOf(number);

        for(int i=0; i<numberStr.length(); i++){
            String nowStr = numberStr.substring(i, i+1);
            if(nowStr.equals("3") || nowStr.equals("6") || nowStr.equals("9"))
                result++;
        }

        return result;
    }

}
