package onboarding;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.HashSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] result = OverlappedNickname(forms);
        answer = Arrays.asList(result);
        return answer;
    }

    /**
     * 이메일 주소와 닉네임을 분리해서 검사 메소드들에 넘겨줌
     * @param forms 주어진 양식
     * @return 정렬된 이메일 주소
     */
    public static String[] OverlappedNickname(List<List<String>> forms) {
        String[] address = new String[forms.size()];
        String[] nickname = new String[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            address[i] = forms.get(i).get(0); // 이메일 주소만 분리
            nickname[i] = forms.get(i).get(1); // 닉네임만 분리
        }

        int[] overlappedIndex = CompareNickname(nickname); // 중복되는 닉네임이 있는 배열 번호를 받아옴
        int indexSize = overlappedIndex.length;
        HashSet<String> tempSet = new HashSet<>();
        for(int i = 0; i < indexSize; i ++){
            tempSet.add(address[overlappedIndex[i]]);
        }
        String[] checkedAddress = tempSet.toArray(new String[0]);
        Arrays.sort(checkedAddress); // 오름차순 정렬
        return checkedAddress;
    }

    /**
     * 닉네임들을 하나씩 비교해서 중복된 닉네임이 있을경우 배열 번호를 저장
     * @param nickname 닉네임 배열
     * @return 닉네임 번호가 담긴 배열
     */
    public static int[] CompareNickname(String[] nickname) {
        LinkedHashSet<Integer> index = new LinkedHashSet<>(); // 같은 글자가 연속적으로 포함되는 닉네임들의 위치를 담을 공간.

        for (int i = 0; i < nickname.length; i++) {
            for (int j = i + 1; j < nickname.length; j++) {
                char[] iArray = nickname[i].toCharArray();
                char[] jArray = nickname[j].toCharArray();
                if (CheckNicknameOverlap(iArray, jArray)) { // 두 닉네임을 비교해서 같은글자가 연속적으로 포함되는지 검사
                    index.add(i);
                    index.add(j);
                }
            }
        }

        Integer[] integerArray = index.toArray(new Integer[index.size()]); // Linked HashSet -> Integer 배열로 변환
        int[] indexArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray(); // int 배열로 변환
        return indexArray;
    }

    /**
     * 두 닉네임 안에서 연속으로 중복되는 문자가 있는지 검사. 두글자까지만 검사함
     * @param iArray 비교 닉네임 1
     * @param jArray 비교 닉네임 2
     * @return 연속된 닉네임이 있으면 true, 없으면 false
     */
    public static boolean CheckNicknameOverlap(char[] iArray, char[] jArray){
        for(int i = 0; i < iArray.length-1; i++){
            for(int j = 0; j < jArray.length-1; j++){
                if(iArray[i] == jArray[j] && iArray[i+1] == jArray[j+1]) { // 연속으로 두글자가 겹치는 경우
                    return true;
                }
            }
        }
        return false;
    }
}
