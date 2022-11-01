package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            String count = Integer.toString(i);

            for(int j=0; j<count.length(); j++) {
                if('3' == count.charAt(j) || '6' == count.charAt(j) || '9' == count.charAt(j))
                    answer++;
            }
        }
        return answer;
    }
}
