package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 기능 요구사항
 * 1. 크루들의 닉네임 중 같은 글자가 연속적으로 포함될 경우 닉네임 사용을 제한해야 한다.
 * 2. 닉네임 사용을 제한당한 크루들의 이메일을 오름차순으로 정렬해야 한다.
 */
public class Problem6 {
    static boolean[] c;
    // 같은 글자가 연속적으로 포함된 크루원일 경우 체크해주고, 1번 반복문을 continue 할 수 있게 만드는 boolean 값

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        c = new boolean[forms.size()];
        limitDuplication(forms, answer);
        Collections.sort(answer);
        return answer;
    }

    private static void limitDuplication(List<List<String>> forms, List<String> answer) {
        for(int i = 0; i< forms.size(); i++){ // 1번 반복문 : 한 단위의 크루원들을 추출하기 위해
            if(c[i]) continue;
            List<String> str = forms.get(i);
            String nickName = str.get(1); // 닉네임을 추출한다

            for(int j=0;j<nickName.length();j++){ // 2번 반복문 : 닉네임을 `한 글자' 씩 넘겨주기 위해
                for(int k = i+1; k< forms.size(); k++){ // 3번 반복문 : 1번 반복문에서 한 단위의 크루원을 뺀 나머지 크루원을 추출하기 위해
                    int count = 0; // ex) 1번 크루원과 2번 크루원은 이미 규칙을 위반해서 answer 에 추가 되었고
                                   //    `1번 크루원과 3번 크루원`이 규칙에 위반되었을 때
                                   //     이미 1번 크루원은 answer 에 있게 되므로 41번 째 줄 if 문이 작동하지 않는다

                    String nickName2 = forms.get(k).get(1); // 나머지 크루의 닉네임
                    for(int z=0;z<nickName2.length();z++){ // 4번 반복문 : 3번 반복문에서 추출한 닉네임을 `한 글자'씩 넘겨준다
                        if(nickName.charAt(j)==nickName2.charAt(z)){ // 만약 같다면
                            if(j+1<nickName.length()&&z+1<nickName2.length()){ // 범위 안에서
                                if(nickName.charAt(j+1)==nickName2.charAt(z+1)){ // 뒤의 글자까지 같다면
                                    count++; // 규칙에 위반됨을 체크해주고
                                    if(!answer.contains(forms.get(i).get(0))){ // 41번째 if : answer 값에 들어가 있으면 if문 실행하지 않음
                                        // 중복이였을 때 두번째 for 문의 인덱스를 사용하여
                                        answer.add(forms.get(i).get(0)); // 1번 반복문의 닉네임을 "신청한 크루들에게 알려주는 부분"
                                        c[i] = true; // 규칙에 걸렸음을 체크 해놓으면 1번 반복문의 반복 횟수를 줄일 수 있다
                                    }
                                    break; // 규칙에 위반 됨을 확인 시 4번 반복문을 돌 필요가 없으므로
                                }
                            }
                        }
                    }
                    if(count>0){ //
                        answer.add(forms.get(k).get(0));
                        c[k] = true;
                    }
                }
            }

        }
    }

}
