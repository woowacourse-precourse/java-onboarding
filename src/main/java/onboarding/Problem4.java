package onboarding;

public class Problem4 {

    static class Transformer {
        private final int MAX_SENTENCE_LENGTH = 1000;
        private final int MIN_SENTENCE_LENGTH = 1;

        private AbnormalDictionary dictionary = new AbnormalDictionary();
        private String sentence;
        private String result = "";

        public Transformer(String sentence) {
            if(sentence.length()<MIN_SENTENCE_LENGTH || sentence.length()>MAX_SENTENCE_LENGTH) {
                throw new RuntimeException("word의 길이가 올바르지 않습니다");
            }
            this.sentence = sentence;
        }

        String transform(){
            for(int i=0 ; i<sentence.length() ; i++){
                char c = sentence.charAt(i);
                c = (isAlphabet(c))? dictionary.findWord(c) : c;
                result += c;
            }
            return result;
        }

        private boolean isAlphabet(char c) {
            return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
        }
    }


    static class AbnormalDictionary {

        private char findWord(char c) {
            int index =(isUpperCase(c)) ? 'A'+'Z' : 'a'+'z';
            char res = (char)(index - c);
            return res;
        }

        private boolean isUpperCase(char c) {
            return 'A'<=c && c<='Z';
        }
    }

    public static String solution(String word) {
        Transformer transformer = new Transformer(word);
        return transformer.transform();
    }
}
