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
    for (step = 0; heapSize;) {
        int cur, ptr, l, r, ll, lm = -1, lr, rl, rm = -1, rr, cl = 0, cr, fl = 1, fr = 1, sl, sr;
        cur = pop();
        ptr = p[cur] / 100;
        color = p[cur] % 100;
        if (!color) continue; // merged
        ++step;
        l = ptr <= cur ? ptr : cur;
        r = p[l] / 100;
        if (l <= K && K <= r) break;
        lr = l - 1;
        ll = p[lr] / 100;
        if (p[ll] / 100 < ll) {
            lm = ll;
            cl = p[lm] % 100;
            lr = p[lm] / 100;
            sl = s[lm];
        }
        else {
            cl = p[ll] % 100;
            sl = s[ll];
        }
        if (!lr || !ll) fl = false;

        rl = r + 1;
        if (rl <= N) {
            rr = p[rl] / 100;
            if (p[rr] / 100 ^ rl) {
                rm = p[rr] / 100;
                cr = p[rm] % 100;
                sr = s[rm];
            }
            else {
                cr = p[rl] % 100;
                sr = s[rl];
            }
        }
        else fr = false;

        if (fl && fr && (cl == cr)) { // merge l + r, push l + r as cur
            s[cur] = sl + sr;
            (~lm ? p[lm] : p[ll]) = 0;
            (~rm ? p[rm] : p[rl]) = 0;
            p[cur] = ll * 100 + cl;
            p[ll] = rr * 100;
            p[rr] = cur * 100;
            push(cur);
        }
        else { // merge l + cur
            p[cur] = 0;
            p[r] = (~lm ? lm : ll) * 100;
            p[ll] = r * 100 + p[ll] % 100;
        }
    }

	printf("%d", step);
	return 0;
}
