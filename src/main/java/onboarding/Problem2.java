package onboarding;



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

    public static String solution(String cryptogram) {
        String answer = "";

        if (Exception(cryptogram))
            return answer;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(CheckDuplicate("asdwqezxc"));
        System.out.println(CheckDuplicate("asdwqeqqbb"));
    }
}
