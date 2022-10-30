package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char [] str = tochar(cryptogram);
        for (int i = 0; i < str.length - 1; i++) {
            char prev = str[i];
            char next = str[i + 1];
            if(condition(prev,next)){
                cryptogram = delete(cryptogram,prev,next);
                str = tochar(cryptogram);
                i = -1;
                if (stop(cryptogram)) {
                    break;
                }
            }

        }
            return cryptogram;
    }

        public static String findReapeatChar ( char prev, char next){
            StringBuilder b = new StringBuilder();
            b.append(prev);
            b.append(next);
            return b.toString();
        }

        public static boolean stop (String str){
            return str.equals("") == true;
        }

        public static String delete (String str,char prev, char next){
            String delete = findReapeatChar(prev, next);
            return str.replaceFirst(delete, "");
        }

        public static boolean condition ( char a, char b){
            return a == b == true;
        }

        public static char[] tochar (String str){
            return str.toCharArray();
        }



}
