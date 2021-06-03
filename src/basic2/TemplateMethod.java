package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    8. TemplateMethod
    어떤 같은 형식(공통된 작업과정)을 지닌 특정 작업들에 세부방식을 다양화할때

    예를 들어 과일일음료 조에서
    작업1(과일선택) > 작업2(부가물넣고 갈기) > 작업3(토핑) > 결과(음료)에서
    각 과정의 세부 (딸기,망고 등 선택) > (시럽, 잼 넣기) > (민트 잎, 과일조각) 등에 따라 다양한 종류가 만들어지게 함

    Strategy가 각 방식들에 각각의 모듈을 만들었다면
    TemplateMethod는 기본 과정을 정리한 기본토대에서 각 방식을 오버라이딩하는 방식

    객체지향의 단순한 상속? > 일정 형식이 있는 패턴임
    부모클래스에서 전반과정을 수행하는 main메서드가 있고 그 과정 가운데 호출되는 세부메서드가 있음
    자식에서는 이 세부 메서드를 오버라이딩 해서 규격화 / 전반 과정(작업1>2>3)은 바꿀 수 없음

 */
abstract class MapView {
    abstract void connectMapServer();
    abstract void showMap();
    abstract void moveToLocation();

    public void intiMap() {
        connectMapServer();
        showMap();
        moveToLocation();
    }
}

class KakaoMap extends MapView {

    @Override
    void connectMapServer() {
    }
    @Override
    void showMap() {
    }
    @Override
    void moveToLocation() {
    }
}

class NaverMap extends MapView {
    @Override
    void connectMapServer() {
    }
    @Override
    void showMap() {
    }
    @Override
    void moveToLocation() {
    }

}

public class TemplateMethod {
    public void template_ex() {
        new NaverMap().intiMap();
        new KakaoMap().intiMap();
    }
}
