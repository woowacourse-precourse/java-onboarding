package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = clapCount(number);
        return answer;
    }
    public static int clapCount(int num){
        int count=0;

        for (int len = num, i=0; i<len; i++){
            String str = String.valueOf(i+1);
            count += clapCheck(str);
        }
        return count;
    }
    public static int clapCheck(String str){
        int cnt = 0;

        for (int len = str.length(), i=0; i<len; i++){
            char c= str.charAt(i);
            if (c=='3'||c=='6'||c=='9'){
                cnt++;
            }
        }
        return cnt;
    }
}
