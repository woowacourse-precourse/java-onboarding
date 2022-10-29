package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 분리된 닉네임들과 어떤 닉네임에서 사용되었는지를 표시하는 List를 함께 Mapping한다.
        Map<String, List<Integer>> stringToDuplicated = makeDuplicatedMap(forms);

        //중복 제거하기 위해 Set 사용
        Set<String> duplicatedEmails = new HashSet<>();

        for (String check : stringToDuplicated.keySet()){
            //중복 값이 2개 이상 있는 경우
            if(Collections.frequency(stringToDuplicated.get(check),1) > 1 ){
                //중복 체크된 닉네임의 이메일 주소를 duplicatedEmails에 저장한다.
                for (int i=0;i < stringToDuplicated.get(check).size(); i++ ){
                    if(stringToDuplicated.get(check).get(i) == 1 ) {
                        duplicatedEmails.add(forms.get(i).get(0));
                    }
                }
            }
        }

        //answer에 담아서 리턴
        List<String> answer = new ArrayList<>(duplicatedEmails);

        return answer;
    }

    //2개 이상의 단어로 분리한 닉네임들과 각 단어마다 어디서 사용되었는지를 표시하는 List Mapping한 변수를 반환
    public static Map<String, List<Integer>> makeDuplicatedMap(List<List<String>> forms) {
        Map<String, List<Integer>> duplicateCheckList = new HashMap<>();

        Set<String> divideNickNameSet = makedivideNickNameSet(forms);

        for (String duplicateNickNameCheck : divideNickNameSet){
            duplicateCheckList.put(duplicateNickNameCheck,findWhereNickNameUsed(duplicateNickNameCheck,forms));
        }

        return duplicateCheckList;
    }

    //중복을 제거하기 위해 Set 사용
    //하나의 닉네임에서 2개 이상의 단어로 분리할 수 있는 모든 경우를 반환
    public static Set<String> divideNickName(String nickName) {
        Set<String> divideList = new HashSet<>();

        for (int nickNameStartIdx = 0; nickNameStartIdx < nickName.length(); nickNameStartIdx++) {
            for (int nickNameEndIdx = nickName.length(); nickNameEndIdx > nickNameStartIdx + 1; nickNameEndIdx--) {
                divideList.add(nickName.substring(nickNameStartIdx, nickNameEndIdx));
            }
        }

        return divideList;
    }

    // forms에 있는 모든 닉네임들에 대해 2개 이상의 단어로 분리할 수 있는 모든 경우를 반환
    public static Set<String> makedivideNickNameSet(List<List<String>> forms) {
        Set<String> divideNickNameSet = new HashSet<String>();

        for (int formIdx = 0; formIdx < forms.size(); formIdx++) {
            divideNickNameSet.addAll(divideNickName(forms.get(formIdx).get(1)));
        }

        return divideNickNameSet;
    }

    // 분리된 단어가 어디에서 사용되었는지 알려주는 List를 반환
    public static List<Integer> findWhereNickNameUsed(String duplicateNickNameCheck,List<List<String>> forms){
        List<Integer> checkList = new ArrayList<Integer>();

        for(int formsIndex = 0;formsIndex<forms.size();formsIndex++){
            if (forms.get(formsIndex).get(1).contains(duplicateNickNameCheck) == true ){
                checkList.add(1);
            }
            else{
                checkList.add(0);
            }
        }

        return checkList;
    }

}
