package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
// 알파벳을 담은 변수와 매개변수로 들어오는 word를 alphabetList의 인덱스로 관리하는 배열 wordList 선언.
        char[] alphabetList = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
        int[] wordList = new int[word.length()];
//wordList에 알파벳을 인덱스 값으로 변환해서 삽입하는 과정.
        for(int i  = 0; i < word.length(); i++) {
            for(int j = 0; j < alphabetList.length; j++){
                if(word.charAt(i) == alphabetList[j]){
                    wordList[i] = j;
                    break;
                }
            }
        }
//알파벳 순서를 역전하는 과정
        for(int i = 0; i < wordList.length; i++){
            if(wordList[i] < 25){
                wordList[i] = 25 - wordList[i];
            }
            else{
                if(wordList[i] != 52 ) {
                    wordList[i] = 77 - wordList[i];
                }
            }
        }

        String temp = new String();
        for (int i = 0; i < wordList.length; i++) {
            temp = temp + alphabetList[wordList[i]];
        }

        answer = temp;


        return answer;
    }

}
