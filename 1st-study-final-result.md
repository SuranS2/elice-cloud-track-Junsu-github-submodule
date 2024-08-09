# 스터디 최종 내용 정리

- 유호성 - DP(동적 프로그래밍 - Dynamic Programming)
    
    ## 동적 계획법(Dynamic Programming)
    
    **다이나믹 프로그래밍(또는 동적 계획법)은 복잡한 문제를 더 작은 하위 문제로 나누어 해결하는 알고리즘 설계 기법**
    
    - 알고리즘 설계 기법: 문제 해결을 위해 알고리즘을 설계하는 방법이나 접근 방식을 나타냄. 설계 기법은 알고리즘을 개발하고 구현하는 데 사용되는 전략이나 원칙들을 포함
        
        ex) **분할 정복, 동적 계획법, 탐욕적 알고리즘, 백트래킹 등**

    ### DP과 재귀적 호출의 차이점
    
    1. **하향식(Top-down) vs 상향식(Bottom-up) 접근**
        - 재귀적 호출은 주로 큰 문제를 작은 하위 문제로 나누어 해결하는 방식인 `하향식(top-down)` 접근 방식을 사용
        - 동적 계획법은 작은 하위 문제들부터 시작하여 그 결과를 저장하고, 이를 이용하여 점진적으로 큰 문제의 해를 구해나가는 `상향식(bottom-up)` 접근 방식을 사용
    2. **메모이제이션(Memoization)**
        - 동적 계획법은 중복되는 **계산 결과를 저장**하는 메모리 기법인 메모이제이션을 사용
        - 재귀적 호출에서의 중복 계산을 방지하고 계산 속도를 향상
    
    ### **DP 기법을 적용시킬 수 있는 조건**
    
    1. **중복되는 부분 문제(Overlapping Subproblems)**
        - DP는 기본적으로 문제를 나누고 그 문제의 결과 값을 재활용해서 전체 답을 구함, 그래서 동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능
    2. **최적 부분 구조(Optimal Substructure)**
        - 부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우 사용이 가능
    
    ## DP로 문제 푸는 방법
    
    1. **메모하기**
        - 변수 값에 따른 결과를 저장할 배열 등을 미리 만들고 그 결과를 나올 때마다 배열 내에 저장하고 그 저장된 값을 재사용하는 방식으로 문제를 해결해 나간다.
    2. **변수 간 관계식(점화식) 만들기**
        - 예를 들어 피보나치 수열의 f(n) = f(n-1) + f(n-2) 라는 식
        - 점화식 - 두개의 항 사이에 성립하는 관계를 나타낸 관계식
    
    ### DP 문제 해결 방식은 크게 두가지
    
    1. **Bottom-Up** (Tabulation 방식) - 반복문 사용
        - Bottom-Up 방식은 작은 부분 문제부터 차례대로 해결하여 전체 문제를 해결하는 방식
        - 이를 위해 반복문을 사용하여 반복적으로 부분 문제들을 해결하고, 결과를 배열 등에 저장
        
        ⇒ 일반적으로 더 직관적이고 이해하기 쉬움. 또한, 모든 작은 부분 문제를 해결하므로 최적 부분 구조를 보장
        
    2. **Top-Down** (Memoization 방식) - 재귀 사용
        - 큰 문제를 작은 부분 문제로 나누어 해결하는 방식
        - 이를 위해 재귀 함수를 사용하여 문제를 작은 부분 문제들로 쪼개고, 중복 계산을 피하기 위해 이전에 계산한 값을 저장하는 Memoization을 활용
        - Memoization은 캐싱을 통해 이전 계산 결과를 저장하여 중복 계산을 피하는 것을 의미
        
        ⇒ Memoization은 재귀를 사용하므로 구현이 더 간단하고 필요한 부분 문제만 해결하므로 계산 시간을 절약 가능, 하지만 재귀 호출의 오버헤드가 발생할 수 있으며, 모든 작은 부분 문제를 해결하지 않을 경우 최적 부분 구조를 보장하지 않을 수 있음

    ## **DP 장단점**
    
    장점
    
    - 중복 계산을 줄임
    - 효율적인 시간 복잡도를 가질 수 있음
    
    단점
    
    - 메모리 사용량이 큼(DP는 중간 결과를 저장하기 위해 추가적인 메모리를 사용하기 때문)
    
    ## 대표적인 DP 문제
    
    ### 1. 피보나치 수열 > Top-Down 방식
    
    피보나치 수열은 이전 **두 항의 합**으로 이루어지는 수열입니다. 동적 계획법을 사용하여 피보나치 수열을 구할 수 있습니다. 작은 문제부터 시작하여 계산 결과를 저장하고 이를 이용하여 큰 문제의 해를 구합니다.
    
    ```java
    public static int fibonacci(int n) {
        // 메모이제이션
        // 피보나치 수열을 저장할 배열
        int[] dp = new int[n + 1];
    
        // 초기값 설정
        dp[0] = 0;
        dp[1] = 1;
    
        // 점화식
        // 피보나치 수열 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    
        // 결과 반환
        return dp[n];
    }
    
    public static void main(String[] args) {
        // 예시로 n = 10일 때 피보나치 수열 값 출력
        System.out.println(fibonacci(10)); // Output: 55
    }
    ```
    
    ### 2. 배낭 문제(Knapsack Problem) > Bottom-Up 방식
    
    주어진 가방의 용량에 **최대한 가치**가 높은 물건을 넣는 문제입니다. 각 물건은 가치와 무게를 가지고 있으며, 동적 계획법을 사용하여 가방의 용량에 따른 최대 가치를 구할 수 있습니다.
    
    ```java
    public class Knapsack {
    
        public static int knapsack(int[] weights, int[] values, int capacity) {
            int n = weights.length;
    
            // 메모이제이션
            // 동적 계획법을 위한 2차원 배열 초기화
            int[][] dp = new int[n + 1][capacity + 1];
    
            // 점화식
            // 배낭 문제 해결
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= capacity; j++) {
                    if (weights[i - 1] > j) {
                        // 현재 아이템을 배낭에 넣을 수 없는 경우
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 현재 아이템을 배낭에 넣을 수 있는 경우
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                    }
                }
            }
    
            // 결과 반환
            return dp[n][capacity];
        }
    
        public static void main(String[] args) {
            // 예시로 아이템의 무게와 가치, 배낭의 용량이 주어졌을 때 최대 가치 출력
            int[] weights = {2, 3, 4, 5};
            int[] values = {3, 4, 5, 6};
            int capacity = 7;
    
            System.out.println(knapsack(weights, values, capacity));  // Output: 9
        }
    }
    ```
    
