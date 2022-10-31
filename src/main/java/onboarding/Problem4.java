package onboarding;

public class Problem4 {
//    public static String solution(String word) {
//        StringBuilder answer = new StringBuilder();
//        for (char c : word.toCharArray()) {
//            answer.append(convertToFrogLanguage(c));
//        }
//        return answer.toString();
//    }
//
//    private static char convertToFrogLanguage(char c) {
//        if (Character.isLowerCase(c)) {
//            return (char) ('z' - c + 'a');
//        } else if (Character.isUpperCase(c)) {
//            return (char) ('Z' - c + 'A');
//        } else return c;
//    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        word.chars()
          .mapToObj(c -> CharacterFactory.convert((char) c))
          .map(Char::reverse)
          .forEach(answer::append);
        return answer.toString();
    }
}


class CharacterFactory{
    public static Char convert(char c) {
        if(Character.isLowerCase(c)) return new LowerChar(c);
        else if(Character.isUpperCase(c)) return new UpperChar(c);
        else return new OtherChar(c);
    }
}

interface Char{
    char reverse();
}

class LowerChar implements Char{

    char value;

    public LowerChar(char value) {
        this.value = value;
    }

    @Override
    public char reverse() {
        return (char) ('z' - value + 'a');
    }
}

class UpperChar implements Char{

    char value;

    public UpperChar(char value) {
        this.value = value;
    }

    @Override
    public char reverse() {
        return (char) ('Z' - value + 'A');
    }
}

class OtherChar implements Char {

    char value;

    public OtherChar(char value) {
        this.value = value;
    }

    @Override
    public char reverse() {
        return value;
    }
}