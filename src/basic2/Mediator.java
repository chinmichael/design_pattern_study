package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    11. Mediator

    어떤 클래스의 특정 이벤트가 발생할 때마다 연결된 다른 객체들에게 알려야할 때,
    이를 중재자 역할을 하는 클래스의 객체가 전담함

    예를 들어 앱에서 화면에 보이는 페이지를 변경할 때 기존 페이지는 감추고 새 페이지 화면에 해당 컴포넌트의 데이터를 받아옴
    각 페이지마다 위의 액션들을 전부 취해야하고 해당 모드에 관련된 객체가 추가될 때마다 복잡하게 늘어남

    ModeMediator를 중심으로 N(이벤트 Switch 등):N(추가로 이벤트를 알려줄 클래스) 관계가 형성
    여러 클래스의 관계가 특정 이벤트를 중심으로 복잡하게 얽힐경우 사용

 */

import java.util.ArrayList;

interface  ModeListener {
    public void onModeChange (Mode mode);
}
class ListView implements ModeListener {
    public void onModeChange(Mode mode) {
        System.out.println("리스트 뷰 : " + (mode == Mode.LIST ? "보여줌" : "감춤") );
    }
}
class GalleryView implements ModeListener {
    public void onModeChange(Mode mode) {
        System.out.println("갤러리 뷰 : " + (mode == Mode.GALLERY ? "보여줌" : "감춤") );
    }
}
class DataDown implements ModeListener {
    public void onModeChange(Mode mode) {
        System.out.println((mode == Mode.LIST ? "리스트" : "갤러리") + " 데이터 다운");
    }
}

enum Mode {LIST, GALLERY}

class ModeMediator {
    ArrayList<ModeListener> listeners = new ArrayList<>();

    public void addListener(ModeListener listener) {
        listeners.add(listener);
    }
    public void onModeChange(Mode mode) {
        for (ModeListener listener : listeners) {
            listener.onModeChange(mode);
        }
    }
}

class ModeSwitch {
    Mode mode = Mode.LIST;

    ModeMediator modeMediator;

    public void setModeMediator (ModeMediator modeMediator) {
        this.modeMediator = modeMediator;
    }

    public void modeToggle () {
        mode = mode == Mode.LIST ? Mode.GALLERY : Mode.LIST;

        if(modeMediator != null) {
            modeMediator.onModeChange(mode);
        }
    }
}

public class Mediator {

    public void medi_ex (){
        ModeSwitch modeSwitch = new ModeSwitch();
        ModeMediator modeMediator = new ModeMediator();

        modeMediator.addListener(new ListView());
        modeMediator.addListener(new GalleryView());
        modeMediator.addListener(new DataDown());

        modeSwitch.setModeMediator(modeMediator);

        modeSwitch.modeToggle();

        // ModeMediator를 중심으로 N(이벤트 Switch 등):N(추가로 이벤트를 알려줄 클래스) 관계가 형성
    }
}