- 이찬진 - 다익스트라알고리즘

    # 다익스트라 알고리즘

## 다익스트라 알고리즘

- 각 모든 노드까지의 최단거리를 구하는 알고리즘
- 다익스트라 알고리즘은 기본적으로 그리디 알고리즘과 다이나믹 프로그래밍을 사용한 알고리즘

## 다익스트라 알고리즘 예제

아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)

![image](https://github.com/user-attachments/assets/9e3f71ec-529f-4b2f-a516-ea440386a49c)

- 입력설명

첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
결정보와 거리비용이 주어진다.

- 출력설명

1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.

- 입력 예제

```
6 9
1 2 12 
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
```

ex) 1 2 12 : 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.

- 출력 예제

```
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
```

### 다익스트라 알고리즘 원리

- 다익스트라 알고리즘은 두가지 기반으로 반복된다.
    1. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택한다.(그리디 알고리즘)
    2. 해당 노드로부터 갈 수 있는 노드들의 비용을 갱신한다.(다이나믹 프로그래밍)
- 다익스트라 알고리즘을 예제에 적용시켜보자
1. 출발지점에서의 가중치를 0으로 설정하고 값을 갱신한다(확정짓는다).
2. 연결된 노드들을 하나씩 방문한다.
3. 기존 가중치 값과 연결된 노드의 가중치의 합을 더해 연결된 노드의 가중치값을 저장한다.
    1. ex) 1노드→2노드로 가는 가중치가 12 이고 1노드의 가중치가 0이면 0+12=12이므로 2노드의 가중치는 12가 된다.
4. 확정된 노드의 가중치값을 제외한 모든 값중에 가장 작은 값을 선택한다.
    1. ex) 2노드의 가중치가 12, 3노드의 가중치가 4라고 하면 1노드의 가중치는 확정이 되었기때문에 그 중 가장 작은 가중치값인 3노드가 결정된다.
