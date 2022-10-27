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

    public static String removeDuplicate(String str) {
        // 문자열이 비었다면 빈 문자열 그대로를 반환한다.
        if (str.isEmpty()) {return str;}

        for (int i = 0; i < str.length(); i++) {
            // 연속되는 중복 문자를 발견하면, 중복되는 부분을 제외하고 앞 부분의 문자열과 뒷 부분의 문자열을 concat해준다.
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                String front_str = str.substring(0, i);
                // 중복된 부분이 문자열 제일 뒷부분일 수도 있으므로, 뒷 문자열을 빈 문자열로 일단 초기화해준다.
                String back_str = "";

                if (i + 2 < str.length()) {
                    back_str = str.substring(i + 2);
                }

                str = front_str.concat(back_str);

                break;
            }
            // 문자열 끝까지 순회했음에도 중복된 문자를 발견하지 못하면, 그 문자열을 반환해준다.
            else if (i == str.length() - 1) {
                return str;
            }
        }

        // 연속되는 중복 문자를 다 제거할 때까지, 재귀적으로 찾아준다.
        return removeDuplicate(str);
    }

    public static String solution(String cryptogram) {
        cryptogram = removeDuplicate(cryptogram);

        return cryptogram;
    }
}
