package problem7;

public class Validation {

    public static void validate(String name) throws Exception {
        alphabetValidate(name, lengthValidate(name));
    }

    private static void alphabetValidate(String name, int length) throws Exception {
        char letter;

        for (int i = 0; i < length; i++) {
            letter = name.charAt(i);
            if(letter < 'a' || length > 'z') throw new Exception("Invalid alphabet");
        }
    }

    private static int lengthValidate(String name) throws Exception {
        int length = name.length();
        if(length < 1 || length > 30) throw new Exception("Invalid name length");
        return length;
    }
}
