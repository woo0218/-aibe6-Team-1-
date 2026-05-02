### 🧪 테스트 기반 IoC 컨테이너 구현

다음과 같은 테스트 케이스를 기준으로 IoC 컨테이너를 단계적으로 구현했습니다.

#### ✅ 구현 목표

- ApplicationContext 객체 생성
- beanName 기반 빈 조회 기능 구현
- 싱글톤 패턴 보장
- 생성자 기반 의존성 주입(DI) 구현

#### 🔍 테스트 체크리스트

- [x] ApplicationContext 객체 생성 확인
- [x] testPostService 빈 생성 여부 확인
- [x] testPostService 싱글톤 검증
- [x] testPostRepository 빈 생성 여부 확인
- [x] testPostService → testPostRepository 의존성 주입 여부 확인
- [x] testFacadePostService → testPostService, testPostRepository 의존성 주입 여부 확인

#### 💡 구현 과정

초기에는 if문을 사용하여 beanName에 따라 객체를 반환하는 방식으로 구현했습니다.  
이후 확장성을 고려하여 Map을 활용한 빈 관리 구조로 개선하였고,  
생성자 기반 의존성 주입을 통해 객체 간 결합도를 낮추는 구조로 발전시켰습니다.

이를 통해 IoC(Inversion of Control)와 DI(Dependency Injection)의 핵심 개념을 직접 구현하며 이해할 수 있었습니다.