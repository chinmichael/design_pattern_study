package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    1. Singleton 패턴
    SW에서 어떤 객체가 프로세스에서 단 한개만 만들어져야 할때 사용
    예를 들어 세팅 페이지에서 다크모드 설정시 다른 페이지로 넘어가도 다크모드 유지

    하단과 같이 기본적인 세팅만 하는 경우 멀티쓰레드 환경에서 오류가 발생할 수 있기에
    각 언어마다 보완할 코드를 추가하는 것이 좋음
 */


public class Singleton {

    // 예전에 DBMS 연결할 때 자주 썼었는데 좀 여러모로 까먹었었네...ㅠ
    // 1. private로 다른 객체에서 생성자를 사용하는 것을 막음
    // 2. static(정적)으로 컴파일 시 객체가 상주할 메모리(용량) 지정 >> 모든 객체에서 공통 접근
    // 3. 다른 객체에서 singleton 객체 초기화에 관련되지 못하게 하기 위해 private처리 후 getInstance()로만 접근 가능하게 함
    private Singleton() {}
    private static Singleton singleton = null;
    public static Singleton getInstance() {
        if(singleton == null) { // 어떤 객체에서 이미 getInstance()를 호출해 객체가 생성되어 있다면 이미 메모리에 존재하는 singleton 객체 반환
            singleton = new Singleton();
        }
        return singleton;
    }

    private boolean darkMode = false;
    private int fontSize = 13;

    public boolean getDarkMode() { return darkMode; }
    public int getFontSize() { return fontSize; }

    public void setDarkMode (boolean darkMode) { this.darkMode = darkMode; }
    public void setFontSize (int fontSize) { this.fontSize = fontSize; }
}

class Page1 {

    // 페이지마다 세팅 객체가 새로 생성되어 각각 다르게 적용됨
    //private Singleton setting = new Singleton();

    // 이와 같이 처리함으로서 Page1과 Page2에서 같은 singleton(setting) 객체에 접근한다.
    private Singleton settings = Singleton.getInstance();
}

class Page2 {

    //private Singleton setting = new Singleton();
    private Singleton settings = Singleton.getInstance();
}
