package onboarding.problem3;

public class Calculator {
    public int func(int num){
        int result = 0;
        String str = Integer.toString(num);
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if((c == '3') || (c == '6') || (c == '9')){
                result += 1;
            }
        }
        return result;
    }
}
