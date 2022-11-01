package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int cnt = 1; cnt < number + 1; cnt++) {
            String s = Integer.toString(cnt);
            for(int i=0;i<s.length();i++){
                if (check(s.charAt(i))){
                    answer+=1;
                }
            }
        }
        return answer;
    }
    public static Boolean check(char c){
        if (c=='3'){
            return true;
        }
        else if (c=='6'){
            return true;
        }
        else if (c=='9'){
            return true;
        }
        return false;
    }
}
