package onboarding;

public class Problem2 {
    private static Problem2 pro = new Problem2();

    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray(); // 암호의 각 자리 값을 char 배열에 넣는다.

        char checkChar = 0; // 중복 확인을 할 문자
        int checkNo = 0; // 체크하고 있는 문자의 순서
        int count = 0;

        boolean checkContinue = true;

        while (checkContinue) {
            count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (checkChar != chars[i] && chars[i] != 0) { // 새로운 값을 찾았을 때 checkchar 를 변경한다.
                    checkChar = chars[i]; // 체크할 문자에 문자 삽입
                    checkNo = i; // 체크하는 순서 삽입
                    continue;
                }

                if (checkChar == chars[i]) { // 새로운 값이 아니고 동일한 값이라면 checkchar 는 변경되지 않고 현재 보고 있는 chars[i] 의 값을 0으로 변경한다.
                    if (chars[checkNo] != 0) { //중복 문자열이 발생하면 체크하는 순서의 문자를 0으로 치환
                        chars[checkNo] = 0;
                    }

                    chars[i] = 0; // 현재 문자도 0으로 치환
                    count++;
                }
            }
            checkContinue = pro.checkContinue(count);
        }

        return pro.result(chars);
    }


    // 해독한 암호를 문자열로 만든다.
    private String result(char[] chars) {
        String result = "";
        int checkNo = 0;
        for (char a : chars) { // answer 에 해독한 값 중 0 이 아닌 값을 추가한다.
            if (a != 0) {
                result += a;
            }
            checkNo++;
        }
        return result;
    }

    // 암호 해독을 계속해서 진행할건지에 대해 체크
    private boolean checkContinue(int count) {
        if (count == 0) {
            return false;
        }
        return true;
    }
}
