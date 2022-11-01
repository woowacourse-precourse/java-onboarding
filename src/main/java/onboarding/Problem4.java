package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] wordArray = word.split("");
        for(int i = 0; i < word.length(); i++){
            if(Character.isAlphabetic(wordArray[i].charAt(0))){
                wordArray[i] = String.valueOf(convertToFrogLanguage(wordArray[i].charAt(0)));
            }
        }
        answer = String.join("",wordArray);
        return answer;
    }

    public static char convertToFrogLanguage(char alphabet){
        int diffSize;
        char result = '\0';
        if(Character.isUpperCase(alphabet)){
            diffSize = (int)'A' - (int)alphabet;
            result =  (char)((int)'Z' + diffSize);
        }
        else if(Character.isLowerCase(alphabet)){
            diffSize = (int)'a' - (int)alphabet;
            result =  (char)((int)'z' + diffSize);
        }
        return result;
    }
}
