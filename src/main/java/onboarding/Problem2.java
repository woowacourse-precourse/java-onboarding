package onboarding;

/*
* 1-1. i인덱스에 위치한 알파벳과 i+1 인덱스에 위치한 알파벳의 위치를 구하는 메소드 생성 후 정의 (단 없으면 -1이 반환되어야 한다.)
* 1-2. -1(혹은 그외 음수 포함)이 반환되어야 하는 이유는 0이나 그 외에 숫자를 반환 시키면 첫 번째 인덱스(0번)이 반환 될때 종료되기 때문.
* 2-1. 재귀함수를 통해 -1이 반환되면 종료하고, 그렇지 않으면 반환된 인덱스를 통해 문자를 가공시켜 다시 저장
* 2-2. -1이 반환될 때 까지 반복
* 3. solution 완성
* */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decryption(cryptogram);
        return answer;
    }

    public static String decryption(String cryptogram) {
        int checkSequence = checkSameAlphabet(cryptogram);
        int tempSequence = checkSequence + 2;
        if (checkSequence == -1) {
            return cryptogram;
        }
        cryptogram = cryptogram.substring(0, checkSequence) + cryptogram.substring(tempSequence);

        return decryption(cryptogram);
    }

    public static int checkSameAlphabet(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (i != cryptogram.length() - 1) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
