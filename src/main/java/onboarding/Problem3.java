package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    static String linkNums(int num) {
        String result = "";
        for (int i=1;i<=num;i++) {
            result += String.valueOf(i);
        }
        return result;
    }
    public static void main(String args[]) {
        System.out.println(linkNums(13));
    }
}
