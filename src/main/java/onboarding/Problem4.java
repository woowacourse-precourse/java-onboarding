package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        TreeFrogDictionary treeFrogDict = new TreeFrogDictionary();
        answer = treeFrogDict.translate(word);
        return answer;
    }
}

class TreeFrogDictionary {
    // 글자를 뒤집는 함수 (A -> Z, M -> N)
    // input : char형 변수
    // output: 변환된 char형 변수
    private char reverse(char c) {
        // 아스키 코드 변환하기
        int ascii = c;
        // 대문자 여부 판별하기
        boolean isUpper = (ascii >= 65 && ascii <= 90);

        // 문자를 뒤집기 위해 기준점이 될 마스크 설정
        int mask = (isUpper) ? 78 : 110;

        // 문자 변환 프로세스
        // 1. 25개 문자 중 13번째 N을 기준으로 마스크 씌우기 (-13 ~ 12)
        // 2. 마스크 처리된 글자에 1을 더한 후 부호 변환
        int transed = - (ascii - mask + 1);

        // 3. 문자에 다시 마스크를 벗기기
        ascii = (transed + mask);

        return (char) ascii;
    }

    // 문자인지 여부를 판별해주는 함수
    // input : char형 변수
    // output: true/false
    private boolean isAlpha(char c) {
        int ascii = c;
        return (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122);
    }

    // 단어에 청개구리 규칙을 적용하는 함수
    // input : 변환할 문자열 
    // output: 변환된 문자열
    String translate(String word) {
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i ++)
            if (isAlpha(arr[i]))
                arr[i] = reverse(arr[i]);

        return new String(arr);
    }
}