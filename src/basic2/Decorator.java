package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    9. Decorator

    특정 클래스에 객체들이 할 수 있는 여러 행위를 두고
    각 객체마다 사용자가 원하는대로 고르게 하거나 필요에 따라 추가장착할 때

    종스크롤 슈팅게임에서 전투기가 아이템을 먹을떄마다 공격에 발사되는 무기가 추가되는것 생각

    객체가 다른 객체 생성자 변수로 안에 들어감으로서 실행하는 메서드의 행동이 추가됨
 */

interface Player {
    public void attack();
}

class PlayerXwing implements Player {
    public void attack() {
        System.out.println("기본 탄환 발사");
    }
}

abstract class PlayerDecorator implements Player {
    private Player decoratedPlayer;

    public PlayerDecorator(Player decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    public void attack() {
        decoratedPlayer.attack();
    }
}

class LaserDecorator extends PlayerDecorator {
    public LaserDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void attack() {
        super.attack();
        System.out.println("레이저 발사");
    }
}

class MissileDecorator extends PlayerDecorator {
    public MissileDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void attack() {
        super.attack();
        System.out.println("미사일 발사");
    }
}

public class Decorator {
    public void decorator_ex() {
        new PlayerXwing().attack();

        new LaserDecorator(new PlayerXwing()).attack(); // 객체 안에 기본 객체를 변수로 저장한 레이저객체

        new MissileDecorator(new LaserDecorator(new PlayerXwing())).attack();
        // (객체 안에 기본 객체를 변수로 참조한) 레이저객체를 다시 변수로 참조한 미사일 객체
        // attack 실행시 변수로 참조된 (미사일에서참조한레이저에서참조한) 기본 객체 attack > 미사일에서 참조한 레이저
    }
}
