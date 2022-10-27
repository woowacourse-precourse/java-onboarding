package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static String removeSuccessiveString(String _cryptogram) {
        // i번 째부터 j번 째까지 문자가 같은지 확인하고, 중복된 경우 제거
        int i = 0; // 시작 문자 인덱스
        int j = i + 1; // 끝 문자 인덱스
        while (j < _cryptogram.length()) {
            if (_cryptogram.charAt(i) == _cryptogram.charAt(j)) { // i번째와 j번째가 같으면 다음 문자도 같은지 확인
                j += 1; //
                if (j == _cryptogram.length()) { // 문자열 끝까지 확인한 경우, 문자열 제거 후 반복문 빠져나감.
                    _cryptogram = _cryptogram.substring(0, i);
                }
            } else if (j - i > 1) { // i번쨰와 j번째가 다르고, i와 j사이에 반복된 문자가 잇는 경우 반복 문자 제거
                _cryptogram = _cryptogram.substring(0, i) + _cryptogram.substring(j);
                j = i + 1;
            } else { // i번쨰와 j번째가 다르고, i, j번재가 붙어있는 경우 다음 인덱스 체크
                i += 1;
                j += 1;
            }
        }
        return _cryptogram;
    }
}