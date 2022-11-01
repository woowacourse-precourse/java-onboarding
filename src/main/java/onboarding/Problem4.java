package onboarding;

public class Problem4 {
    public static String change_Word(String str){
        String result = "";
        for (int i=0; i< str.length(); i++){
            Character ch = str.charAt(i);

            if (Character.isUpperCase(ch)){
                result = result + ((char)('Z'-ch +'A'));
            }

            else if (Character.isLowerCase(ch)){
                result = result + ((char)('z' - ch + 'a'));
            }
            else {
                result = result + (ch);
            }
        }
        return result;
    }

    public static String solution(String word) {
        String answer = "";
        answer = change_Word(word);
        return answer;
    }
}
