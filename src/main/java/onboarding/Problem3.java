package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++){
            answer+=countNum(i);
        }

        return answer;
    }

    public static int countNum(int cur_number){
        int count = 0;
        String num = String.valueOf(cur_number);
        if (num.contains("3") || num.contains("6") || num.contains("9")) {
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                    count++;
                }
            }
        }
        return count;
    }

}
