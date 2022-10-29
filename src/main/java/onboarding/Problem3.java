package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++) {
            String s=Integer.toString(i);
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                if(c=='3'||c=='6'||c=='9'){
                    answer+=1;
                }
            }
        }
        return answer;
    }
}
