package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String linkedNums = linkNums(number);
        int answer = countNum(linkedNums, "369");
        return answer;
    }
    static String linkNums(int num) {
        String result = "";
        for (int i=1;i<=num;i++) {
            result += String.valueOf(i);
        }
        return result;
    }
    static int countNum(String str, String target) {
        return str.length() - str.replaceAll("["+target+"]", "").length();
    }
}
