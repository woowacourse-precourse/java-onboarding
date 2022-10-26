package onboarding;


//        - 1. 문자열 내에서 연속으로 등장하는 문자를 찾기
//        - 2. 찾은 문자를 입력받은 문자열에서 제거한 뒤, 다시 1번 수행
//        - 3. 1번에서 연속으로 등장하는 문자를 찾을 수 없을 때 까지 1~2 반복

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";
        String duplicatedStr = "";

        do {

            duplicatedStr = getDuplicatedStr(cryptogram);
            cryptogram = cryptogram.replaceAll(duplicatedStr, "");

        } while (duplicatedStr.length() > 1);

        answer = cryptogram;

        return answer;

    }

    public static String getDuplicatedStr(String str) {

        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {

                String duplicatedStr = String.valueOf(str.charAt(i));
                duplicatedStr += duplicatedStr;

                return duplicatedStr;
            }

        }
        return "";
    }

}
