/*
*기능목록
* 1. 해석하는 함수
* 2. 중복된 문자가 있는지 확인하는 함수
* 3. 중복된 문자를 빼고 나머지 문자열을 return하는 함수
*/
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
//        return cryptogramInterpretation(cryptogram);
    }
    public static String cryptogramInterpretation(String cryptogram) {
        String newCryptogram = cryptogram;
        do {
            cryptogram = newCryptogram;
            newCryptogram = overlapCheckfromStringOneTime(cryptogram);
        }while(!cryptogram.equals(newCryptogram) && newCryptogram.length() != 0);
        cryptogram = newCryptogram;
        return cryptogram;
    }
    public static String overlapCheckfromStringOneTime(String cryptogram) {
        int stringSize = cryptogram.length();
        boolean overlapCheck = false;
        int overlapCount = 1;
        char pastChar = getCharfromStringIndex(cryptogram, stringSize - 1);
        for (int i = stringSize - 2; i >= 0; i--) {
            if (pastChar == cryptogram.charAt(i)) {
                overlapCheck = true;
                overlapCount++;
                continue;
            }
            if (overlapCheck) {
                cryptogram = overlapCharsDelete(cryptogram, i + 1, overlapCount);
                overlapCheck = false;
                overlapCount = 1;
            }
            if (i == cryptogram.length()) {
                i = cryptogram.length() - 1;
            }
            pastChar = cryptogram.charAt(i);
        }
        if (overlapCheck) {
            cryptogram = overlapCharsDelete(cryptogram, cryptogram.length() - overlapCount, overlapCount);
        }
        return cryptogram;
    }

    public static char getCharfromStringIndex(String cryptogram, int index) {
        return cryptogram.charAt(index);
    }

    public static String overlapCharsDelete(String cryptogram, int position, int size) {
        String startSubString = cryptogram.substring(0, position);
        String endSubString = cryptogram.substring(position + size, cryptogram.length());
        return startSubString.concat(endSubString);
    }
}
