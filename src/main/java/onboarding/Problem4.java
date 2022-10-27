package onboarding;

public class Problem4 {

    static class Transformer {
        private Problem4.AbnormalDictionary dictionary = new Problem4.AbnormalDictionary();
        private String sentence;
        private String result = "";

        public Transformer(String sentence) {
            if(sentence.length()<1 || sentence.length()>1000) {
                throw new RuntimeException("word의 길이가 올바르지 않습니다");
            }
            this.sentence = sentence;
        }

        String transform(){
            for(int i=0 ; i<sentence.length() ; i++){
                char c = sentence.charAt(i);
                result += dictionary.findWord(c);
            }
            return result;
        }
    }


    static class AbnormalDictionary {

        private char findWord(char c) {
            if(!(('a'<=c && c<='z') || ('A'<=c && c<='Z'))) {
                return c;
            }

            int index = 'a'+'z';
            if('A'<=c && c<='Z') {
                index = 'A'+'Z';
            }

            char res = (char)(index - c);
            return res;
        }
    }
    public static String solution(String word) {
        Transformer transformer = new Transformer(word);
        return transformer.transform();
    }
}