5. 선택한 값을 갱신(확정)한후 2번~4번의 내용을 계속반복한다.

### 다익스트라 알고리즘 복잡도

- 위와 같이 다익스트라 알고리즘을 적용한다면 최악의 경우 1번 노드에서 n번 노드까지 n번을 탐색할수 있기때문에 O(N^2)이 된다.
- PriorityQueue(우선순위 큐)를 사용하면 최소비용을 탐색할때 O(logN)의 시간복잡도를 가지기 때문에 O(N*logN)이 된다.

### PriorityQueue를 이용한 예제코드

```java
import java.util.*;
public class Sol0905DijkstraAlgorithm {
    static ArrayList<ArrayList<Point>> list;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList<>();
        arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i <= n; ++i) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            int currentNode = sc.nextInt();
            int nextNode = sc.nextInt();
            int weight = sc.nextInt();
            list.get(currentNode).add(new Point(nextNode, weight));
        }
        solution(1);
        for (int i = 2; i <= n; ++i) {
            if (arr[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            }else{
                System.out.println(i + " : " + arr[i]);
            }
        }
    }

    public static void solution(int nextNode) {
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        pQ.offer(new Point(nextNode, 0));
        while (!pQ.isEmpty()) {
            Point tmp = pQ.poll();
            int currentNode = tmp.nextNode;
            int currentWeight = tmp.weight;
            if(arr[currentNode]<currentWeight) continue;
            for (Point p : list.get(currentNode)) {
                if (arr[p.nextNode] > currentWeight + p.weight) {
                    arr[p.nextNode] = currentWeight + p.weight;
                    pQ.offer(new Point(p.nextNode, currentWeight + p.weight));
                }
            }
        }
    }
    public static class Point implements Comparable<Point>{
        int nextNode;
        int weight;

        public Point(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point o){
            return weight - o.weight;
        }
    }
}

```

