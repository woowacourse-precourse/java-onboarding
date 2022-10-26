package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = check(number);

        return result;
    }

    public static int check(int num){

        int sum = 0;

        for(int i=1; i<=num; i++){
            String s = Integer.toString(i);
            for(int j=0; j<s.length(); j++){
                if((int) s.charAt(j) ==3 | (int)s.charAt(j) == 6 | (int)s.charAt(j) ==9) {
                    sum+=1;
                }
            }

        }
        return sum;
    }
}
