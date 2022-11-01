package onboarding;


public class Problem3 {
    static int result;
    public static int solution(int number) {
        result =0;
        for(int i=1; i<=number; i++){
            calculration(i);
        }
        return result;
    }


    private static void calculration(int i) {
        String a = String.valueOf(i);

        for(int s=0; s<a.length(); s++){
            calculration2(a.charAt(s));
        }
    }

    private static int calculration2(char charAt) {
        if(charAt == '3' || charAt == '6' || charAt == '9'){
            result++;
        }
        return result;
    }
}