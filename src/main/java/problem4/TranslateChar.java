package problem4;

public class TranslateChar {

    public char translateChar(char c) {
        int criteria = 25;
        int difference;
        char result;

        if(c >= 'A' && c <= 'Z') {
            difference = ('A'-c)*2;

        }else if(c >= 'a' && c <= 'z') {
            difference = ('a'-c)*2;

        }else {
            return c;
        }

        result = (char)((criteria+difference)+c);

        return result;
    }
}
