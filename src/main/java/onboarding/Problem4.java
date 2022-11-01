package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String difference = "";

        char[] rightAlpha = new char[26];
        char[] rightCAlpha = new char[26];
        char[] wordList = word.toCharArray();

//        알파벳순
        for(int i=0;i<rightAlpha.length;i++)
        {
            rightAlpha[i] = (char)((int)'a' + i);
        }

//        대문자 알파벳순
        for(int i=0;i<rightAlpha.length;i++)
        {
            rightCAlpha[i] = (char)(65 + i);
        }

        for(int i = 0 ; i < wordList.length; i++){
            difference = answer;
            for(int j = 0; j < rightCAlpha.length; j++){
                if(wordList[i] == rightAlpha[j]){
                    //소문자 a 와 소문자 z를 더하면 219
                    //끝과 끝의 문자를 더하기에 219에서 특정 문자를 정수화 시켜 감산하면
                    //그와 상반되는 위치의 문자가 도출됨
                    wordList[i] = (char)(219 - (int)wordList[i]);
                    answer += wordList[i];
                    break;
                }
                else if(wordList[i] == rightCAlpha[j]){
                    //155 -> 대문자 A와 대문자 Z의 합
                    wordList[i] = (char)(155 - (int)wordList[i]);
                    answer += wordList[i];
                    break;
                }
            }
            if (difference.equals(answer) == true){
                answer += wordList[i];
            }
        }
//        +알파벳을 수치화시켜서 챌린지해볼만 함.
        return answer;
    }
}
