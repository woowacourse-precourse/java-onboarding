package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer= replaceWord(word);
        return answer;
    }
    public static String replaceWord(String word){
        char[]  chars = word.toCharArray();
        String result = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char nextAlphabet = 0;
        for(char c: chars){
            if(Character.isLowerCase(c)){
                for (int i = 0; i < alphabets.length(); i++) {
                    if(alphabets.charAt(i)==c){
                         nextAlphabet= alphabets.charAt(alphabets.length()-1-i);
                    }
                }
            }else if(Character.isUpperCase(c)){
                for (int i = 0; i < alphabets.length(); i++) {
                    if(alphabets.charAt(i)==Character.toLowerCase(c)){
                        nextAlphabet=Character.toUpperCase(alphabets.charAt(alphabets.length()-1-i));
                    }
                }
            }else {
                nextAlphabet = ' ';
            }
            result += nextAlphabet;
        }
        return result;
    }

}
