package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int num_len = (""+i).length();
            for (int j=0; j<num_len; j++) {
                if ((""+i).charAt(j)== '3' || (""+i).charAt(j)== '6' ||(""+i).charAt(j)=='9' ) {
                    answer+=1;
                }
            }
        }
        return answer;
    }
}
