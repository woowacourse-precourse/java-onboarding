package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return changeWord(word);
    }

    // 로직에 맞게 알파벳을 변환하는 기능을 가진 함수
    public static String changeWord(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i =0; i<word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                sb.append((char)(155 - word.charAt(i)));
            } else if (word.charAt(i) >= 97 && word.charAt(i) <= 122){
                sb.append((char)(219 - word.charAt(i)));
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }

}
