package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String findAlphabet(String alphabet) {
        String[] alphabetSort = {"A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m",
                "N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u","V","v","W","w","X","x","Y","y","Z","z"};
        String[] alphabetReserveSort = {"Z","z","Y","y","X","x","W","w","V","v","U","u","T","t","S","s","R","r","Q","q","P","p","O","o","N","n",
                "M","m","L","l","K","k","J","j","I","i","H","h","G","g","F","f","E","e","D","d","C","c","B","b","A","a"};

        String matchAlphabet = "";

        for (int i = 0; i < alphabetSort.length; i++) {
            if (alphabet.equals(alphabetSort[i])) {
                matchAlphabet = alphabetReserveSort[i];
            }
        }
        return matchAlphabet;
    }
}
