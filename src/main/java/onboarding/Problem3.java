package onboarding;

public class Problem3 {
    public  static int countThreeSixNine(int num) {
        int count = 0;

        for(int i=1;i<=num;i++) {
            String sNum = Integer.toString(i);
            count += sNum.length() - sNum.replace("3","").length();
            count += sNum.length() - sNum.replace("6","").length();
            count += sNum.length() - sNum.replace("9","").length();
        }
        return count;
    }
    public static int solution(int number) {
        int answer = countThreeSixNine(number);
        return answer;
    }
}
