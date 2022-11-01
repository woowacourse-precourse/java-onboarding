package onboarding;

import java.util.*;


/*
* 약어
* sn : Substring Name(이름의 부분 문자열)
* */
public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        Calculator<List<List<String>>, List<String>> crewCalculator
                = new CrewCalculator();
        crewCalculator.setVariable(forms);

        return crewCalculator.calculation();
    }

    public enum Crew{
        EMAIL(0), NAME(1);

        private int info;

        Crew(int lo) {
            this.info = lo;
        }

        public int getInfo() {
            return info;
        }
    }

    public static class CrewCalculator implements Calculator<List<List<String>>, List<String>>{
        private List<List<String>> forms;
        private static final int REPEAT = 2;
        private static List<List<String>> snList = new ArrayList<>();

        @Override
        public void setVariable(List<List<String>> forms) {
            this.forms = forms;
        }

        @Override
        public List<String> calculation(){
            List<String> answer = new ArrayList<>();
            Map<String, Integer> snAndCountMap = new HashMap<>();
            snList = new ArrayList<>();

            makeSnList(forms);
            makeCount(snAndCountMap);
            makeAnswer(forms, snAndCountMap, answer);

            Collections.sort(answer);

            return answer;
        }

        private static String getInfo(List<String> form, Crew crew){
            return form.get(crew.getInfo());
        }

        /*
         * 이름에서 두 자리 이상의 부분 문자열을 구해 리스트로 반환한다.
         * */
        private static List<String> subName(String name) {
            List<String> sub = new ArrayList<>();
            int n = name.length();
            for (int i = REPEAT; i <= n; i++) { // 크기
                for (int j = 0; i + j <= n; j++) { // 위치
                    isSizeTwoOrMore(name, i, j, sub);
                }
            }
            return sub;
        }

        /*
        * 크기가 REPEAT보다 큰 부분 문자열을 추가한다.
        * */
        private static void isSizeTwoOrMore(String name, int i, int j, List<String> sub){
            if(name.length()-j >= REPEAT){
                sub.add(name.substring(j, i + j));
            }
        }

        /*
         * 각 이름에서 부분 문자열을 구한다.
         * */
        private static void makeSnList(List<List<String>> forms){
            for (List<String> form : forms) {
                String name = getInfo(form, Crew.NAME);
                snList.add(subName(name));
            }
        }

        /*
         * 구해진 부분 문자열로 개수를 센다.
         * */
        private static void makeCount(Map<String, Integer> snAndCountMap){
            for (List<String> strings : snList) {
                partition(strings, snAndCountMap);
            }
        }

        /*
        * 부분 문자열의 개수를 Map에 저장한다.
        * */
        private static void partition(List<String> strings,
                                      Map<String, Integer> snAndCountMap){
            for (String par : strings) {
                snAndCountMap.put(par, snAndCountMap.getOrDefault(par, 0) + 1);
            }
        }

        /*
         * 부분 문자열의 길이가 2 이상일 경우 정답에 추가한다.
         * */
        private static void makeAnswer(List<List<String>> forms,
                                       Map<String, Integer> snAndCountMap,
                                       List<String> answer){

            Person : for (int i = 0; i < snList.size(); i++) {
                for (int j = 0; j < snList.get(i).size(); j++) {
                    int val = snAndCountMap.get(snList.get(i).get(j));
                    if (val >= REPEAT) {
                        String email = getInfo(forms.get(i), Crew.EMAIL);
                        answer.add(email);
                        continue Person;
                    }
                }
            }
        }
    }
}
