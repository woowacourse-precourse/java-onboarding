package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = TreeFrog.listenAndRepeat(word);
        return answer;
    }
}

class TreeFrogWord {
    char[] treeFrogWord;

    TreeFrogWord(char[] treeFrogWord) {
        this.treeFrogWord = reverseWords(treeFrogWord);
    }

    private char[] reverseWords(char[] arrayWords) {

        char[] reversedWords = new char[arrayWords.length];

        for (int i = 0; i < arrayWords.length; i++) {
            reversedWords[i] = reverseWord(arrayWords[i]);
        }

        return reversedWords;
    }

    private char reverseWord(char oneLetter) {

        if (Character.isUpperCase(oneLetter)) {
            return (char)(155 - oneLetter);
        }

        if (Character.isLowerCase(oneLetter)) {
            return (char)(219 - oneLetter);
        }

        return oneLetter;
    }

    public String makeString() {
        return String.valueOf(treeFrogWord);
    }

}

class TreeFrog{
    private static TreeFrogWord treeFrogWord;
    public static String listenAndRepeat(String momSay) {
        treeFrogWord = new TreeFrogWord(momSay.toCharArray());
        return treeFrogWord.makeString();
    }

}