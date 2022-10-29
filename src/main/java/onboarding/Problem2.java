package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while (checkString(cryptogram)) {

        }
        return answer;
    }
    // 문자열엥서 중복된 문자가 있는지 확인하는 메서드
    static boolean checkString(String cryptogram) {
        boolean flag = false;
        String[] stringArr = cryptogram.split("");
        for (int i = 0; i < stringArr.length - 1; i++) {
            String first = stringArr[i];
            String second = stringArr[i + 1];
            if(first.equals(second)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
