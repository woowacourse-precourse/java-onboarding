package onboarding.resolve.problem2;

public class Problem2 {
    public static String solution(String cryptogram) {
        String beforeRemove = "";
        do {
            beforeRemove = cryptogram;
            cryptogram = removeDup(cryptogram);
        } while (!cryptogram.equals(beforeRemove));
        return cryptogram;
    }

    private static String removeDup(String cryptogram) {
        // 첫 문자 부터 확인 하며 앞이나 뒤에 같은 문자 열 ?
        StringBuilder afterRemoveStr = new StringBuilder();
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            if ((idx==0) && (cryptogram.charAt(idx) == cryptogram.charAt(idx+1))){
                // 처음 인덱스의 글자가 다음 글자와 같은 경우
                continue;
            }
            if (idx == cryptogram.length()-1 && cryptogram.charAt(idx-1) == cryptogram.charAt(idx)){
                // 마지막 인덱스의 글자가 이전의 글자와 같은 경우
                continue;
            }
            if (cryptogram.charAt(idx-1) == cryptogram.charAt(idx)
                    || cryptogram.charAt(idx) == cryptogram.charAt(idx+1)) {
                // 앞 뒤의 글자가 동일한 경우
                continue;
            }
            afterRemoveStr.append(cryptogram.charAt(idx));
        }

        return afterRemoveStr.toString();
    }
}
