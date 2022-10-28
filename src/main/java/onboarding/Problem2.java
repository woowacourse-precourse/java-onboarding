package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 예외 처리
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return "제한사항 위반";
        }

        // isLowerCase 는 int 도 true 로 반환하지만 charAt 이 char 로 반환되므로 괜찮다.
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!Character.isLowerCase(cryptogram.charAt(i))) {
                return "제한사항 위반";
            }
        }

        String answer = cryptogram;

        // decode 반복
        while (true) {
            String temp = decode(answer);
            if (temp.equals(answer)) {
                break;
            }
            answer = temp;
        }

        return answer;
    }


    // 연속 문자 제거
    public static String decode(String str) {

        String result = "";

        // 예외처리
        if (str.length() == 0 || str.length() == 1) {
            return str;
        } else if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                return result;
            } else {
                return str;
            }
        }

        // 첫번째 문자 체크
        if (str.charAt(0) != str.charAt(1)) {
            result += str.charAt(0);
        }

        for (int i = 1; i < str.length() - 1; i++) {
            // 중간 문자 체크
            if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i) != str.charAt(i + 1)) {
                result += str.charAt(i);
            }
        }

        // 마지막 문자 체크
        if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
            result += str.charAt(str.length() - 1);
        }

        return result;
    }
}
