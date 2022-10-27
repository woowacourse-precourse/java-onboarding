package onboarding;

public class Problem4 {
    public static String solution(String word) {
        mother = [A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z]
        son = [Z,Y,X,W,V,U,T,S,R,Q,P,O,N,M,L,K,J,I,H,G,F,E,D,C,B,A]
        String answer = "";
        answer_list = []
        for w in word:
            if Character.isUpperCase(w): // 만약 대문자면
                w_index = Arrays.asList(mother).indexOf(w)
                    answer_list.append(toUpperCase(son[w_index])) // 엄마 리스트 인덱스랑 같은 아들 리스트 인덱스 값 대문자로 넣어주기
            elif Character.isLowerCase(w): // 만약 소문자면
                w_index = Arrays.asList(mother).indexOf(w)
                    answer_list.append(toLowerCase(son[w_index])) // 엄마 리스트 인덱스랑 같은 아들 리스트 인덱스 값 소문자로 넣어주기
            else:
                answer_list.append(" ")
            answer = sum(answer_list) //리스트 안의 문자열을 다 더해서 하나의 문장으로 만들기
        return answer;
    }
}
