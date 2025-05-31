#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>

const int MAX = 10000001;
int N, K, step;
int heapSize, heap[MAX];
int p[MAX], s[MAX];
char color;

bool compare(int x, int y) { return s[x] > s[y] || s[x] == s[y] && x < y; }

// 최대 힙 push 연산
void push(int idx) {
	int a, b;
	heap[++heapSize] = idx;
	a = heapSize;
	while (a > 1) {
		if (!compare(idx, b = heap[a >> 1])) break;
		heap[a] = b;
		a = a >> 1;
	}
	heap[a] = idx;
}

// 최대 힙 pop 연산
int pop() {
	int top = heap[1];
	int j = 1;
	int il, ir;

	heap[1] = heap[heapSize--];
	while (j < heapSize) {
		il = j << 1;
		ir = (j << 1) + 1;
		int k = j;
		if (il <= heapSize && compare(heap[il], heap[k])) k = il;
		if (ir <= heapSize && compare(heap[ir], heap[k])) k = ir;
		if (k != j) {
			int tmp = heap[k];
			heap[k] = heap[j];
			heap[j] = tmp;
			j = k;
		}
		else break;
	}
	return top;
}

int main() {
	scanf("%d%d", &N, &K);
	scanf(" %c", &color);

	p[1] = 100 + color;
	s[1] = 1;

	for (int i = 2; i <= N; i++) {
		scanf("%c", &color);
		if (p[i - 1] % 100 == color) {
			p[i] = p[i - 1];
			p[p[i] / 100] = i * 100 + color;
			s[p[i] / 100]++;
		}
		else {
			push(p[i - 1] / 100);
			p[i] = i * 100 + color;
			s[i] = 1;
		}
	}
	push(p[N] / 100);

	step = 0;
	while (heapSize > 0) {
		int curr = pop();
		int ptr = p[curr] / 100;
		int cl = ptr <= curr ? ptr : curr; //현재 블록 왼쪽 인덱스
		int cr = p[cl] / 100; //현재 블록 오른쪽 인덱스
		char c = p[curr] % 100; //현재 블록 색

		if (!c) continue; //생략 조건
		step++;
		if (cl <= K && K <= cr) break; //종료 조건

		int lh = -1, rh = -1; //왼쪽 블록이 병합된 경우의 헤드 인덱스
		bool lf = true, rf = true; //좌우 블록 유효 플래그

		int lr = cl - 1; //왼쪽 블록 오른쪽 인덱스
		int ll = p[lr] / 100; //왼쪽 블록 왼쪽 인덱스
		int ls = s[ll]; //왼쪽 블록 길이
		char lc = p[ll] % 100; //왼쪽 블록색

		int rl = cr + 1; //오른쪽 블록 왼쪽 인덱스
		int rr = p[rl] / 100; //오른쪽 블록 오른쪽 인덱스
		int rs = s[rl]; //오른쪽 블록 길이
		char rc = p[rl] % 100; //오른쪽 블록색

		//왼쪽 블록 검사
		if (p[ll] / 100 < ll) { //왼쪽 블록이 병합 된 경우
			lh = p[ll] / 100;
			lr = p[lh] / 100;
			ls = s[lh];
			lc = p[lh] % 100;
		}

		if (!ll || !lr) lf = false;

		//오른쪽 블록 검사
		if (rl > N) {
			rf = false;
		}
		else {
			if (rl != p[rr] / 100) {
				rh = p[rr] / 100;
				rs = s[rh];
				rc = p[rh] % 100;
			}
		}

		//양쪽 블록 색상 같으면 병합
		if ((lc == rc) && lf && rf) {
			//기존 헤드를 0가리키도록 (삭제 처리)
			if (lh == -1) p[ll] = 0;
			else p[lh] = 0;
			if (rh == -1) p[rl] = 0;
			else p[rh] = 0;

			s[curr] = ls + rs;
			p[curr] = ll * 100 + lc;
			p[ll] = rr * 100;
			p[rr] = curr * 100;
			push(curr);
		}
		//양쪽 블록 색이 다르면 왼쪽 블록 범위를 현재 블록이랑 합침(병합 아님)
		else {
			p[curr] = 0;
			if (lh == -1) p[cr] = ll * 100;
			else p[cr] = lh * 100;
			p[ll] = cr * 100 + p[ll] % 100;

		}
	}

	printf("%d", step);
	return 0;
}
