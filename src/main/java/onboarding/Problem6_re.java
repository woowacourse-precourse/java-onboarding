package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6_re {

    public static void main(String[] args){
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }

    public static List<String> solution(List<List<String>> forms){
        //각 닉네임의 글자 조합을 담는 리스트
        List<List<String>> wordsList = makeWordList(forms);
        //중복이 있는 닉네임은 1, 없는 닉네임은 0
        int[] duplicatedNickIdx = findDuplicatedNick(forms.size(), wordsList);

        List<String> answer = makeAnswer(duplicatedNickIdx,forms);

        return answer;
    }

    public static List<String> makeAnswer(int[] duplicatedNickIdx,List<List<String>> forms){
        List<String> answer = addNickNamesInAnswer(duplicatedNickIdx,forms);
        //중복 제거 및 정렬
        return sortAndRemoveDuplication(answer);
    }


    public static int[] findDuplicatedNick(int size,List<List<String>> wordsList){
        int[] duplicatedNickIdx = initArray(size);
        for (int i= 0; i < size; i++){
            duplicatedNickIdx = isContainWord(wordsList,i,duplicatedNickIdx);
        }
        return duplicatedNickIdx;
    }


    public static int[] isContainWord (List<List<String>> wordsList,int compareIdx,int[] duplicatedNickIdx) {
        for (String w : wordsList.get(compareIdx)) {
            for (int i=0; i < wordsList.size(); i++) {
                if (duplicatedNickIdx[i] != 1 && i != compareIdx && wordsList.get(i).contains(w)) {
                    duplicatedNickIdx[i] = 1;
                    duplicatedNickIdx[compareIdx] = 1;
                }
            }
        }
        return duplicatedNickIdx;
    }

    public static int[] initArray(int size){
        int[] duplicatedNickIdx = new int[size];
        for (int i=0; i < size; i++){
            //0로 배열 초기화
            duplicatedNickIdx[i] = 0;
        }
        return duplicatedNickIdx;
    }

    public static List<List<String>> makeWordList(List<List<String>> forms) {
        List<List<String>> wordsList = new ArrayList<>();
        for (List<String> crew : forms) {
            List<String> words = findWords(crew.get(1));
            wordsList.add(words);
        }
        return wordsList;
    }

    public static List<String> findWords(String nickname){
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < nickname.length()-1; i++) {
            for(int j = i+1; j < nickname.length(); j++) {
                String word = nickname.substring(i,j+1);
                words.add(word);
            }
        }
        return words;
    }

    public static List<String> addNickNamesInAnswer (int[] duplicatedNickIdx, List<List<String>> forms) {
        List<String> answer =new ArrayList<>();
        for (int i =0; i < duplicatedNickIdx.length; i++){
            if (duplicatedNickIdx[i]==1){
                answer.add(forms.get(i).get(0));
            }
        }
        return  answer;
    }

    public static List<String> sortAndRemoveDuplication(List<String> answer){
        List<String> newAnswer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(newAnswer);

        return newAnswer;
    }
}
