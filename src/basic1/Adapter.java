package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    5. Adapter 패턴
    Adapter: 형식이 다른 둘 사이를 연결해서 호환될 수 있게 하는 것

    Adapter패턴 : I/F가 서로 다른 객체들이 같은 형식 아래 작동할 수 있게 하는 역할

    영상의 쉬운 비유에 의하면 I/F가 어떤 기능을 하게 해주는 자격증이라면
    '요리'를 하는 요리자격증(I/F)와 '제과`를 하는 제과자격증(I/F)이 있을 때
    요리사(요리I/F구현객체)가 다수 있는 양식점에서 디저트를 위해 파티시에(제과I/F구현객체)를 고용했고
    요리하란 명령으로 요리사가 요리하는 것 뿐 아니라 파티시에가 알아서 '요리란 명령으로 제과를' 실행하게 하기 위함 >> 명령 하나로 다 처림

    실질적인 예로
    Command나 Strategy 패턴 등에서 검색 모드에 새로운 모드를 추가했는데
    이 모드의 모듈이 다른 API에서 가져온 거라 I/F가 달라 같은 search() 메서드의 이름이나 방식이 아예 달라 실행이 되지 않을 경우
    
 */

interface SearchStrategy_adapter {
    public void search();
}

interface FindAlgorithm {
    public void find(boolean global);
}

class FindMovieAlgorithm implements FindAlgorithm {
    @Override
    public void find(boolean global) {
        System.out.println(global);
    }
}

class SearchFindAdapter implements SearchStrategy_adapter {
    private FindAlgorithm findAlgorithm;

    public SearchFindAdapter (FindAlgorithm findAlgorithm) {
        this.findAlgorithm = findAlgorithm;
    }

    public void search() {
        findAlgorithm.find(true);
    }
}


public class Adapter {
}
