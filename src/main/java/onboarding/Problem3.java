package onboarding;


public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();

        final char THREE = '3';
        final char SIX = '6';
        final char NINE = '9';

        for (int i = 0; i < number ; i++) {
            sb.append(i+1);
        }

        for (int i = 0; i <sb.length() ; i++) {
            if(sb.charAt(i)==THREE||sb.charAt(i)==SIX||sb.charAt(i)==NINE){
                answer++;
            }
        }

        return answer;
    }

}
