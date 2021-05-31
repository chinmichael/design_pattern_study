package basic1;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    6. Proxy 패턴

    본 객체를 여럿 생성하기엔 네트워크로 받아야해서 오래걸리나 메모리를 많이 차지하는 등의 이유로
    대리 객체를 사용하는 패턴으로 가벼운 작업은 대리객체가 중요작업은 본(실제) 객체가 실행하게 함

    필요할 때만 실제 객체를 생성해 효율적인 설계 가능

    혹은 Spring AOP에서 비즈니스 로직의 본객체를 프록시가 감싸서 받아온 서브로직들은 해당 객체가 처리하여 프록시가 조인트해 연결함

    예를 들어 동영상사이트 썸네일에서 커서 호버시 프리뷰가 실행될 때
    썸넬이나 제목을 화면에 나타내는 가벼운 작업
    영상 데이터를 받아와야하는 무거운 프리뷰 작업

    >> 썸넬 보여주는건 Proxy 객체의 썸넬 메서드
    >> 프리뷰 보여주는건 실제 객체의(썸넬, 프리뷰 메서드 가짐) 프리뷰 메서드

    >> Proxy가 실제 객체를 감싸 프리뷰가 필요할 때만 실제 객체 호출
 */

interface Thumbnail {
    public void showThumbnail();
    public void showPreview();
}

class RealThumbnail implements Thumbnail {

    private String title;
    private String movieUrl;

    public RealThumbnail (String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;

        System.out.println("영상 다운");
        //객체가 새로 생성 (새롭게 영상 다운) 때마다 표시
    }

    @Override
    public void showThumbnail() {
    }
    @Override
    public void showPreview() {
    }

}

class ProxyThumbnail implements Thumbnail {

    private String title;
    private String movieUrl;

    // Proxy 객체가 실제 객체를 감싸는 형태로 디자인
    private RealThumbnail realThumbnail;

    public ProxyThumbnail (String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;
    }

    @Override
    public void showThumbnail() {
    }

    @Override
    public void showPreview() { // 프리뷰(핵심로직)은 실제 객체의 메서드를 쓰게 함

        if(realThumbnail == null) { // 한 프록시 객체에서 실제 객체(무거움) 생성 호출 시 생성은 한번만 일어날 수 있도록
            realThumbnail = new RealThumbnail(title, movieUrl);
        }

        realThumbnail.showPreview();
    }
}

public class Proxy {
}
