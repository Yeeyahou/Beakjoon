import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        public int x;
        public int y;
        int num;
        int distance = 0;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        Node(int num, int x, int y, int distance) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = sToi(st.nextToken());
        int h = sToi(st.nextToken());
        int[][] arr = new int[h + 1][w + 1]; // -1: 테라, -2: 도착, -3: 바위, -4: 홀
        int[][] nodeArr = new int[h + 1][w + 1]; // 노드 번호 적은 배열
        boolean[][] isNoded = new boolean[h + 1][w + 1]; // 노드가 추가되었는지 체크하는 배열
        List<Node> rockList = new ArrayList<>(); // 바위 리스트
        Node terra = new Node(1, 0, 0); // 테라노드
        Node end = new Node(2, 0, 0); // 도착노드
        int nodeNum = 2; // 노드 개수

        for (int i = 1; i <= h; i++) {
            String str = br.readLine();
            for (int j = 1; j <= w; j++) {
                char c = str.charAt(j - 1);
                if (c == 'R') { // 바위
                    arr[i][j] = -3;
                    rockList.add(new Node(0, j, i));
                } else if (c == 'T') { // 테라
                    arr[i][j] = -1;
                    terra = new Node(1, j, i);
                } else if (c == 'E') { // 도착
                    arr[i][j] = -2;
                    end = new Node(2, j, i);
                } else if (c == 'H') { // 홀
                    arr[i][j] = -4;
                } else { // 일반 길
                    arr[i][j] = c - '0';
                }
            }
        }

        List<List<Node>> graph = new ArrayList<>(); // 그래프
        List<Node> nodeList = new ArrayList<>(); // 그래프
        graph.add(new ArrayList<>()); // 0번 노드 빈노드
        graph.add(new ArrayList<>()); // 1번 노드 = 테라노드
        graph.add(new ArrayList<>()); // 2번 노드 = 도착노드
        nodeList.add(terra);
        nodeList.add(end);
        isNoded[terra.y][terra.x] = true; // 테라노드 추가
        isNoded[end.y][end.x] = true; // 도착노드 추가
        nodeArr[terra.y][terra.x] = 1; // 테라노드 번호
        nodeArr[end.y][end.x] = 2; // 도착노드 번호

        // 돌 주변 4방향을 노드로 설정
        for (Node rock : rockList) {
            int x = rock.x;
            int y = rock.y;
            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 벗어나면 건너뛰기
                if (nx < 1 || ny < 1 || nx > w || ny > h)
                    continue;

                // 이미 노드로 추가한 칸이면 건너뛰기
                if (isNoded[ny][nx])
                    continue;

                // 구멍(H)이면 멈출 수 없으니 건너뛰기
                if (arr[ny][nx] == -4)
                    continue;

                // 노드로 추가
                isNoded[ny][nx] = true;
                graph.add(new ArrayList<>());
                nodeList.add(new Node(++nodeNum, nx, ny));
                nodeArr[ny][nx] = nodeNum;
            }
        }

        // 노드 연결
        for (Node node : nodeList) {
            int x = node.x;
            int y = node.y;
            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                int distance = 0;
                while (true) {
                    int tx = nx + dx[i]; // 다음 x좌표
                    int ty = ny + dy[i]; // 다음 y좌표
                    if (tx < 1 || ty < 1 || tx > w || ty > h)
                        break; // 범위 체크

                    if (arr[ty][tx] == -4)
                        break; // 홀인지 체크

                    if (arr[ty][tx] == -2) { // 도착인지 체크
                        graph.get(node.num).add(new Node(2, tx, ty, distance));
                        break;
                    }

                    if (arr[ty][tx] == -1) { // 테라인지 체크
                        graph.get(node.num).add(new Node(1, tx, ty, distance));
                        break;
                    }

                    if (arr[ty][tx] == -3) { // 바위인지 체크
                        if(ny == y && nx == x) // 제자리면 건너뜀
                            break;
                        graph.get(node.num).add(new Node(nodeArr[ny][nx], nx, ny, distance));
                        break;
                    }

                    nx = tx; // x좌표 업데이트
                    ny = ty; // y좌표 업데이트
                    distance += arr[ty][tx]; // 거리 업데이트
                }
            }
        }

        int[] dist = new int[nodeNum + 1]; // 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 배열 초기화
        dist[1] = 0; // 테라노드 거리 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance); // 우선순위 큐
        pq.add(new Node(1, terra.x, terra.y, 0)); // 테라노드 추가

        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Node node = pq.poll(); // 노드 꺼내기
            if (dist[node.num] < node.distance)
                continue; // 이미 처리된 노드인지 체크
            for (Node next : graph.get(node.num)) { // 연결된 노드들
                if (dist[next.num] > dist[node.num] + next.distance) { // 거리 업데이트
                    dist[next.num] = dist[node.num] + next.distance;
                    pq.add(new Node(next.num, next.x, next.y, dist[next.num]));
                }
            }
        }

        if (dist[2] == Integer.MAX_VALUE) { // 도착노드에 도달할 수 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(dist[2]);
        }
    }

    static int sToi(String s) {
        return Integer.parseInt(s);
    }
}
