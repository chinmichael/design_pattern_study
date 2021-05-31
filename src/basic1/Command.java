package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    4. Command 패턴
    Command도 꽤나 Strategy와 비슷한 모습을 보일 때가 많음

    Strategy : 같은 업무(I/F)에 알고리즘이나 방식(구현 클래스,방식)이 갈아끼워진다면
    Command : 아예 업무자체가 다름 >> 사용케이스가 좀 더 다양함
            : 전략패턴처럼 모드에 따라 업무모듈이 갈아 끼워지거나
            : 스위치에 따라 다른 업무를 혹은
            : 여러 명령을 목록으로 실어 차례로 실행시킬 수도 있음


    아래는 로봇의 실행명령을 미리 목록화한 뒤 순서대로 실행시키는 모델

    한 객체와 관련 행동들을 각 모듈로 정의한 뒤 위처럼 다양한 방식으로 활용될 수 있음 (동적으로 명령 리스트를 작성한다던가)

 */


import java.util.ArrayList;

abstract class RobotCommand { // I/F를 구현하는 방식으로 해도 됨 | 객체가 받을 커맨드
    protected Robot robot;

    public void setRobot (Robot robot) { // 커맨드를 받을 객체를 지정시켜 각 세부 명령에 상속후 명령 리스트를 차례로 받을 수 있도록
        this.robot = robot;
    }
    public abstract void execute();
}

class MoveForwardCommand extends  RobotCommand { // 받을 명령어 세부 정의
    int space;
    public MoveForwardCommand(int space) {
        this.space = space;
    }
    public void execute() {
        robot.moveFoward(space);
    }
}

class MoveBackCommand extends  RobotCommand {
    Robot.Direction direction;
    public MoveBackCommand(Robot.Direction direction) {
        this.direction = direction;
    }
    public void execute() {
        robot.turn(direction);
    }
}

class MoveTurnCommand extends  RobotCommand {
    int backSpace;
    public void execute() {
        robot.moveBack();
    }
}

class Robot { // 커맨드를 받을 객체

    public enum Direction {LEFT, RIGHT}

    public void moveFoward (int space) {
        System.out.println(space + "전진");
    }
    public void turn(Direction direction) {
        System.out.println(
                (direction == Direction.LEFT ? "왼쪽" : "오른쪽") + "회전"
        );
    }
    public void moveBack() {
        System.out.println("한칸 후진");
    }
}

public class Command { // 정확히는 얘가 CommandList 위 추상클래스가 Command

    private Robot robot = new Robot();
    private ArrayList<RobotCommand> commands = new ArrayList<>();

    public void addCommand(RobotCommand command) { // 명령을 추가한 뒤
        commands.add(command);
    }

    public void start() { // 명령 실행
        for(RobotCommand command : commands) {
            command.setRobot(robot);
            command.execute();
        }
    }

}
