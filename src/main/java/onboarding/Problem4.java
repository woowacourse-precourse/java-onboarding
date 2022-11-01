package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = TreeFrog(word);

        return answer;
    }

    /**
     * 왼쪽부터 순서대로 알파벳인지 검사 후, 알파벳이면 ReverseWord 메서드로 전달해서 청개구리 전환.
     * @param word 원본 입력 문자열
     * @return 변환된 문자열
     */
    public static String TreeFrog(String word){
        char[] wordArray = word.toCharArray();

        for(int i = 0; i < wordArray.length; i ++){
            if(wordArray[i] >= 'a' && wordArray[i] <= 'z'){ // 소문자일 경우
                wordArray[i] = ReverseWord(wordArray[i], false); // 소문자 청개구리 변환
            }
            if(wordArray[i] >= 'A' && wordArray[i] <= 'Z'){ // 대문자일 경우
                wordArray[i] = ReverseWord(wordArray[i], true);
            }
        }

        return new String(wordArray);
    }

    /**
     * 청개구리 변환을 사용하고 문자를 반환함
     * @param alphabet 변환을 적용할 문자
     * @param wordCase true 대문자, false 소문자
     * @return 청개구리 변환을 적용한 문자
     */
    public static char ReverseWord(char alphabet, boolean wordCase){
        char starter; // 기준점이 될 문자
        int alphabetAmount = 25; // 알파벳 총 개수
        if(wordCase){
            starter = 'A';
        }
        else{
            starter = 'a';
        }

        return (char)(alphabetAmount + (2 * starter - alphabet)); // 청개구리 문자 변환 식
    }
}
