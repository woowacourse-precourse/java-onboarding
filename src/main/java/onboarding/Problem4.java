package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if(hasException(word)){
            return null;
        }
        return getChangedWord(word);
    }

    public static boolean hasException(String word){
        if(word.length()<1 || word.length()>10000)
            return true;
        return false;
    }


    public static String getChangedWord(String word){
        String result;
        char[] newWord = word.toCharArray();
        for(int i = 0; i < newWord.length; i++){
            if('A' < newWord[i] && newWord[i] < 'Z')
                newWord[i] = (char)('Z'+'A'-newWord[i]);
            else if('a' < newWord[i] && newWord[i] < 'z')
                newWord[i] = (char)('z'+'a'-newWord[i]);
        }
        result = new String(newWord);
        return result;

    }

}
