# java-racingcar-precourse(자동차 경주)

***

## ⭐️ 핵심 기능

### 📌 입력 기능

- [x] 경주할 자동차 이름 입력 기능
- [x] 시도할 횟수 입력 기능

### 📌 자동차 전진 기능

- [x] 0에서 9 사이의 무작위 값이 4 이상인 경우 전진한다.
- [x] 그렇지 않으면 전진하지 않는다.

### 📌 우승자 결정 기능

- [x] 주어진 횟수 동안 자동차 경주 게임을 완료한 후 우승자를 결정한다.
- [x] 우승자는 한 명 이상일 수 있다.

### 📌 출력 기능

- 차수별 실행 결과 출력 기능
    - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 우승자 안내 문구
    - [x] 단독 우승자 안내 문구
    - [x] 공동 우승자 안내 문구
        - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

### 📌 예외 처리 기능

- 경주할 자동차 이름 입력 시
    - [x] 값을 입력하지 않은 경우
    - [x] 5자를 초과한 경우
    - [x] 이름에 중복이 있는 경우
    - [x] 자동차가 10대 초과인 경우
    - [x] 구분자가 잘못 입력된 경우

- 시도할 횟수 입력 시
    - [x] 값을 입력하지 않은 경우
    - [x] 1 이상 10 이하의 정수가 아닌 경우


- [x] 잘못된 값 입력 시 "[ERROR]"로 시작하는 에러 메시지 출력 후 애플리케이션 종료

***

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [x] JDK-21 사용
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`
- [x] `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [x] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [x] 프로그램 종료 시`System.exit()`를 호출 X
- [x] 프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현(2까지만 허용)
- [x] 3항 연산자 사용 X
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인
- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현
- [x] else 예약어 사용 X
- [x] Java Enum을 적용하여 프로그램을 구현
- [x] 구현한 기능에 대한 단위 테스트를 작성(단, UI(System.out, System.in, Scanner) 로직은 제외)
- [x] 입출력을 담당하는 클래스를 별도로 구현

### 라이브러리 요구 사항

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
    - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용