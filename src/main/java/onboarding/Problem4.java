package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String upperDictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String frogUpperDictionary = reverseString(upperDictionary);
        String lowerDictionary = "abcdefghijklmnopqrstuvwxyz";
        String frogLowerDictionary = reverseString(lowerDictionary);
        for(int i=0; i<word.length(); i++) {
            if (checkLetter(word.charAt(i)) == "A")
                answer += translateUpperCase(word.charAt(i), upperDictionary, frogUpperDictionary);
            if (checkLetter(word.charAt(i)) == "a")
                answer += translateLowerCase(word.charAt(i), lowerDictionary, frogLowerDictionary);
            if (checkLetter(word.charAt(i)) == "etc")
                answer += word.charAt(i);

        }

        return answer;
    }
    // 문자열 대문자,소문자,공백, 특수기호, 확인
    public static String checkLetter(char letter){
        if (Character.isUpperCase(letter)) return "A";
        if (Character.isLowerCase(letter)) return "a";
        else return "etc";

    }

    // 대문자 변환
    public static char translateUpperCase(char letter, String dictionary, String frogDictionary){
        int index = -1;
        index = dictionary.indexOf(letter);
        return frogDictionary.charAt(index);

    }
    // 소문자 변환
    public static char translateLowerCase(char letter, String dictionary, String frogDictionary){
        int index = -1;
        index = dictionary.indexOf(letter);
        return frogDictionary.charAt(index);
    }

    // 배열 역순 정렬
    public static String reverseString(String dictionary){
        StringBuffer sb = new StringBuffer(dictionary);
        return sb.reverse().toString();
    }


}
