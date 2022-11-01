package onboarding;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String[] result = OverlappedNickname(forms);
        answer = Arrays.asList(result);
        for(String i : result){
            System.out.println(i);
        }
        return answer;
    }

    public static String[] OverlappedNickname(List<List<String>> forms) {
        String[] address = new String[forms.size()];
        String[] nickname = new String[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            address[i] = forms.get(i).get(0); // 이메일 주소만 분리
            nickname[i] = forms.get(i).get(1); // 닉네임만 분리
        }

        int[] overlappedIndex = CompareNickname(nickname);
        int indexSize = overlappedIndex.length;
        String[] checkedAddress = new String[indexSize];
        for(int i = 0; i < indexSize; i++){
            checkedAddress[i] = address[overlappedIndex[i]];
        }
        Arrays.sort(checkedAddress);
        return checkedAddress;
    }

    /**
     * 닉네임들을 하나씩 비교해서 중복된 닉네임이 있을경우 배열 번호를 저장
     * @param nickname 닉네임 배열
     * @return 닉네임 번호가 담긴 배열
     */
    public static int[] CompareNickname(String[] nickname) {
        LinkedHashSet<Integer> index = new LinkedHashSet<>(); // 중복된 닉네임들의 위치를 담을 공간.

        for (int i = 0; i < nickname.length; i++) {
            for (int j = i + 1; j < nickname.length; j++) {
                char[] iArray = nickname[i].toCharArray();
                char[] jArray = nickname[j].toCharArray();
                if (CheckNicknameOverlap(iArray, jArray)) {
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
     * 두 닉네임 안에서 연속으로 중복되는 문자가 있는지 검사
     * @param iArray 비교 닉네임 1
     * @param jArray 비교 닉네임 2
     * @return 연속된 닉네임이 있으면 true, 없으면 false
     */
    public static boolean CheckNicknameOverlap(char[] iArray, char[] jArray){
        for(int i = 0; i < iArray.length-1; i++){
            for(int j = 0; j < jArray.length-1; j++){
                if(iArray[i] == jArray[j] && iArray[i+1] == jArray[j+1]) {
                    System.out.println(iArray[i] + iArray[i+1]);
                    return true;
                }
            }
        }
        return false;
    }
}
