package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    3. State 패턴
    설계구조는 Strategy와 얼핏 비슷

    Strategy : 동일한 틀(I/F) 안에 있는 특정작업방식(모드, 전략)을 바꿔줄 때

    State : 특정 상태마다 행위가 달라질 때 (TV 켜졌을 때 전원버튼 : 꺼지게 함 | TV 꺼졌을 때 전원버튼 : 켜지게 함)
          : 상태자체를 각 행위와 함께 모듈화해 지정 >> strategy + 객체의 상태(State)(전환)
          
          : 상태전환은 모듈에서 진행될지 아님 아니면 스위치 행위의 객체에서 if로 진행될지 프로그램 성격에 따라 맞추면 됨
 */

interface ModeState {
    public void toggle (State state);
}

class ModeStateLight implements ModeState {
    @Override
    public void toggle(State state) {
        //...

        state.setState(new ModeStateDark()); // 상태가 서로 전환됨
    }
}

class ModeStateDark implements ModeState {
    @Override
    public void toggle(State state) {
        //...

        state.setState(new ModeStateLight());
    }
}

public class State {

    private ModeState modeState = new ModeStateLight();

    public void setState(ModeState modeState) {
        this.modeState = modeState;
    }

    public void onToggle() {
        modeState.toggle(this);
    }
}
