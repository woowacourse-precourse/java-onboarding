package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i<=number ; i++){
            String s = String.valueOf(i);
            int len = s.length();
            for(int j = 0 ; j<len;j++){
                if(s.charAt(j)=='3' | s.charAt(j)=='6' |s.charAt(j)=='9'){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
