## 문제1번 기능구현사항 정리

핵심 구현 idea : 자릿수 합을 구해주는 sum, 곱을 구해주는 mult, 두개의 메서드에 임무를 위임해주는 admin 메서드 구현을 통해서 최대한 코드 중복없이 구현

필수 구현 기능 목록 : sum, mult, admin

### 구현 메소드 명세

admin : 들어온 입력값을 char 배열로 바꿔서 sum, mult에 각자 역할에 위임

sum : 들어온 char배열을 각 자릿수의 합을 return

mult : 들어온 char배열을 각 자릿수의 곱을 return