- `list` : 그래프의 입력정보를 받는 리스트
- `arr` : 노드의 가중치 값을 저장하는 배열
- `ArrayList<ArrayList<Point>>`  :  인접리스트 방식을 사용하여 ArrayList안에 ArrayList를 선언하고 동적 2차원배열을 만든다.
- `Arrays.fill(arr, Integer.MAX_VALUE);` : 가중치가 작은 값을 반환해야하기 때문에 가장 큰 값들을 선언한다.
- `Point implements Comparable<Point>` : `PriorityQueue`는 정렬기준에 따라서 정렬해주기 때문에 자바에서 지원해주는 Comparable 인터페이스를 사용하여 정렬기준을 결정한다. 위 예제에서는 가중치가 작은 값을 꺼내야 하므로 가중치를 기준으로 오름차순 정렬을 선언한다.
- `if(arr[currentNode]<currentWeight) continue;`
    - 시간복잡도를 줄일수있는 수단(O(N^2)→O(N*logN)
    - arr[현재노드] 값보다 큐에서 꺼낸 가중치 값보다 작으면 for문을 돌필요없기 때문에 `continue` 를 통해 탈출한다(어려움!!, 중요!!)
    - arr의 모든 값을 가장 큰 값으로 초기화한 이유이기도 하다.
- arr의 값보다 가중치 값이 더 작으면 갱신 후, pq에 저장

```java
for (Point p : list.get(currentNode)) {
                if (arr[p.nextNode] > currentWeight + p.weight) {
                    arr[p.nextNode] = currentWeight + p.weight;
                    pQ.offer(new Point(p.nextNode, currentWeight + p.weight));
                }
            }
```

    [다익스트라 알고리즘](https://www.notion.so/86bb756601174d2d862d9fa6b5d15556?pvs=21) 
    
    [우선순위 큐](https://swexpertacademy.com/main/visualcode/main.do#/home/editor//)
    
- 고준수 - BFS , DFS
    - 이미지, 정리 출처
        
        https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html
        
        https://velog.io/@jhoryong/Algorithm-Search-Algorithms
        
    - 레퍼런스 코드 출처
        
        https://swexpertacademy.com/main/learn/referenceCode/referenceCodeDetail.do?referenceId=GRAPH&category=DataStructure
    
    그래프 및 트리 탐색에 활용, 맹목적 탐색 방법
    
    - 그래프(자료구조) 레퍼런스 코드

        ```
        java
        import java.util.Scanner;
         
         
        class Graph // 그래프 클래스 작성
        {
             
            class AdjlistNode // 인접 노드 리스트
            {
                int vertex; // 정점
                AdjlistNode next; // 다음 인접 노드 객체
                 
                public AdjlistNode(int v) // 생성자
                {
                    vertex = v;
                    next = null;
                }
            }
             
            class AdjList
            {
                int num_members;
                AdjlistNode head;
                AdjlistNode tail;
                 
                public AdjList()
                {
                    num_members = 0;
                    head = tail = null;
                }
            }
             
            int num_vertices;
            AdjList []adjListArr;
             
            public Graph(int n)
            {
                num_vertices = n;
                adjListArr = new AdjList[n];
                for (int i = 0; i < n; i++)
                {
                    adjListArr[i] = new AdjList();
                }
            }
             
            void addEdge(int src, int dest)
            {
                AdjlistNode newNode = new AdjlistNode(dest);
                if (adjListArr[src].tail != null)
                {
                    adjListArr[src].tail.next = newNode;
                    adjListArr[src].tail = newNode;
                }
                else
                {
                    adjListArr[src].head = adjListArr[src].tail = newNode;
                }
                adjListArr[src].num_members++;
                 
                newNode = new AdjlistNode(src);
                if (adjListArr[dest].tail != null)
                {
                    adjListArr[dest].tail.next = newNode;
                    adjListArr[dest].tail = newNode;
                }
                else
                {
                    adjListArr[dest].head = adjListArr[dest].tail = newNode;
                }
                adjListArr[dest].num_members++;
            }
             
            void display(int i)
            {
                AdjlistNode adjList = adjListArr[i].head;
                while (adjList != null)
                {
                    System.out.printf("%d ", adjList.vertex);
                    adjList = adjList.next;
                }
                System.out.printf("\n");
            }
        }
             
         
        class Solution
        {
            public static void main(String args[]) throws Exception
            {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                for (int test_case = 1; test_case <= T; test_case++)
                {
                    int V = sc.nextInt();
                    int E = sc.nextInt();
                    int Q = sc.nextInt();
                    Graph graph = new Graph(V);
                    for (int i = 0; i < E; i++)
                    {
                        int sv = sc.nextInt();
                        int ev = sc.nextInt();
                        graph.addEdge(sv, ev);
                    }
                    System.out.printf("#%d\n", test_case);
                    for (int i = 0; i < Q; i++)
                    {
                        int sv = sc.nextInt();
                        graph.display(sv);
                    }
                }
                sc.close();
            }
        }
        ```
        
    - 트리(자료구조) 레퍼런스 코드
        
        ```
      java
        import java.util.Scanner;
         
        class Tree {
         
            static final int MAX_CHILD_NUM = 2;
             
            class TreeNode {
                int parent;
                int []child = new int[MAX_CHILD_NUM];
                public TreeNode(int parent)
                {
                    this.parent = parent;
                    for (int i = 0; i < MAX_CHILD_NUM; i++)
                    {
                        child[i] = -1;
                    }
                }
            }
         
            TreeNode []treenode;
            int nodeNum;
         
            public Tree(int nodeNum) {
                this.nodeNum = nodeNum;
                treenode = new TreeNode[nodeNum+1];
                for (int i = 0; i <= nodeNum; i++)
                {
                    treenode[i] = new TreeNode(-1);
                }
            }
         
            public void addChild(int parent, int child) 
            {
                int found = -1;
                for (int i = 0; i < MAX_CHILD_NUM; i++)
                {
                    if (treenode[parent].child[i] == -1)
                    {
                        found = i;
                        break;
                    }
                }
                if (found == -1) return;
                 
                treenode[parent].child[found] = child;
                treenode[child].parent = parent;
            }
         
            public int getRoot() 
            {
                for (int i = 1; i < nodeNum; i++) 
                {
                    if (treenode[i].parent == -1) 
                    {
                        return i;
                    }
                }
                return -1;
            }
         
            public void preOrder(int root)
            {
                System.out.printf("%d ", root);
         
                for (int i = 0; i < MAX_CHILD_NUM; i++) 
                {
                    int child = treenode[root].child[i];
                    if (child != -1)
                    {
                        preOrder(child);
                    }
                }
            }
        }
         
        class Solution {
             
            public static void main(String arg[]) throws Exception {
                Scanner sc = new Scanner(System.in);
                 
                int T = sc.nextInt();
         
                for (int test_case = 1; test_case <= T; ++test_case) 
                {
                    int node = sc.nextInt();
                    int edge = sc.nextInt();
                     
                    Tree tree = new Tree(node);
         
                    for (int i = 0; i < edge; i++)
                    {
                        int parent = sc.nextInt();
                        int child = sc.nextInt();
                        tree.addChild(parent, child);
                    }
                    int root = tree.getRoot();
                    System.out.printf("#%d ", test_case);
                    tree.preOrder(root);
                    System.out.printf("\n");
                }
         
                sc.close();
            }
        }
        ```

    DFS (**Depth-First Search)** : **스택 or 재귀** - 현재 정점에서 갈 수 있는 점들까지 들어가면서 탐색
    
    - 키워드 ⇒ 모든 경로(노드) 탐색 ㅡ 끝나는 조건 ⇒ 재귀 끝내기 위해서
    - **구현이 쉬운 편**
        
       ![image](https://github.com/user-attachments/assets/79be34d5-93d2-4fa2-89f3-9fff03188f24)


    **그래프 및 트리 탐색의 경우 방문 여부를 검색하여야 그래프의 순회가 생기지 않음**
    
    - 레퍼런스 코드
        
        ```
      java
        import java.util.Scanner;
        
        // 그래프 DFS 탐색 
        
        class Solution
        {
        		//메인 비즈니스 로직
            static final int MAX_VERTEX = 30;
        		
        		//연결을 map으로 구현, 그 외 링크드리스트, 배열 등으로 구현 가능
            static int[][] map = new int[MAX_VERTEX][MAX_VERTEX]; 
        		//정점 방문 여부
            static boolean[] visit = new boolean[MAX_VERTEX];
            static int vertex;
            static int edge;
            static int maxEdge;
        		//시작 정점
            static int start;
        		//끝 정점
            static int end;
             
        		// 시작 정점, 깊이 기본값
            public static void depthFirstSearch(int v, int depth)
            {
        				// 종료조건
                if (v == end)
                {
        						//초기값이 -1이므로 무조건 발생
                    if (maxEdge < 0 || depth < maxEdge)
                    {
        								//짧은 거리를 탐색
                        maxEdge = depth;
                    }
                    return;
                }
                visit[v] = true;
                for (int i = 1; i <= vertex; i++) 
                {
        						//방문하지 않았을 경우 => 이동
                    if (map[v][i] == 1 && !visit[i]) 
                    {
        								//해당 정점 탐색이 끝났으면 다음 연결되어있는 i정점 이동
                        depthFirstSearch(i, depth + 1);
        								// !visit[i] => true 방문했다는 조건
                        visit[i] = false;
                    }
                }       
            }
        		//테스트코드
             
            public static void main(String args[]) throws Exception
            {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                for (int test_case = 1; test_case <= T; test_case++)
                {
                    vertex = sc.nextInt();
                    edge = sc.nextInt();
                    start = sc.nextInt();
                    end = sc.nextInt();
                    for (int i = 0; i < edge; i++)
                    {
                        int v1 = sc.nextInt();
                        int v2 = sc.nextInt();
                        map[v1][v2] = 1;
                    }
                    maxEdge = -1;
                    depthFirstSearch(start, 0);
                    System.out.printf("#%d %d\n", test_case, maxEdge);
                }
                sc.close();
            }
        }
        ```

    BFS (**Breadth-First Search) : 큐 -** FIFO방식 탐색 현재 정점에 연결된 가까운 점들부터 탐색
    
    - 키워드 ⇒ 최단 경로, 임의의 경로
    - DFS대비 빠름
        
        ![image](https://github.com/user-attachments/assets/24432df1-23ef-4d15-b9ba-30577b0e9e7d)

        
    - 레퍼런스 코드
        ```
      java
        import java.util.Scanner;
         
        class Queue
        {
            Point queue[];
            int head;
            int rear;
             
            class Point
            {
                int x;
                int y;
                int c;
                 
                public Point(int x, int y, int c)
                {
                    this.x = x;
                    this.y = y;
                    this.c = c;
                }
            }
            //큐의 전체 크기 할당
            public Queue(int capacity)
            {
                queue = new Point[capacity];
                head = rear = 0;
            }
            
            boolean isEmpty()
            {
                return (head <= rear);
            }
             
            boolean enqueue(int x, int y, int c)
            {
                queue[head++] = new Point(x, y, c);
                return true;
            }
             
            Point dequeue()
            {
                    if (isEmpty())
                    {
                        return null;
                    }
                    rear++;
                    return queue[rear-1];
            }
        }
         
        class Solution
        {
            static final int MAX_N = 50;
            static int[][] MAP;
            static int row;
            static int column;
             
            public static int breadthFirstSearch()
            {
        				//queue 설정
                Queue queue = new Queue(MAX_N * MAX_N);
                queue.enqueue(1, 1, 0);
                MAP[1][1] = 0;
                while(!queue.isEmpty())
                {
                    Queue.Point p = queue.dequeue();
                    if (p.x == column && p.y == row)
                    {
                        return p.c;
                    }
                    if (p.x + 1 <= column && MAP[p.x + 1][p.y] != 0)
                    {
                        queue.enqueue(p.x + 1, p.y, p.c + 1);
                        MAP[p.x + 1][p.y] = 0;
                    }
                    if (p.y + 1 <= row && MAP[p.x][p.y + 1] != 0) 
                    {
                        queue.enqueue(p.x, p.y + 1, p.c + 1);
                        MAP[p.x][p.y + 1] = 0;
                    }
                    if (p.x - 1 > 0 && MAP[p.x - 1][p.y] != 0) 
                    {
                        queue.enqueue(p.x - 1, p.y, p.c + 1);
                        MAP[p.x - 1][p.y] = 0;
                    }
                    if (p.y - 1 > 0 && MAP[p.x][p.y - 1] != 0) 
                    {
                        queue.enqueue(p.x, p.y - 1, p.c + 1);
                        MAP[p.x][p.y - 1] = 0;
                    }
                }
                return -1;
            }
             //테스트코드
             
            public static void main(String args[]) throws Exception
            {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                for (int test_case = 1; test_case <= T; test_case++)
                {
                    row = sc.nextInt();
                    column = sc.nextInt();
                    MAP = new int[column+1][row+1];
                    for (int i = 1; i <= row; i++){
                        for (int j = 1; j <= column; j++)
                        {
                            MAP[j][i] = sc.nextInt();
                        }
                    }
                    System.out.printf("#%d %d\n", test_case, breadthFirstSearch());
                }
                sc.close();
            }
        }
        ```
        
- 한선규 - 정렬
    
    ## 정렬이란?

- 가지런하게 줄지어 늘어섬. 또는 그렇게 늘어서게 함
- 데이터를 특정한 조건에 따라 일정한 순서가 되도록 다시 배열하는 일.

## 정렬의 방법

- 내부정렬
- 외부정렬

정렬할 데이터가 하나의 배열에 저장될 수 있으면 내부정렬을,

정렬할 데이터가 하나의 배열에 저장될 수 없으면 외부정렬을 주로 사용한다.

## 정렬 알고리즘의 핵심 요소

- 비교
- 교환(이동)
- 반복(재귀)

## 정렬의 종류

[선택 정렬](https://www.notion.so/6ded5b1e451745b8924b57e648b68a05?pvs=21)

[버블 정렬](https://www.notion.so/bb5e702abc874387ab21fe8e61c25715?pvs=21)

[삽입 정렬](https://www.notion.so/d4b5b3f5f3d9426fac79b41778231545?pvs=21)

[병합 정렬](https://www.notion.so/93586fa504bd443abbef153e85b6ade0?pvs=21)

[퀵 정렬](https://www.notion.so/10ba652c9d9f487b9f68b1a71d3b4524?pvs=21)

[힙 정렬](https://www.notion.so/e53405dea4f448049c509c4d2e41e003?pvs=21)

## 선택 정렬

- 작은 요소의 순서대로 선택해 앞쪽으로 위치를 옮겨 순서대로 정렬하는 알고리즘

## 버블 정렬

- 맨 끝단부터 이웃한 두 요소의 비교-교환의 과정을 진행하며 정렬하는 알고리즘

## 삽입 정렬

- 선택한 요소를 앞쪽의 알맞은 위치로 삽입해 정렬하는 알고리즘

## 병합 정렬

- 정렬을 앞부분과 뒷부분으로 나눈 후 정렬하고, 병합하는 과정을 반복하는 알고리즘

## 퀵 정렬

- 임의의 한 요소를 선택하고 그 요소를 기준으로 그룹을 나눠 정렬하는 작업을 반복.
그룹원이 모두 1명이 될 경우 정렬이 끝나는 알고리즘
- 정렬 알고리즘 중 가장 빠른 알고리즘으로 일반적으로 사용됨.

## 힙 정렬

- 힙(heap)을 사용해 정렬하는 선택 정렬 응용 알고리즘.

※힙이란? 완전이진트리
    

# 이번 주 기여자

---

참석 :  고준수 유호성 한선규 이찬진

# 이번 주의 목표

---

- 8월 9일 최종 제출 자료 정리
    - 그래도 정리를 잘 할 수 있는 부분
    - DP, BFS, DFS
    - 이론 및 문제정리
        - 섹터를 4개로 쪼개서 정리함
        - 1  이찬진 다익스트라(탐색)
        - 2  유호성 DP
            - DP 유형 정리, 가능한 대로
            - 탑다운 1 바텀업 1
        - 3 고준수 BFS, DFS 확인 다익스트라 내용
            - 뼈대문재, 그리디쪽
        - 4 한선규 기초 문제 정리, 피드백
    - 물어보거나 공유할 수 있는 내용 있으면 확인

### 1차 스터디 후기, 피드백

---

- 한선규
    - 강의 보충
        - 동근 튜터 > 보충학습
    - 1차 스터디
        - 알고리즘 스터디 지속성?
    - 고민사항, 문제 제출 후 
        - 이게 왜 정답? ⇒ 코드리뷰가 필요.

- 고준수
    - 2차 스터디 고민
        - 프론트 스터디? ⇒ javascript , html , css , spring , network, react, vue 등등
        - 2차~3차 SQLD 6시간 + SQL고득점kit 
        - 4~5차 쿠버네티스 && 도커
        - 4차~5차 AWS  25시간 
        - 모의고사 구해서 주말에 모여서 풀이

- 유호성 후기

  이번 1차 스터디를 진행하면서 알고리즘을 시작한지 얼마 되지 않아 따라 갈 수 있을까 걱정이 많았지만 알고리즘의 기본기를 탄탄하게 다질 수 있는 시간이었던것 같습니다.

  Queue, Stack을 시작으로 DFS, BFS, DP, 투 포인터 기법 등 다양한 알고리즘 기법들을 처음 접하고 공부하며 문제를 해결하는데 있어 개발자로써 더욱 더 성장할 수 있는 경험이었으며, 스터디원들과 문제를 두고 브레인스토밍을 해가며 문제를 해결하고 서로를 도와주는 것에 있어 스터디의 장점을 느낄 수 있었으며, 알고리즘 문제나 기법 뿐만 아니라 다른 문제들에 대해서도 서로 다른 관점에서 이야기하며 제 생각의 폭을 넓힐 수 있었던 시간들이 인상적으로 남았습니다.

  개인적으로 가장 만족스러웠던 점은 제 자신만의 루틴 혹은 좋은 습관을 만들었다는 것입니다. 스터디 규칙으로 시작한 하루에 하나의 알고리즘 문제를 풀고 1일 1commit을 스터디가 아니더라도 계속해서 하게되고, 그날의 공부했던 것들의 복습하는 등 계속해서 꾸준히 이어나갈 수 있도록 노력할 것입니다. 또한 부족한 시간 속에서 시간 관리를 좀더 효율적으로 활용하는 방법에 대해 많은 생각을 하고 계획을 세우며, 제 자신이 한층 더 성장한 사람이 되었다라는 것을 느낄 수 있었던 1차 스터디 였던거 같습니다.

- 이찬진
    - 원하는 스터디의 방향 > 같은 문제에 대해서 고민해보는걸 생각했었음
