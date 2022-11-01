package onboarding.problem3;

public class Validator {
    public static boolean validate(int number){
        if(!isInRange(number)){
            return false;
        }
        return true;
    }
    public static boolean isInRange(int number){
        return (number >=1) && (number <= 10000);
    }
}
