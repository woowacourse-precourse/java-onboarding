package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<List<String>> wordsList = new ArrayList<>();

        //중복이 안된 닉네임은 1, 중복이 있는 닉네임은 0
        int[] duplicatedNickIdx = new int[forms.size()];
        
        for (int i=0; i < forms.size(); i++){
            //0으로 배열 초기화
            duplicatedNickIdx[i] = 1;
        }

        
        for (List<String> crew : forms) {
            List<String> words = findWords(crew.get(1));
            System.out.println("words = " + words);
            
            duplicatedNickIdx = isContainWord(wordsList,words,duplicatedNickIdx);

            wordsList.add(words);

        }
        
        
        answer = addNickNamesInAnswer(answer,duplicatedNickIdx,forms);

        //중복 제거 및 정렬
        answer = sortAndRemoveDuplication(answer);



        return answer;
    }


    public static List<String> findWords (String nickname) {
        List<String> words = new ArrayList<String>();

        for (int i = 0; i < nickname.length()-1; i++) {

            for(int j = i+1; j < nickname.length(); j++) {

                String word = nickname.substring(i,j+1);
                words.add(word);
            }

        }

        return words;
    }

    public static int[] isContainWord (List<List<String>> wordsList,List<String> words,int[] duplicatedNickIdx) {
        

        for (String w : words) {

            for (int i=0; i < wordsList.size(); i++) {


                if (wordsList.get(i).contains(w)) {
                    duplicatedNickIdx[i] = 0;
                    duplicatedNickIdx[wordsList.size()] = 0;
                }
            }
        }
        
        return duplicatedNickIdx;
    }


    public static List<String> addNickNamesInAnswer (List<String> answer, int[] duplicatedNickIdx, List<List<String>> forms) {
        
        for (int i =0; i < duplicatedNickIdx.length; i++){
            if (duplicatedNickIdx[i]==0){
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

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        System.out.println(solution(forms));
    }
}
