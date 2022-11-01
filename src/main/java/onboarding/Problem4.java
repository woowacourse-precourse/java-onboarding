package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return frogDictionary(word);
    }

    static String frogDictionary(String word){
        String frogWord="";
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                frogWord=frogWord+(char)('Z'-word.charAt(i)+'A');
            }
            else if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
                frogWord=frogWord+(char)('z'-word.charAt(i)+'a');
            }
            else frogWord=frogWord+word.charAt(i);
        }
        return frogWord;
    }
}
