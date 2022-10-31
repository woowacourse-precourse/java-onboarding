package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 생각 놓고 풀었더니 풀렸다
 * 다시 풀기
 * 4중 for문 줄이기
 * 예외 처리 생각하기
*/

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> arr = new ArrayList<>(); // 중복된 아이디들 모아 놓은 곳

        for(int i = 0; i < forms.size(); i++){
            for(int j = i + 1; j < forms.size() - i; j++){
                if(isCheck(forms.get(i).get(1), forms.get(j).get(1))){
                    arr.add(forms.get(i).get(0));
                    arr.add(forms.get(j).get(0));
//                    System.out.println("arr : " + arr);
                }
            }
        }
        return arr.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isCheck(String nickname_1, String nickname_2){
        List<String> check = new ArrayList<>();
        for(int i = 0; i < nickname_1.length()-1; i++){
            check.add(nickname_1.substring(i, i+2));
            for(int j = 0; j < nickname_2.length()-1; j++){
//                System.out.println("check.get(i) : " + check.get(i) + " nickname_2.substring(j, j + 1)" + nickname_2.charAt(j) + nickname_2.charAt(j+1));
                if(Objects.equals(check.get(i), nickname_2.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;

    }
}
