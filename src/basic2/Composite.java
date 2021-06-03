package basic2;

/*  basic package에서는
    알고리즘 이론 공부 후 Head First 디자인 패턴 공부 전,
    얄팍한 코딩사전 영상(https://www.youtube.com/watch?v=lJES5TQTTWE)을 보고 몇 가지를 간략히 정리해 봄


    12. Composite

    폴더 시스템을 생각하면 편함
    >> 폴더 안에는 다른 폴더나 파일이 들어갈 수 있음
    >> 폴더나 파일은 다른 종류의 객체지만 이름변경이나 용량검사, 삭제 등의 명령을 수용 가능

    >> 포함하는 것과 포함되는 것들이 같은 방식으로 다뤄질 수 있음
    
    
    그밖에 자주 쓰는 Iterator나 Builder는 자바 컬렉션 프레임워크나 롬복에 잘 구현되어 있고...
    Observer패턴의 경우 조금씩 반응형 RXjs 공부하면서 학습

 */

import java.util.ArrayList;

interface FileSystem {
    public int getSize();
    public void remove();
}

class File implements FileSystem {
    private String fileName;
    private int size;

    public File (String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public void remove() {
        System.out.println(fileName + "파일 삭제");
    }
}

class Folder implements FileSystem {
    private String folderName;
    private ArrayList<FileSystem> includes = new ArrayList<>(); // 폴더는 자체 용량은 없지만 내부 파일과 중간 폴더 전체용량의 용량 반환

    public Folder (String folderName) {
        this.folderName = folderName;
    }
    public void add(FileSystem fileSystem) {
        includes.add(fileSystem);
    }
    public int getSize() {
        int size = 0;
        for(FileSystem fileSystem : includes) {
            size = size + fileSystem.getSize(); // 파일은 자체 용량, 내부 폴더는 재귀적으로 내부폴더의 파일 용량 합산해 반환
        }
        return size;
    }
    public void remove() {
        for(FileSystem fileSystem : includes) {
            fileSystem.remove(); // 내부 폴더는 재귀적으로 내부 파일까지 삭제
        }
        System.out.println(folderName + "폴더 삭제");
    }
}

public class Composite {
}
