package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    7. Facade (외벽)
    여러 클래스의 객체들을 복합적으로 사용해야하는 작업에 대해
    예를 들어 자신의 주소를 출력하는 과정에 위치좌표 얻어오기 / 인터넷 연결 / 받은 데이터 변환 이런 각 객체의 메소드가 필요한데
    이 작업들이 여러곳에서 이뤄진다면 이들을 한 객체의 메소드로 묶어서 필요할 때마다 사용

    상당히 객체지향적으로 자연스럽게 사용되는 패턴

    작업을 실행하는 사용자 측에서 복잡한 연결관계를 facade(외벽) 숨기거나 정리가 가능함

 */

import java.util.Map;

class Location {
    public void getLocation() {}
}

class Connection {
    public void getConnection() {}
    public void getData() {}
    public void disConnect() {}
}

class ChangeData {
    public void parse() {}
}

class MakeFacade {
    public void printMyAddress() {
        Location loc = new Location();
        Connection conn = new Connection();
        ChangeData cd = new ChangeData();

        loc.getLocation();
        conn.getConnection();
        conn.getData();
        conn.disConnect();
        cd.parse();
    }
}

public class Facade {
    public void facade_ex () {
        MakeFacade facade = new MakeFacade();

        facade.printMyAddress();
        //...
        facade.printMyAddress();
        //...
    }
}
