/**
 * 두 글자 이상의 연속된 문자열이 순서대로 포함되어 있는 경우 중복이다
 * -> 두 글자(순서)가 겹치면 중복이다.
 * -> create 메서드로 닉네임의 두 글자씩 잘라서 리스트에 저장해 놓는다.
 *
 * 이중 for문을 사용하여 한 멤버를 기준으로 다른 멤버들과 중복되는 닉네임이 있는지 검사한다.
 * -> compare 메서드를 사용하여 중복인지 아닌지 체크
 * -> solve를 통하여 전체 회원 대상으로 검토한다.
 *
 * 회원은 한 번만 정답 리스트에 들어가야 하므로 hashset을 사용하여 중복을 허용하지 않는다.
 */

package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        hashSet = solve(forms);

        answer.addAll(hashSet);

        return answer;
    }

    // 회원의 닉네임을 기준으로 검사할 수 있는 두 글자의 모든 경우를 리스트에 담는다.
    static ArrayList<String> create(String s){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length()-1; i++) {
            list.add(s.substring(i, i+2));
        }

        return list;
    }

    // 두 문자열로 나올 수 있는 두 개의 리스트를 비교해 겹치는 게 있다면 true를 반환한다.
    static boolean compare(String s, String t){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list1 = create(s);
        list2 = create(t);

        boolean flag = false;
        for(String tmp : list2){
            if(list1.contains(tmp)){
                flag = true;
                break;
            }
        }

        return flag;
    }

    // 이중 for문을 통하여 주어진 모든 회원들을 각각 조사하여 조건에 맞는 경우 hashset에 담는다.
    static HashSet<String> solve(List<List<String>> list){
        HashSet<String> hashSet = new HashSet<>();
        boolean[] visited = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(compare(list.get(i).get(1), list.get(j).get(1))
                    && visited[j] == false){
                    hashSet.add(list.get(i).get(0));
                    hashSet.add(list.get(j).get(0));
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }

        return hashSet;
    }
}
