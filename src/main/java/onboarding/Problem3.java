package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++){
            String sNumber = Integer.toString(i);
            //각 자리수 탐색
            for(int k = 0; k < sNumber.length(); k++){
                char c = sNumber.charAt(k);
                if(c =='3' || c =='6'||c =='9')
                    count++;
            }
        }
        return count;
    }
}
