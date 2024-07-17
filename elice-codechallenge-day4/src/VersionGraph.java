import java.util.*;


public class VersionGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // vertex의 수

        int[][] graph = new int[N + 1][N + 1]; //index를 1부터 맞추기 위해서

        int vertexA = 0;
        int vertexB = 0;
        for (int i = 1; i <= N - 1; i++) {
            // System.out.println(i);
            vertexA = sc.nextInt();
            vertexB = sc.nextInt();
            putEdge(graph, vertexA, vertexB);
        }

        // print(graph);
        System.out.println(1); // 1번 노드에선 무조건 승리한다
        for (int nodeNum = 2; nodeNum <= N; nodeNum++) {
            //2~N노드까지
            //1번 외의 자식노드가 있으면 짐
            if (isEdge(graph, nodeNum)) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }

    public static void print(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void putEdge(int[][] graph, int x, int y) {
        // System.out.println("x="+x + "\t y=" + y);
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public static boolean isEdge(int[][] graph, int x) {
        for (int j = x; j < graph.length; j++) {
            if (graph[x][j] == 1) {

                return true;
            }
        }
        return false;
    }
    //지는 조건! 1 외에 연결되어있는 자식노드가 있으면 진다
    //리프 노드면 무조건 승리한다.
}

//최선의 탐색이 없다!, 교차하면서 플레이하는 기준또한 없다.