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
    static int countNum(String str, int target) {
        return str.length() - str.replace(String.valueOf(target), "").length();
    }

    public static void main(String args[]) {
        System.out.println(linkNums(13));
        System.out.println(countNum(linkNums(13), 3));
    }
}
