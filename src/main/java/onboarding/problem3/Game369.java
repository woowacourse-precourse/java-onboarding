package onboarding.problem3;

public class Game369 {

    public static boolean checkNumberIs369(int number){
        return (number == 3 || number == 6 || number == 9);
    }

    public static int getClapTimeOfNumber(int number){
        int clapTimeOfNumber = 0;

        String digitsOfNumber = String.valueOf(number);


        for(char digit : digitsOfNumber.toCharArray()){
            if(checkNumberIs369(Character.digit(digit,10))){
                clapTimeOfNumber += 1;
            }
        }
        return clapTimeOfNumber;
    }

}
