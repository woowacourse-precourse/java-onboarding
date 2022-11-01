package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++){
            answer += clap_check(i);
        }

        return answer;
    }

    public static int clap_check(int num){
        String str = Integer.toString(num);
        int cnt = 0;

        for(int i=0;i<str.length();i++){
            if(str.split("")[i].equals("3") || str.split("")[i].equals("6")
                    || str.split("")[i].equals("9")){
                cnt++;
            }
        }
        return cnt;
    }
}
