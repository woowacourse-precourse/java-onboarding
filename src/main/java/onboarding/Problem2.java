package onboarding;

public class Problem2 {


    public static boolean hasTextDuplication(StringBuilder crypto) {

        int len = crypto.length();

        for (int i = 0; i < len - 1; i++) {

            // 현재 위치와 다음 위치의 문자가 같을 경우 중복
            if (crypto.charAt(i) == crypto.charAt(i + 1)) {
                    return true;
            }
        }

        return false;

    }

    public static String solution(String cryptogram) {

        String answer = "answer";
        answer = removeTextDuplication(cryptogram);

        return answer;
    }

    public static void main(String[] args) {
        String result = solution("browoanoommnaon");
        System.out.println(result);
    }
}
