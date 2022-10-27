package onboarding;


import java.util.Stack;

public class Problem2 {
    static boolean Exception(String cryptogram) {
        if (cryptogram.length() < 1 || 1000 <cryptogram.length())
            return true;
        for (char c : cryptogram.toCharArray()) {
            if (!(Character.isLowerCase(c)))
                return true;
        }
        return false;
    }
    static boolean CheckDuplicate(String str){
        char front_char;
        char back_char;

        for (int i = 0; i < str.length() - 1; i++){
            front_char = str.charAt(i);
            back_char = str.charAt(i + 1);

            if (front_char == back_char)
                return true;
        }
        return  false;
    }

    static Stack<String> DuplicateStr(String str){
        String front_char;
        String back_char;
        Stack<String> result = new Stack<>();

        for (int i = 0; i < str.length() - 1; i++){
            front_char = "" + str.charAt(i);
            back_char = "" + str.charAt(i + 1);

            if (front_char.equals(back_char)) {
                result.push(front_char + back_char);
            }
        }
        return  result;
    }
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<String> duplicate = new Stack<>();

        if (Exception(cryptogram))
            return answer;

        while (CheckDuplicate(cryptogram)) {
            duplicate = DuplicateStr(cryptogram);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
