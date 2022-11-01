### 🚀 기능 목록

####  problem3 - solution()
[요구] 숫자 endNumber가 매개변수로 주어질 때, 1부터 endNumber까지 손뼉을 몇 번 쳐야 하는지 횟수를 return
- getGameResult(): 1부터 endNumber까지 손뼉 치는 횟수 구하는 메서드
    - int result: 1부터 endNumber까지 손뼉 치는 횟수 저장
    - for (int number=1;number<=endNumber;number++):
        - getClapCount(): number에 3,6,9가 들어갈 때 3,6,9의 개수를 구하는 메서드
            - int cnt: 3,6,9의 개수를 저장한다.
            - for(String s : String.valueOf(number).split(""))
                - String s: 숫자의 한 자릿수
                - if (criteriaList.contains(s))
                    - criteriaList의 요소는 3, 6, 9
                    - s에 3, 6, 9 중 하나가 포함되어 있으면 cnt를 1 증가시킨다.
            - cnt를 리턴
        - result에 getClapCount()가 리턴한 cnt를 더한다.
    - result를 리턴