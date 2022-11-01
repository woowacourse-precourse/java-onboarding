package onboarding;

public class Problem3 {
    public static int count_369(String s) {
        int count=0; char c;
        for(int j=0; j<s.length(); j++) {
            c = s.charAt(j);
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<number+1; i++) {
            answer+=count_369(String.valueOf(i));
        }
        return answer;
    }
}