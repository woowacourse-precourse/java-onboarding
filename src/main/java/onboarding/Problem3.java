package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalClap = 0;
        for (int i = 1; i <= number; i++) {
            totalClap += countClap(i);
        }
        return totalClap;
    }

    private static int countClap(int number) {
        int clap = 0;
        String numberString = String.valueOf(number);

        for(int i=0; i<numberString.length(); i++){
            if(numberString.charAt(i) == '3' || numberString.charAt(i) == '6' || numberString.charAt(i) == '9'){
                clap++;
            }
        }
        return clap;
    }



}
