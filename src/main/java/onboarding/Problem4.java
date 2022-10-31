package onboarding;

//기능1. 알파벳을 아스키코드로 변환한다.
//기능2. 아스키코드에서 대문자면 -65를, 소문자면 -97 하여 몇번째 알파벳인지 구한다(n)
//기능3. 반대문자 = 원래문자+(25-2n)을 하여 반대문자를 구한 뒤 answer에 넣는다.
//기능4. 리스트를 문자열로 변환 후 반환한다.
//기능5. 기능2,3,4 를 포문으로 만든뒤 완성된 문자열을 answer로 반환한다.
//기능5-1. 알파벳인지 공백을 포함한 다른 특수문자인지 우선적으로 검사한다.

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int n =0;

        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                if (Character.isUpperCase(c)) {
                    n = (int) word.charAt(i) + 25 - 2 * ((int) word.charAt(i) - 65);
                    answer = answer.concat(String.valueOf((char) n));
                } else {
                    n = (int) word.charAt(i) + 25 - 2 * ((int) word.charAt(i) - 97);
                    answer = answer.concat(String.valueOf((char) n));
                }
            } else {
                answer = answer.concat(String.valueOf(c));
            }
        }

        return answer;
    }
}
