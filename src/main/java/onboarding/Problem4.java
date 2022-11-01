package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] words = word.split("");

        for (int i = 0; i < word.length(); i++) {
            //띄어쓰기가 있던 자리에는 공백을 추가
            if (words[i].isBlank()) {
                answer += " ";
            }
            //알파벳이 있던 자리에는 매치시킨 알파벳을 추가
            answer += matchAlphabet(words[i]);
        }
        return answer;
    }

    /* 입력받은 알파벳이 정방향 배열의 몇 번째 인덱스값과 일치하는지 확인 후,
       같은 자리에 있는 역방향 배열의 값을 반환하는 메서드 */
    private static String matchAlphabet(String alphabet) {
        String findAlphabet = "";

        //비교 대조할 수 있는 배열 두 개를 선언
        String[] alphabetSort = {"A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i","J","j","K","k","L","l","M","m",
                "N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u","V","v","W","w","X","x","Y","y","Z","z"};
        String[] alphabetReserveSort = {"Z","z","Y","y","X","x","W","w","V","v","U","u","T","t","S","s","R","r","Q","q","P","p","O","o","N","n",
                "M","m","L","l","K","k","J","j","I","i","H","h","G","g","F","f","E","e","D","d","C","c","B","b","A","a"};

        for (int i = 0; i < alphabetSort.length; i++) {
            if (alphabet.equals(alphabetSort[i])) {
                findAlphabet = alphabetReserveSort[i];
            }
        }
        return findAlphabet;
    }
}
