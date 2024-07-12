import java.util.*;

class VersionTree{
    static List<Integer>[] adjList; //인접리스트 표시
    static int[] dp; // 점수
    static boolean[] visited; // 방문했는가?


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //각자 인덱스값을 1부터 맞추기 위해 작업
        adjList = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        //노드의 시작값이 1번인 인접리스트 ~ N번까지 생성
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }
        // 인접 리스트에 노드 값을 추가해줌 ( 간선 = 양방향 )

        Stack<Integer> bfsNodeStack = new Stack<>();
        Queue<Integer> visitedQueue = new LinkedList<>();
        visitedQueue.add(1);
        visited[1] = true;
        //방문해야 하는 값을 순서대로 Queue에 넣어서 작업
        //BFS 순차 방문 기록을 stack에 사용
        while (!visitedQueue.isEmpty()) {
            int node = visitedQueue.poll();
            bfsNodeStack.push(node);
            for (int child : adjList[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    visitedQueue.add(child);
                }
            }
        }

        // 스택을 이용해 DP 값을 계산
        // 방문 기록 삭제
        Arrays.fill(visited, false);

        while (!bfsNodeStack.isEmpty()) {
            int node = bfsNodeStack.pop();
            // System.out.println("visit node = " + node);
            // 밑부터 시작하기 때문에 방문 O, 리프노드 O
            visited[node] = true;
            boolean isLeaf = true;

            int minChildValue = Integer.MAX_VALUE;
            // int 최대값 2147483647
            for (int child : adjList[node]) {
                //노드에 입력된 인접 노드들(자식) 값 산출
                if (visited[child]) {
                    // 리프노드 이후 다음 인접노드 확인시, 자식을 방문하고 올라갔다!, 리프노드가 아니다.
                    isLeaf = false;
                    //if대신 int값 비교를 위해 Math.min 사용
                    //자식값은 무조건 상대방에게 적은 점수를 던져준다
                    minChildValue = Math.min(minChildValue, dp[child]);
                }
            }

            if (isLeaf) {
                System.out.println(node+"번 정점에서 선공이 가지고있는 후공과의 점수차이 = " +dp[node]);
                dp[node] = node; // 리프 노드의 초기값
            } else {
                // 만약 1번 노드일경우 2번까지 진행했던 값과의 차이가 내 점수이다.
                // 2번 예시 기준 ex dp[1] = 1 - (2-4) / dp[2] = 2 - 4
                dp[node] = node - minChildValue;
                System.out.println(node+"번 정점에서 선공이 가지고있는 후공과의 점수차이 = " +dp[node]);
            }

        }

        // 결과를 출력, 순서대로
        for (int i = 1; i <= n; i++) {
            if (dp[i] >= 0) {
                System.out.println(1);  // 선공 승리
            } else {
                System.out.println(0);  // 후공 승리
            }
        }

        sc.close();



    }
}