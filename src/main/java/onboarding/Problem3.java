package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int total_count = 0;

        for(int i=1; i<=number; i++) {
            String a = String.valueOf(i);
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j) == '3' || a.charAt(j)=='6' || a.charAt(j)=='9') {
                    total_count++;
                }
            }

        }
        return total_count;
    }
}
