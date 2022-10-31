package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i < number+1 ; i++) {
            String a = Integer.toString(i);
            for (int j = 0; j <a.length() ; j++) {
                if (a.charAt(j) == '3' || a.charAt(j) == '6' ||a.charAt(j) == '9'){
                    answer++;
                }
            }
        }
        return answer;
    }
}
