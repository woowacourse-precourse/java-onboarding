package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String tempNumber;
        for(int num = 1; num <= number; num++){
            tempNumber = Integer.toString(num);
            answer += getCountGameNumber(tempNumber);
        }

        return answer;
    }

    public static int getCountGameNumber(String stringNumber){
        int countGameNumber = 0;
        String tempNumber = "";
        String three = "3";
        String six = "6";
        String nine = "9";

        for(int index=0; index < stringNumber.length(); index++){
            tempNumber = String.valueOf(stringNumber.charAt(index));

            if(tempNumber.equals(three) || tempNumber.equals(six) || tempNumber.equals(nine)){
                countGameNumber += 1;
            }
        }
        return countGameNumber;
    }
}
