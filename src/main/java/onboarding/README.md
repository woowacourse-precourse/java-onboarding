📮 Precource Assignments(1 week)
===

# [문제 1](../../../../docs/PROBLEM1.md)
> [Code(click)](./Problem1.java)

> ### 기능 구현
>  - [x] 입력 값에 예외가 발생하는 경우, false를 반환하는 isCorrect 메서드 구현
>    - [오른쪽 페이지]가 [왼쪽 페이지+1] 이 아닐 경우
>    - [오른쪽 페이지]가 400보다 크거나, [왼쪽페이지]가 1보다 작을 경우
> - [x] 각각의 펼쳐진 페이지에 대해, 페이지 자릿수 [합계]를 반환하는 digitSum 메서드 구현
> - [x] 각각의 펼쳐진 페이지에 대해, 페이지 자릿수 [곱]을 반환하는 digitProduct 메서드 구현
> - [x] 플레이어의 점수 계산을 수행하는 score 메서드 구현



# [문제 2](../../../../docs/PROBLEM2.md)
>[Code(click)](./Problem2.java)

> ### 기능 구현 
> - [x] 단계 별, 연속중복된 문자를 제거하는 process 메서드 구현
>   - 해당 메서드 내에서 Stack 구조 및 StringBuilder를 사용
>   - 문자열에서 문자를 순서대로 읽고, Stack이 빈 경우(초기), Stack에 push
>   - 다음 문자가 들어올 때, 이 문자가 Stack의 최상단에 존재하는 문자와 동일할 경우, Stack에 push
>   - 만일, Stack 최상단 문자와 동일하지 않을 경우, 
>     - Stack 크기가 1일 때(중복 문자 아님을 의미), Stack pop하여 이를 StringBuilder에 추가 & 해당 문자 Stack에 push
>     - Stack 크기가 1이 아닐때(중복 문자 존재함을 의미), Stack 초기화 후, 해당 문자 Stack에 push 
>   - 연속중복문자를 제거한 String을 반환
> - [x] solution 메서드 에서는 [중복문자제거 전] 문자열과 [중복문자제거 후] 문자열을 비교. 두 문자열이 동일할 경우, 더이상 중복된 문자가 존재하지 않음을 의미. 매 단계의 수행은 while문을 이용.

> ### 예외 발생에 대한 고려
> - 길이가 1인 문자열이 입력될 경우
>   - [x] 검증 완료
> - 모든 문자열이 동일한 문자로 이루어질 경우
>   - [x] 검증 완료 


# [문제 3](../../../../docs/PROBLEM3.md)
>[Code(click)](./Problem3.java)

> ### 기능 구현
> - [x] 하나의 숫자가 3,6,9를 포함 시, 손뼉을 쳐야 하는 갯수를 반환하는 clapCount 메서드 구현
> - [x] solution 메서드에서는 입력된 n에 대하여, 1~n까지 손뼉을 치는 모든 횟수를 반환


# [문제 4](../../../../docs/PROBLEM4.md)
>[Code(click)](./Problem4.java)

> ### 기능 구현
>  - [x] 읽은 문자가 알파벳문자인지 판별
>  - [x] 청개구리 사전에 맞는 문자로 변환


# [문제 5](../../../../docs/PROBLEM5.md)
>[Code(click)](./Problem5.java)

> ### 기능 구현
>  - [x] 화페 단위를 저장하고 있는 배열 생성
>  - [x] 화폐단위 배열을 통해, 화폐단위가 큰 순서대로, 필요한 화폐단위의 갯수를 정답List에 추가