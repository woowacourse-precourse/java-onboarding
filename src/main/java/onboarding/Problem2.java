package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (true) {
            // 중복된 문자열이 있는 확인하는 변수
            int duplicatedChek = 0;

            // checkDuplicated()메소드에서 strIndex + 1 까지 검사하기 때문에 for문에서의 strIndex는 cryptogram 길이 - 1까지 제한시킨다.
            for (int strIndex = 0; strIndex < cryptogram.length() - 1; strIndex++) {
                // 연속으로 중복된 index를 찾으면
                if (checkDuplicated(cryptogram, strIndex) == true) {

                    //중복 문자열의 끝 index
                    int strDuplicatiedIndex = findDuplicatedIndex(cryptogram, strIndex);

                    // 연속된 문자열 제거
                    cryptogram = removeConsecutiveDuplicatedWord(cryptogram, strIndex, strDuplicatiedIndex);

                    // 문자열이 바뀌였으므로 처음부터 다시 검사
                    duplicatedChek = 1;
                    break;
                }
            }
            // 바뀐 문자열이 없으므로 검사 중지
            if (duplicatedChek == 0) break;
        }

        return cryptogram;
    }

    // 중복된 단어의 끝 index를 반환하는 함수
    public static int findDuplicatedIndex(String cryptogram, int strIndex) {
        int strDuplicatiedIndex = strIndex + 1;
        // cryptogram의 길이 보다 작은 중복된 단어 끝 index를 찾는다.
        while (strDuplicatiedIndex < cryptogram.length() && cryptogram.charAt(strIndex) == cryptogram.charAt(strDuplicatiedIndex)) {
            strDuplicatiedIndex++;
        }
        strDuplicatiedIndex--;

        return strDuplicatiedIndex;
    }

    // 연속으로 중복된 단어를 제거한 문자열을 반환하는 함수
    public static String removeConsecutiveDuplicatedWord(String cryptogram, int startIndex, int endIndex) {
        return cryptogram.substring(0, startIndex) + cryptogram.substring(endIndex + 1);
    }

    // 연속으로 중복된 단어가 있는지 검사하는 함수
    public static boolean checkDuplicated(String cryptogram, int strIndex) {
        return cryptogram.charAt(strIndex) == cryptogram.charAt(strIndex + 1);
    }
}
