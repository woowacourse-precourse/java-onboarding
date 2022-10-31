package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char w : word.toCharArray()){
            if(w >= 'a' && w <= 'z')
                answer += ChangeWord(w, false);
            else if(w >= 'A' && w <= 'Z')
                answer += ChangeWord(w, true);
            else
                answer += w;
        }

        return answer;
    }

    public static char ChangeWord(char word, Boolean isUpper){
        char starWord = isUpper ? 'A' : 'a';
        int number = word - starWord;
        return (char)(25 - number + starWord);
    }
}
