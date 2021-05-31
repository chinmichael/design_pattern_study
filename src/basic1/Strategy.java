package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    1. Strategy 패턴
    예를 들어 검색조건을 설정하고 + 검색어를 입력해 검사하는 프로그램의 경우
    즉 프로그램 실행 중 모드가 변경될 때마다 처리방식(전략)이 수정되는 경우

    패턴없이 각 모드에 따라 다른 메소드가 실행하게 되는 경우 재사용성과 유지보수성이 떨어짐
    >> 기능이 바뀌어 코드 수정하거나 기능 추가 등등의 상황에 대해

    Strategy 패턴에서는 모드마다 각각의 동작을 모듈화하여 객체지향 방식에 맞춘 것임
    >> by I/F와 구현 클래스를 통하여
    
    모드에 대해 모듈화를 진행해 한 객체의 행위가 아닌 각 객체의 행위로 만듦
    >> 모드(행위)의 검색(행위)가 아니라 모드(객체)의 검색(행위)가 되게 객체지향적으로
 */

interface SearchStrategy { // I/F : 기능 정의 >> 정의된 기능의 실질적인 구현은 implements한 클래스
    public void search();
}

class SearchStrategyAll implements SearchStrategy {
    @Override
    public void search() {
        //...
    }
}

class SearchStrategyImage implements SearchStrategy {
    @Override
    public void search() {
        //...
    }
}

public class Strategy {

    //일단 초기화는 객체가 필요하므로 디폴트 모드가 되는 구현클래스로 초기화
    //이때 객체 타입을 각 구현 클래스 타입이 아닌 I/F타입이 되어 중개지점이 되게 함 >> set메서드로 모드에 맞는 구현 클래스로 변경
    private SearchStrategy strategy = new SearchStrategyAll();
    public void setStrategy (SearchStrategy searchStrategy) {
        strategy = searchStrategy;
    }
    
    // 결정된 모드의 모듈로 I/F에서 정의한 공통 기능 사용
    public void onClick() {
        strategy.search();
    }
}
