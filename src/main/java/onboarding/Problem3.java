package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++){
            String str = Integer.toString(i);
            char[] numChArr = str.toCharArray();

            for(char chNum : chArr){
                if(chNum == '3' || chNum == '6' || chNum == '9'){
                    answer++;
                } // end if
            } // end for
        } // end for

        return answer;
    }
}
