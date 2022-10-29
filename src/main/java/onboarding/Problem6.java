package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    static class sequence {
        // 시퀀스의 가장 긴 공통 부분 문자열을 찾는 함수
        // `X[0…m-1]` 및 `Y[0…n-1]`
        public static String LCS(String X, String Y)
        {
            int m = X.length();
            int n = Y.length();
            int maxlen = 0;         // LCS의 최대 길이를 저장합니다.
            int endingIndex = m;    // LCS의 끝 인덱스를 `X`에 저장합니다.

            // `lookup[i][j]`는 하위 문자열의 LCS 길이를 저장합니다.
            // `X[0…i-1]`, `Y[0…j-1]`
            int[][] lookup = new int[m + 1][n + 1];

            // 룩업 테이블을 상향식으로 채움
            for (int i = 1; i <= m; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    // `X`와 `Y`의 현재 문자가 일치하는 경우
                    if (X.charAt(i - 1) == Y.charAt(j - 1))
                    {
                        lookup[i][j] = lookup[i - 1][j - 1] + 1;

                        // 최대 길이와 끝 인덱스 업데이트
                        if (lookup[i][j] > maxlen)
                        {
                            maxlen = lookup[i][j];
                            endingIndex = i;
                        }
                    }
                }
            }

            // 길이가 `maxlen`인 가장 긴 공통 부분 문자열을 반환합니다.
            return X.substring(endingIndex - maxlen, endingIndex);
        }

        // 전체 닉네임에서 공통 부분을 찾아내는 함수
        public static String findCommon(List<String> s){
            String answer = "";
            for (int i = 0; i < s.size(); i++){
                for (int j = i+1; j < s.size(); j++){
                    String common = LCS(s.get(i),s.get(j));
                    if ( common.length() >= 2){
                        answer = common;
                    }
                }
            }
            return answer;
        }

        //공통 부분을 가진 닉네임의 Email
        public static List<String> makeResult(List<List<String>> forms, String common){
            List<String> answer = new ArrayList<>();
            for (List<String> people : forms){
                if (people.get(1).contains(common)){
                    answer.add(people.get(0));
                }
            }

            //중복제거, 오름차순 정렬
            List<String> delCommon = answer.stream().distinct().collect(Collectors.toList());
            delCommon.sort(Comparator.naturalOrder());
            return delCommon;
        }

        //닉네임만 추출
        public static List<String> makeList(List<List<String>> forms){
            List<String> answer = new ArrayList<>();
            for (List<String> s : forms){
                answer.add(s.get(1));
            }
            return answer;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> s = sequence.makeList(forms);
        String common = sequence.findCommon(s);
        List<String> answer = sequence.makeResult(forms,common);
        return answer;
    }
}
