package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
 * List(add, get, size, contains,remove)
 * StringTokenizer(hasMoreTokens(),nextToken()) = 문자열 파싱, 구분자, 토큰화
 * 1, 받은 문자열을 배열화 시킨다
 *  - 중간의 삽입 삭제가 편한 리스트 고려
 * 2, 중복 문자 찾기
 */
public class Problem2 {
    // public static String cryptogram = "browoanoommnaon";
    public static String solution(String cryptogram) {
        String answer = "";
        String[] answer2 = cryptogram.split("");
        List<String> list = new ArrayList<>();
        for(int i = 0; i <answer2.length;i++){
            list.add(answer2[i]);
            }

        for(int j = 0; j < list.size()-1;j++){
            if(list.get(j).equals(list.get(j+1))){
                list.remove(j+1);
                list.remove(j);
                j = 0;
            }
        }

        if ((list.get(0).equals(list.get(1)) && list.size() == 2)){
            list.remove(1);
            list.remove(0);
        }
        for(String s : list){
            answer += s;
        }
        return answer;
    }
    // public static void main(String[] args){
    //     String answer = "zyelleyz";
    //     String[] answer2 = answer.split("");
    //     int count = 0;
    //     List<String> list = new ArrayList<>();
    //     for(int i = 0; i <answer2.length;i++){
    //         list.add(answer2[i]);
    //         }
    //     for(int j = 0; j < list.size()-1;j++){
    //         if(list.get(j).equals(list.get(j+1))){
    //             list.remove(j+1);
    //             list.remove(j);
    //             count += 1;
    //             j = 0;
    //         }
    //     }
    //     System.out.print(list);
    //     System.out.print(count);
        // String[] answer_split = answer.split("");
        // LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        // for(String item : answer_split){
        //     System.out.println(linkedHashSet);
        //     linkedHashSet.add(item); 
        // }

        // String[] strArr = answer.split("");
        // for(int i = 0; i < strArr.length - 1;i++){
        //     if(strArr[i] == strArr[i + 1]){
        //         System.out.print("동일문자 존재");
        //     }
        // }
        // System.out.println(Arrays.toString(strArr));
}