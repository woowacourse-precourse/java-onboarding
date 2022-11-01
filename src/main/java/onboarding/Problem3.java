package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i=0; i<=number; i++){
            answer += count_clap(i);
        }
        return answer;
    }
    public static int count_clap(int num) {
        String maxnum = String.valueOf(num);
        int cnt = 0;
        for (int i =0; i<maxnum.length(); i++) {
            if (maxnum.split("")[i].equals("3") ||
                maxnum.split("")[i].equals("6") ||
                maxnum.split("")[i].equals("9")) {
                cnt++;
            }
        }
        return cnt;
    }
}
