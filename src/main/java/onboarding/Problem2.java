package onboarding;

/*
문제 설명
- 임의의 문자열의 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성해야 한다.
*/

/*
기능 목록
- 연속하는 중복 문자 삭제하는 기능 구현하기
*/

public class Problem2 {
    public static String solution(String cryptogram) {

        int pivot = 0;
        int left = 0;
        int right = 1;
        String duplicate_str = "";

        while (right < cryptogram.length()) {
            if (duplicate_str.length() < 1) {
                duplicate_str = duplicate_str.concat(cryptogram.substring(left, left + 1));
            }

            if (cryptogram.charAt(left) == cryptogram.charAt(right)) {
                duplicate_str = duplicate_str.concat(cryptogram.substring(right, right + 1));
                right += 1;
            }
            else {
                if (duplicate_str.length() > 1) {
                    if (right + 1 < cryptogram.length() && cryptogram.charAt(right) == cryptogram.charAt(right + 1)) {
                        left = right;
                        right += 1;
                        duplicate_str = duplicate_str.concat(cryptogram.substring(left, left + 1));
                    }
                    else {
                        cryptogram = cryptogram.replace(duplicate_str, "");

                        if (pivot != 0) {
                            pivot -= 1;

                        }
                        left = pivot;
                        right = left + 1;
                        duplicate_str = cryptogram.substring(left, left + 1);
                    }

                }
                else {
                    pivot += 1;
                    left = pivot;
                    right = left + 1;
                    duplicate_str = cryptogram.substring(left, left + 1);
                }
            }
        }

        if (duplicate_str.length() > 1) {
            cryptogram = cryptogram.replace(duplicate_str, "");
        }

        return cryptogram;
    }
}
