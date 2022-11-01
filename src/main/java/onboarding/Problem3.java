package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int i=0;
        while (i<=number){
            String n = String.valueOf(i);
            for (int j=0;j<n.length();j++){
                int digit = n.charAt(j)-'0';
                if (digit==3 || digit == 6 || digit == 9){
                    answer++;
                }
            }
            i++;
        }
        return answer;
    }
}
