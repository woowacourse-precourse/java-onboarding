package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removDuplication(cryptogram);
    }

    public static String removDuplication(String str){

        while(true) {
            // 중복된 문자열이 있는 확인하는 변수
            int duplicatedChek = 0;

            for (int strIndex = 0; strIndex < str.length() - 1; strIndex++) {
                // 연속으로 중복된 index를 찾으면
                if (str.charAt(strIndex) == str.charAt(strIndex + 1)) {
                    int strDuplicatiedIndex = strIndex + 1;
                    // 어디까지 연속인지 검사
                    while (strDuplicatiedIndex < str.length() && str.charAt(strIndex) == str.charAt(strDuplicatiedIndex)) {
                        strDuplicatiedIndex++;
                    }
                    strDuplicatiedIndex--;

                    // 연속된 문자열 제거
                    str = str.substring(0, strIndex) + str.substring(strDuplicatiedIndex + 1);
                    // 문자열이 바뀌였으므로 처음부터 다시 검사
                    duplicatedChek = 1;
                    break;
                }
            }
            // 바뀐 문자열이 없으므로 검사 중지
            if (duplicatedChek == 0) break;
        }

        return str;
    }
}
