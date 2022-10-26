package onboarding;

import java.util.ArrayList;

/*
    요구사항 분석
    주어진 문자열에서 연속으로 중복된 문자를 찾고 제거
    연속으로 중복된 문자가 없을때 까지 반복

    다만, 처음부터 중복된 문자가 없을 경우 새로운 암호가 만들어지지 않았음으로 "" 을 return


    코드 구현
    Step1. 중복된 문자가 있는지 확인하는 메서드(A) 만들고 반복문 돌리기
           중복된 문자가 없는경우 반복문 종료
    Step2. 메서드(A)에서 문자열을 탐색하며 중복되면 삭제하고 중복이 아닌경우 새로운 문자열에 추가

    예외처리 사항
    처음부터 중복된 문자가 없을 경우 새로운 암호가 만들어지지 않았음으로 "" 을 return
 */
public class Problem2 {
    public static String solution(String cryptogram) {

        String newCryptogram = decryption(cryptogram);

        while (newCryptogram.length() != cryptogram.length() && newCryptogram.length() != 0) {
            cryptogram = newCryptogram;
            newCryptogram = decryption(cryptogram);
        }

        cryptogram = newCryptogram;
        return cryptogram;
    }

    private static String decryption(String cryptogram) {

        StringBuilder newCryptogram = new StringBuilder();
        int addIndex;
        int index = 0;

        //index += addIndex로 인한 String index out of range의 경우 꼭 확인할것
        // a bbb -> ok
        // a bb c -> a, c추가해야하는데 c를 비교할떄 c의 index + 1 을 했을 경우 String index out of range 발생
        while (index < cryptogram.length() - 1) {
            addIndex = 1;
            while (cryptogram.charAt(index) == cryptogram.charAt(index + addIndex)) {
                addIndex++;
                if (index + addIndex == cryptogram.length()) {
                    break;
                }
            }
            //해당 Index가 바로 뒤 글자와 중복이 아닌 경우
            if (addIndex == 1) {
                newCryptogram.append(cryptogram.charAt(index));
            }
            index += addIndex;
        }
        //끝까지 중복이 아닐경우 (index + addIndex가 cryptogram.length() 이상이 아닐 경우 경우)
        if (index < cryptogram.length()) {
            newCryptogram.append(cryptogram.charAt(index));
        }

        return newCryptogram.toString();
    }
}
