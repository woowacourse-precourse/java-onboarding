package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer;

        answer = numberCounter(number);

        return answer;
    }//public static int solution
    public static int numberCounter(int number){
        int result = 0;

        for(int startNum = 1; startNum <= number; startNum++){
            result += threeSixNineChecker(startNum);
        }

        return result;
    }//public static int numberCounter

    public static int threeSixNineChecker(int startNum){
        String num = String.valueOf(startNum);
        int count = 0;

        for (int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '3'
            || num.charAt(i) == '6'
            || num.charAt(i) == '9'){
                count++;
            }
        }
        return count;
    }//public static int threeSixNineChecker

}//public class Problem3
