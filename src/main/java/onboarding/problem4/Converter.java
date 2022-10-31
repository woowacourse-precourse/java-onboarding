package onboarding.problem4;

public class Converter {
    public char func(char c) {
        char result;
        if(c >= 65 && c <= 90){
            result = (char) (155 - c);
            return result;
        } else if (c >=97 && c <= 122) {
            result = (char) (219 - c);
            return result;
        }
        return c;
    }
}
