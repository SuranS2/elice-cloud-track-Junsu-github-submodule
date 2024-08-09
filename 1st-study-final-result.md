---

## 스터디 최종 내용 정리

- 유호성 - DP(동적 프로그래밍 - Dynamic Programming)
    
    # 동적 계획법(Dynamic Programming)
    
    **다이나믹 프로그래밍(또는 동적 계획법)은 복잡한 문제를 더 작은 하위 문제로 나누어 해결하는 알고리즘 설계 기법**
    
    - 알고리즘 설계 기법: 문제 해결을 위해 알고리즘을 설계하는 방법이나 접근 방식을 나타냄. 설계 기법은 알고리즘을 개발하고 구현하는 데 사용되는 전략이나 원칙들을 포함
        
        ex) **분할 정복, 동적 계획법, 탐욕적 알고리즘, 백트래킹 등**
        
    
    ---
    
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
        
        ```java
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
        
        ```java
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
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d85fd78d-de88-4966-9b27-62e3e2e8c2a0/f383e231-6f04-4b87-80c5-ee60104e2a9c/Untitled.png)
        
    
    **그래프 및 트리 탐색의 경우 방문 여부를 검색하여야 그래프의 순회가 생기지 않음**
    
    - 레퍼런스 코드
        
        ```java
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
        
        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d85fd78d-de88-4966-9b27-62e3e2e8c2a0/fb279488-9223-4ce6-9784-396dbaeeeedf/Untitled.png)
        
    - 레퍼런스 코드
        
        ```java
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
    
    [정렬](https://www.notion.so/4bbfd1c1b24d48d7b5c3bbe0266b15fc?pvs=21)
    

### 이번 주 기여자

---

참석 :  고준수 유호성 한선규 이찬진

### 이번 주의 목표

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
    - 강의
        - 동근 튜터>보충학습
    - 1차 스터디
        - 알고리즘 스터디 지속성?
            - 시간만큼은 분배 하는 느낌
    - 고민. 제출 후 >
        - 이게 왜 정답? ⇒ 코드리뷰가 필요.

- 고준수
    - 2차 스터디 고민
        - 프론트 스터디? ⇒ javascript , html , css ;; spring ;; network ㅡㅡㅡ react vue/ 서버
        - 2차~3차 SQLD 6시간 + SQL고득점kit >>
        - 4~5차 쿠버네티스 && 도커
        - 4차~5차 AWS  25시간 >>
        - 모의고사 구해서 주말에 모여서 풀이

- 유호성 후기
    
    이번 1차 스터디를 진행하면서 알고리즘을 시작한지 얼마 되지 않아 따라 갈 수 있을까 걱정이 많았지만 알고리즘의 기본기를 탄탄하게 다질 수 있는 시간이었던것 같습니다.
    
     Queue, Stack을 시작으로 DFS, BFS, DP, 투 포인터 기법 등 다양한 알고리즘 기법들을 처음 접하고 공부하며 문제를 해결하는데 있어 개발자로써 더욱 더 성장할 수 있는 경험이었으며, 스터디원들과 문제를 두고 브레인스토밍을 해가며 문제를 해결하고 서로를 도와주는 것에 있어 스터디의 장점을 느낄 수 있었으며, 알고리즘 문제나 기법 뿐만 아니라 다른 문제들에 대해서도 서로 다른 관점에서 이야기하며 제 생각의 폭을 넓힐 수 있었던 시간들이 인상적으로 남았습니다.
    
    개인적으로 가장 만족스러웠던 점은 제 자신만의 루틴 혹은 좋은 습관을 만들었다는 것입니다. 스터디 규칙으로 시작한 하루에 하나의 알고리즘 문제를 풀고 1일 1commit을 스터디가 아니더라도 계속해서 하게되고, 그날의 공부했던 것들의 복습하는 등 계속해서 꾸준히 이어나갈 수 있도록 노력할 것입니다. 또한 부족한 시간 속에서 시간 관리를 좀더 효율적으로 활용하는 방법에 대해 많은 생각을 하고 계획을 세우며, 제 자신이 한층 더 성장한 사람이 되었다라는 것을 느낄 수 있었던 1차 스터디 였던거 같습니다.
    
- 이찬진
    - 원하는 스터디의 방향 > 같은 문제에 대해서 고민해보는걸 생각했었음
