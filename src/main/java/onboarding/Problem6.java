package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<List<String>> test = new ArrayList<>();
        List<String> real = new ArrayList<>();
        List<String> email = new ArrayList<>();
        LinkedHashSet<String> realSet = new LinkedHashSet<>(); /** 순서를 보장해주는 LinedHashSet*/
        LinkedHashSet<String> realSet2 = new LinkedHashSet<>();


        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length(); j++) {
//                System.out.println("forms.get(i) = " + forms.get(i).get(1).substring(j,j+2) + forms.get(i));
                real.add(forms.get(i).get(1).substring(j, j + 2) + forms.get(i));
                if (j + 2 == forms.get(i).get(1).length()) {
                    break;
                }
            }
        }

        for (int i = 0; i < real.size(); i++) {
            for (int j = i + 1; j < real.size(); j++) {
//                System.out.println("real.get(i).substring(0,2) = " + real.get(j).substring(0,2));
                if (real.get(i).substring(2).equals(real.get(j).substring(2))) {
                    continue;
                    /** 0번 index, 1번 index를 쪼개서 만들었기 때문에 이메일과 풀네임이 같으면 뛰어넘는 거임.*/
                }
//                System.out.println("real.get(i) = " + real.get(i));
//                System.out.println("real.get(j)!! = " + real.get(j));
                if (real.get(i).substring(0, 2).equals(real.get(j).substring(0, 2)) &&
                    !real.get(i).substring(2).equals(real.get(j).substring(2))) {
                    realSet.add(real.get(i));
                    realSet.add(real.get(j));
                    realSet2.add(real.get(i));
                    realSet2.add(real.get(j));
//                    System.out.println("real.get(i) = " + real.get(i));
                    System.out.println("최종값 j = " + real.get(j));
                    System.out.println("최종값 i = " + real.get(i));
                }
            }
        }

        Iterator<String> it = realSet.iterator();
        Iterator<String> it2 = realSet2.iterator();
//        int[] indexCheck = new int[realSet.size()];
        int indexCheck = 0;
//        while ((it.hasNext())) {
//            indexCheck[i] = it.next().indexOf(",");
//        }
        for (int i = 0; i < realSet.size(); i++) {
            indexCheck = it.next().indexOf(",");
            System.out.println("indexCheck = " + indexCheck);

            email.add(it2.next().substring(3, indexCheck));
        }
        Collections.sort(email);
        /**
         * 내가 유효성 검사를 꼼꼼하게 못했다.
         * 앞, 뒤 모두 똑같이 중복되는 상황에서는 이메일이 계속 충복해서 나온다.
         * 더 세세하게 신경썼어야 됨.
         * 최종값 j = ㅡ이[nam@email.com, ㅡ이야]
         * 최종값 i = ㅡ이[kim@email.com, 김ㅡ이]
         * 최종값 j = ㅡ이[jun@email.com, 왜ㅇㅡ이야]
         * 최종값 i = ㅡ이[kim@email.com, 김ㅡ이]
         * 최종값 j = ㅡ이[jun@email.com, 왜ㅇㅡ이야]
         * 최종값 i = ㅡ이[nam@email.com, ㅡ이야]
         * 최종값 j = 이야[jun@email.com, 왜ㅇㅡ이야]
         * 최종값 i = 이야[nam@email.com, ㅡ이야]
         */
        for (int i = 0; i < email.size(); i++) {
            System.out.println("최종 이메일 값 = " + email.get(i));
        }

        for (int i = 0; i < email.size(); i++) {
            if(!answer.contains(email.get(i))) { /** 중복 검사 하는 부분임 */
                answer.add(email.get(i));
            }
        }


        return answer;
    }
}
