package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2_re {

    public static void main(String[] args){
        String input ="browoanoommnaon";
        String input2 = "zyelleyz";

        System.out.println(solution(input));
    }

    public static String solution(String cryptogram) {
        List<String> list = new ArrayList<String>();
        list = changeStringToList(cryptogram);
        int size = list.size();
        while(true){
            findDuplication(list);
            if (list.size() == size) {
                break;
            }
            size = list.size();
        }
        return changeListToString(list);
    }

    //문자열을 arrayList로 변환
    public static ArrayList<String> changeStringToList(String input){
        return new ArrayList<String>(Arrays.asList(input.split("")));
    }

    //ArrayList를 문자열로 변환
    public static String changeListToString(List<String> list){
        return list.toString();
    }

    // 중복되는 부분의 인덱스를 찾는 메서드
    public static void findDuplication(List<String> list){
        int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i).equals(list.get(i+1))){
                startIdx = i;
                endIdx = findEndIdx(startIdx,list);
                list = deleteString(startIdx,endIdx,list);
                i -= 1;
            }
        }
    }

    //endIdx 찾기
    public static int findEndIdx(int startIdx, List<String> list){
        int cnt = 0;
        for (int i = startIdx + 1; i< list.size()-1; i++){
            if (list.get(i).equals(list.get(i+1))){
                cnt +=1;
                continue;
            }
            break;
        }
        return startIdx + 1 +cnt;
    }

    // 중복을 찾는 메서드 구현
    public static List<String> deleteString(int startIdx, int endIdx, List<String> list) {
        list.subList(startIdx, endIdx+1).clear();
        return list;
    }




}
