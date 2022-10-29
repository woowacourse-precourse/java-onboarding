package onboarding;

import onboarding.problem2.NotMatchingCryptogramLengthOrLowerCase;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        checkException(cryptogram);
        answer = getRemovedDuplicateCryptogram(cryptogram);
        return answer;
    }

    // 예외사항
    // 1-1,2 cryptogram 길이와 소문자 체크
    private static void checkException(String cryptogram) {
        if(isNotCryptogramLengthOrLowerCase(cryptogram)){
            throw new NotMatchingCryptogramLengthOrLowerCase("cryptogram 길이 및 소문자가 아닙니다.");
        }
    }

    // 2. 반복해서 연속하는 중복 문자 제거 알고리즘
    private static String getRemovedDuplicateCryptogram(String cryptogram) {

        while(true){
            String removedCrpytogram="";

            boolean foundDuplicateChar = false;

            for (int i = 0; i < cryptogram.length()-1; i++) {

                if(!isDuplicateChar(cryptogram, i)){
                    if(foundDuplicateChar){
                        foundDuplicateChar = false;
                        continue;
                    }
                    removedCrpytogram += cryptogram.charAt(i);
                }

                if(isDuplicateChar(cryptogram,i)){
                    foundDuplicateChar=true;
                }
            }

            removedCrpytogram = getCryptogramLastChar(cryptogram, removedCrpytogram, foundDuplicateChar);

            if(isClosed(cryptogram, removedCrpytogram)) {
                break;
            }

            cryptogram =removedCrpytogram;
        }

        return cryptogram;
    }

    private static String getCryptogramLastChar(String cryptogram, String removedCrpytogram, boolean foundDuplicateChar) {
        if(isNotDuplicatedLastChar(cryptogram, foundDuplicateChar)) {
            removedCrpytogram += cryptogram.charAt(cryptogram.length() - 1);
        }
        return removedCrpytogram;
    }

    private static boolean isClosed(String cryptogram, String removedCrpytogram) {
        return removedCrpytogram.equals(cryptogram);
    }

    private static boolean isNotDuplicatedLastChar(String cryptogram, boolean foundDuplicateChar) {
        return cryptogram.length() > 0 && !foundDuplicateChar;
    }

    private static boolean isDuplicateChar(String cryptogram, int i) {
        return cryptogram.charAt(i) == cryptogram.charAt(i + 1);
    }

    // 예외사항 1-1,2 cryptogram 길이와 소문자 체크
    public static boolean isNotCryptogramLengthOrLowerCase(String cryptogram){
        boolean found = true;

        if(StringUtils.isBlank(cryptogram)){
            found = true;
        }

        String regex = "^[a-z]{1,1000}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(cryptogram);
        if(matcher.matches()){
            found = false;
        }
        return found;
    }

}
