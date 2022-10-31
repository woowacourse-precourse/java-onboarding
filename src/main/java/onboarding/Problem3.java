package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        String sumNumbers ="";
        int count = 0;

        for(int i =1; i<=number; i++) sumNumbers += i;

        for(int i=0;i<sumNumbers.length();i++){
            if(sumNumbers.charAt(i) == '3'||sumNumbers.charAt(i) == '6'||sumNumbers.charAt(i) == '9'){
                count ++;
            }
        }
        answer =count;

        return answer;
    }
}

