package onboarding;

/**
 * 1. redo를 false 초기화하고 한글자씩 돌며 이전 글자를 캐시에 저장한다.
 * 2. 캐시와 이번 글자가 같으면 플래그를 truee 두고 현재 인덱스를 저장한다.
 * 3. 캐시와 현재 글자가 다르다면 인덱스에 표기된 글자들을 제거하고 인덱스를 초기화한다.
 * 4. 마저 돈다.
 * 5-1. 문자열이 끝까지 돌았을 때 redo가 false라면 종료하고 현재 문자열을 반환한다.
 * 5-2. redo가 true라면 함수를 재실행한다.
 */
public class Problem2 {
    static Boolean redo;

    public static String solution(String cryptogram) {
        redo = true;
        String result = cryptogram;
        while (redo) {
            redo = false;
            result = routine(result);
        }
        return result;
    }

    private static String routine(String crypto) {
        char cache = Character.MAX_VALUE;
        int pointer = 0;

        for (int i = 0; i < crypto.length(); i++) {
            if (cache == crypto.charAt(i)) {
                pointer++;
                cache = crypto.charAt(i);
                continue;
            }
            else if (pointer > 0) {
                crypto = removeDuplicate(crypto, pointer, i);
                i -= pointer;
                pointer = 0;
                redo = true;
                if (i == crypto.length()) {
                    return crypto;
                }
            }
            cache = crypto.charAt(i);
        }

        if (pointer > 0) {
            crypto = removeDuplicate(crypto, pointer, crypto.length());
            redo = true;
        }

        return crypto;
    }

    private static String removeDuplicate(String crypto, int pointer, int current) {
        String a = crypto.substring(0, current - (1 + pointer));
        String b = crypto.substring(current);
        return a + b;
    }
}
