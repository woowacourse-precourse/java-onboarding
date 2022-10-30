package onboarding;
//주어진 문자열이 대문자일때, 알파벳을 반대로 변환하는 함수
//주어진 문자열이 소문자일때, 알파벳을 반대로 변환하는 함수
//문자열을 배열로 받아서, 알파벳을 반대로 변환해서 String 타입으로 반환한느 함수
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
//        result = getReverseString(chars, result, alphabets, nextAlphabet);
        return result;
    }

//소문자 철자를 발견했을때, 그 철자를 반대로 변환
    private static char getNextAlphabet(String alphabets, char nextAlphabet, char c) {
        for (int i = 0; i < alphabets.length(); i++) {
            if(alphabets.charAt(i)== c){
                 nextAlphabet = alphabets.charAt(alphabets.length()-1-i);
            }
        }
        return nextAlphabet;
    }

}
