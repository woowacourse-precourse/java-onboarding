package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = count369(number);
        return answer;
    }
    public static int count369(int num){
        int result = 0;
        for(int cnt = 1; cnt <= num; cnt++){
            String str = String.valueOf(cnt);
            for(int i=0;i<str.length();i++){
                char chk = str.charAt(i);
                if(chk == '3' || chk=='6' || chk == '9') result += 1;
            }
        }
        return result;
    }
}
