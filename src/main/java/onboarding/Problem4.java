package onboarding;

public class Problem4 {
    public static String solution(String word) {

        WordConversion wordConversion = new WordConversion(word);

        return wordConversion.convertString();
    }

    public enum Alphabet{
        LOWER_A('a'),
        LOWER_Z('z'),
        UPPER_A('A'),
        UPPER_Z('Z'),
        BLACK(' ');

        private char alphabet;

        Alphabet(char alphabet) {
            this.alphabet = alphabet;
        }

        public char getAlphabet() {
            return alphabet;
        }
    }

    public static class WordConversion {
        private String word;

        WordConversion(String word){
            this.word = word;
        }

        public String convertString(){
            char[] wordToCharArr = word.toCharArray();
            for (int i = 0; i < wordToCharArr.length; i++) {
                wordToCharArr[i] = convertChar(wordToCharArr[i]);
            }
            return String.valueOf(wordToCharArr);
        }

        private static char convertChar(char chr){
            /* ' ' */
            if(chr == Alphabet.BLACK.getAlphabet()){
                return Alphabet.BLACK.getAlphabet();
            }

            /* 'A'~'Z' */
            if(chr>=Alphabet.UPPER_A.getAlphabet() &&
                    chr<=Alphabet.UPPER_Z.getAlphabet()){
                return (char)(Alphabet.UPPER_A.getAlphabet()+
                        (Alphabet.UPPER_Z.getAlphabet()-chr));
            }

            /* 'a'~'z' */
            return (char)(Alphabet.LOWER_A.getAlphabet()+
                    (Alphabet.LOWER_Z.getAlphabet()-chr));
        }
    }
}
