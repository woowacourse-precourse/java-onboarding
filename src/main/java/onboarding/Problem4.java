package onboarding;


import java.util.LinkedList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {

        List<Character> upperDictionary = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M');
        List<Character> lowerDictionary = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm');
        List<Character> upperDictionary2 = List.of('Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N');
        List<Character> lowerDictionary2 = List.of('z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n');

        char[] characterArray = word.toCharArray();
        List<Character> characterList = new LinkedList<>();

        for (int i = 0; i < characterArray.length; i++) {

            if (upperDictionary.contains(characterArray[i])) {
                characterList.add(upperDictionary2.get(upperDictionary.indexOf(characterArray[i])));
            }
            else if (upperDictionary2.contains((characterArray[i]))) {
                characterList.add(upperDictionary.get(upperDictionary2.indexOf(characterArray[i])));
            }
            else if (lowerDictionary.contains(characterArray[i])) {
                characterList.add(lowerDictionary2.get(lowerDictionary.indexOf(characterArray[i])));
            }
            else if (lowerDictionary2.contains((characterArray[i]))) {
                characterList.add(lowerDictionary.get(lowerDictionary2.indexOf((characterArray[i]))));
            }
            else if (characterArray[i] == ' ') {
                characterList.add(' ');
            } else {
                characterList.add(characterArray[i]);
            }

        }

        String answer;

        if (characterList.size() == 0) {
            answer = "";
        } else {
            answer = characterList.toString().substring(1, 3 * characterList.size() - 1)
                    .replaceAll(", ", "");
        }

        return answer;
    }
}
