package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        String alpha = "abcdefghijklmnopqrstuvwxyz";

//      알파벳 소문자 정순 + 알파벳 대문자 정순 + 공백 으로 구성된 배열을 생성
        String[] arr1 = alpha.split("");
        String[] arr2 = (alpha.toUpperCase()).split("");
        String[] arr = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(String[]::new);
        String[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = " ";

//      알파벳 소문자 역순 + 알파벳 대문자 역순 + 공백 으로 구성된 배열을 생성
        List<String> list1 = Arrays.asList(arr1);
        Collections.reverse(list1);
        String[] arr1_rev = list1.toArray(arr1);
        List<String> list2 = Arrays.asList(arr2);
        Collections.reverse(list2);
        String[] arr2_rev = list2.toArray(arr2);
        String[] arr_rev = Stream.concat(Arrays.stream(arr1_rev), Arrays.stream(arr2_rev)).toArray(String[]::new);
        String[] newArr_rev = Arrays.copyOf(arr_rev, arr_rev.length + 1);
        newArr_rev[arr_rev.length] = " ";

//      입력값을 한 자리로 나눠 배열에 저장
        String[] wordList = word.split("");

//      입력값 배열의 각 원소를 정순 배열의 몇 번째 index인지 구하고 역순 배열의 해당 index로 치환.
        for(int i=0;i<wordList.length;i++){
            wordList[i] = newArr_rev[Arrays.asList(newArr).indexOf(wordList[i])];
        }

//      배열을 문자열로 변환
        answer = String.join("",wordList);
        return answer;
    }
}
