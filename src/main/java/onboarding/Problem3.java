package onboarding;

public class Problem3 {
    static final char gameFstNum = '3';
    static final char gameSndNum = '6';
    static final char gameThdNum = '9';
    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++){
            String str = Integer.toString(i);
            char[] numChArr = str.toCharArray();

            for(char chNum : numChArr){
                if(chNum == gameFstNum || chNum == gameSndNum || chNum == gameThdNum){
                    answer++;
                } // end if
            } // end for
        } // end for

        return answer;
    }
}
