package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            char[] cryptogramArray = cryptogram.toCharArray();
            StringBuilder decoding = new StringBuilder();

            boolean duplicateFlag = false;
            char prevC = 0;
            for (char c : cryptogramArray) {
                if (c != prevC) {
                    if (duplicateFlag) {
                        decoding.deleteCharAt(decoding.length() - 1);
                        duplicateFlag = false;
                    }
                    decoding.append(c);
                    prevC = c;
                } else {
                    duplicateFlag = true;
                }
            }

            // "aa" 와 같은 예제 처리
            if (duplicateFlag) {
                decoding.deleteCharAt(decoding.length() - 1);
            }

            // 기존 문자열에서 바뀐 부분이 없으면 종료
            if (decoding.length() == cryptogramArray.length) {
                return cryptogram;
            }

            cryptogram = decoding.toString();
        }
    }
}