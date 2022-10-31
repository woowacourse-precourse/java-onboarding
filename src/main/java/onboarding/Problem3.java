package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for(int i = number; i>2; i--){
            answer += calculateClapNumber(i);
        }
        return answer;
    }
    static boolean checkToClap(char singlenumber){
        return singlenumber=='3' || singlenumber=='6' || singlenumber =='9';
    }

    static int calculateClapNumber(int number){
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
