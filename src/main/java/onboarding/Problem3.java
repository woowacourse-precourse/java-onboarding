package onboarding;


public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        String strNum = splitNum(number);
        answer = checkClap(strNum);

        return answer;
    }
    public static String splitNum(int number){
        StringBuilder num = new StringBuilder();
        for(int i = 1;i<=number; i++){
            num.append(i);
        }

        return num.toString();
    }
    public static int checkClap(String strNum){
        int count = 0;
        for(int i = 0; i< strNum.length(); i++) {
            if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9') {
                count++;
            }
        }return count;

    }





}
