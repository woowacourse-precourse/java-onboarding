package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            String tmp = Integer.toString(i);

            for(int j=0; j<tmp.length(); j++) {
                if('3' == tmp.charAt(j) || '6' == tmp.charAt(j) || '9' == tmp.charAt(j))
                    answer++;
            }
        }
        return answer;
    }
}
