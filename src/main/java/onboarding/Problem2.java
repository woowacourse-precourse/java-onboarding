package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        char[] characterArray = cryptogram.toCharArray();
        LinkedList<Character> characterList = new LinkedList<>();


        characterList.add(characterArray[0]);
        char savePreChar = characterArray[0];

        for (int i = 1; i < characterArray.length; i++) {

            if(characterArray[i] == characterList.getLast()){
                characterList.removeLast();
            }
            else if(savePreChar == characterArray[i]){

            }
            else{
                characterList.add(characterArray[i]);
            }
            savePreChar = characterArray[i];
        }


        if(characterList.size()==0){
            answer = "";
        }
        else{
            answer = characterList.toString().substring(1, 3 * characterList.size() - 1)
                    .replaceAll(", ", "");
        }

        return answer;
    }
}
