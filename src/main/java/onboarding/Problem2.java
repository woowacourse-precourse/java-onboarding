package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        //중복이 있는지 체크하는 함수
        //중복이 있으면 제거하는 함수

        while (isRepeated(cryptogram)) {

        }
        

        return "";
    }

    public static boolean isRepeated(String word) {

        for (int i = 0; i < word.length()-1; i++) {

            if (word.substring(i, i + 1).equals(word.substring(i + 1, i + 2))) {
                return true;
            }
        }
        return false;
    }

}
