package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        String sort = "";
        for(int i=1; i<=number;i++) {
            sort+=i;
        }
        for(int i=0;i<sort.length();i++){
            if(sort.charAt(i)==51 || sort.charAt(i)==54 || sort.charAt(i)==57 ){
                result++;
            }
        }
        return result;
    }
}
