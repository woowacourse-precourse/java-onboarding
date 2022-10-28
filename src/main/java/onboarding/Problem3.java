package onboarding;

public class Problem3 {
    static int answer;

    public static int solution(int number) {
        answer = 0;
        return answer;
    }
    public static boolean checkToClap(char singlenumber){
        return singlenumber=='3' || singlenumber=='6' || singlenumber =='9';
    }

    public static int calculateClapNumber(int number){
        int clapnumber = 0;
        String stringnumber = Integer.toString(number);

        for(int i=0; i<stringnumber.length();i++){
            if(checkToClap(stringnumber.charAt(i))){
                clapnumber += 1;
            }
        }
        return clapnumber;
    }
}
