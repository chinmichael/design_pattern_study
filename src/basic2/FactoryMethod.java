package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    9. FactoryMethod

    여러 객체의 모듈을 사용할 때 Factory 클래스에서 인자에 따라 적절히 찾아 이 Factory 객체의 인스턴스를 불러와 실행
    1. 이 객체 모듈들을 여러곳에서 사용할 때 수정사항이 생기면 직접 가져다 쓰는 Factory 클래스만 수정하거나 하면 됨으로 객체 모듈 변경의 부담이 덜함
    2. 조건에 따라 생성할 객체 모듈 선정을 Factory에 위임으로서 Factory를 사용하는 개발자가 Factory에서 사용하는 모듈들에 대해 굳이 알 필요가 없음

    프레임웤이나 라이브러리 사용시 특정 기능에 연관되는 모든 복잡한 클래스를 알 필요 없이 인스턴스나 메서드를 호출해 사용하는 것 생각

    인자만 제대로 넣으면 이에 해당하는 적절한 모듈 객체를 생성해 Factory가 넘김

    응용 예시로 데코레이터와 함께 쓰면 인자만 넘기면 적절히 어떤 객체들을 추가시킬 지 Factory가 처리

    10. Abstract Factory
    한단계 더해 Factory 클래스도 추상화하여(추상클래스나 인터페이스로) 여러 Factory를 만들어낼때
    예를 들어 테마마다(다크나 라이트) 반환 객체를 달리할 때

 */

abstract class Component {
}
class Button extends Component {
}
class Switch extends Component {
}

enum Usage {
    PRESS, TOGGLE
}

class ComponentFactory {
    public Component getComp(Usage usage) {
        if(usage == Usage.PRESS) {
            return new Button();
        } else if (usage == Usage.TOGGLE) {
            return new Switch();
        } else {
            return null;
        }
    }
}

public class FactoryMethod {

    Component comp1;
    Component comp2;

    private ComponentFactory compFactory = new ComponentFactory();

    public void no_factory() {
        comp1 = new Button();
        comp2 = new Switch();
    }
    public void ex_factory() {
        comp1 = compFactory.getComp(Usage.PRESS);
        comp2 = compFactory.getComp(Usage.TOGGLE);

    }

    public Players ex_decoFactory(boolean laser, boolean missile) {
        Players players = new PlayerZwing();

        if(laser) players = new LaserDeco(players);
        if(missile) players =new MissileDeco(players);

        return players;
    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        Players players = factoryMethod.ex_decoFactory(true, true);

        players.attack();
    }
}


//=================================================================================

interface Players {
    public void attack();
}

class PlayerZwing implements Players {
    public void attack() {
        System.out.println("기본 탄환 발사");
    }
}

abstract class PlayerDeco implements Players {
    private Players decoratedPlayer;

    public PlayerDeco(Players decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    public void attack() {
        decoratedPlayer.attack();
    }
}

class LaserDeco extends PlayerDeco {
    public LaserDeco(Players decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void attack() {
        super.attack();
        System.out.println("레이저 발사");
    }
}

class MissileDeco extends PlayerDeco {
    public MissileDeco(Players decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void attack() {
        super.attack();
        System.out.println("미사일 발사");
    }
}

//=======================================================================
interface CompFactory {
    public Component getComponent(Usage usage);
}

class LightButton extends Component {}
class DarkButton extends Component {}
class LightSwitch extends Component {}
class DarkSwitch extends  Component {}

class LightCompFactory implements CompFactory {
    @Override
    public Component getComponent(Usage usage) {
        if(usage == Usage.PRESS) {
            return new LightButton();
        } else if (usage == Usage.TOGGLE) {
            return new LightSwitch();
        } else {
            return null;
        }
    }
}
class DarkCompFactory implements CompFactory {
    @Override
    public Component getComponent(Usage usage) {
        if(usage == Usage.PRESS) {
            return new DarkButton();
        } else if (usage == Usage.TOGGLE) {
            return new DarkSwitch();
        } else {
            return null;
        }
    }
}