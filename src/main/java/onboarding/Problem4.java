package onboarding;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char [] lowAlpha = arrlowAlpha();
        char [] upperAlpha = arrUpperAlpha();

        HashMap<Character,Character> arrReverseAlhpa = reverseAlpha(lowAlpha,upperAlpha);

        answer = reverseChange(arrReverseAlhpa,word);

        return answer;
    }

   public static char[] arrlowAlpha(){
       char [] lowChar = new char[26];

       for(int i = 0; i<lowChar.length; i++){
           lowChar[i] = (char)(97+i);
       }
       return lowChar;
   }

   public static char[] arrUpperAlpha(){
       char [] upperChar = new char[26];
       for(int i = 0; i<upperChar.length; i++){
           upperChar[i] = (char)(65+i);
       }return upperChar;
   }

   public static HashMap<Character,Character> reverseAlpha(char[] low, char[] upper){
       HashMap<Character, Character> reverseAlpha = new HashMap<>();
       for(int i = 0; i<low.length; i++) {
           reverseAlpha.put(low[i], low[25 - i]);
           reverseAlpha.put(upper[i], upper[25 - i]);
       }return reverseAlpha;
   }

   public static String reverseChange(HashMap<Character, Character> reverseAlpha, String word){
       StringBuilder newWord = new StringBuilder();
       for(int i = 0; i<word.length(); i++){
           if(word.charAt(i) == ' '){
               newWord.append(word.charAt(i));
           }
           if(word.charAt(i) != ' '){
               char a = reverseAlpha.get(word.charAt(i));
               newWord.append(a);
           }

       }return newWord.toString();
   }
}
