package onboarding;

import onboarding.newExceptions.InvalidRestrictionException;

public class Problem3 {
    public static int solution(int number) {
        Problem3 restrictions = new Problem3();
        if(restrictions.isViolatedRestrictions(number)){
            throw new InvalidRestrictionException("숫자가 1 이상 10,000 이하인 자연수가 아닙니다.");
        }

        int count = 0;
        for(int i = 1; i <= number; i++){
            count += clap(i);
        }

        return count;
    }
    static int clap(int number){
        int count = 0;
        String[] individualNumber = Integer.toString(number).split("");
        for (String numberString : individualNumber) {
            if (haveToClap(numberString)) {
                count++;
            }
        }
        return count;
    }
    static boolean haveToClap(String numberString){
        String[] compare = {"3","6","9"};
        for(int i = 0; i < 3; i++){
            if(numberString.equals(compare[i])){
                return true;
            }
        }
        return false;
    }
    boolean isViolatedRestrictions(int number){
        return !(1 <= number && number <= 10_000);
    }
}
