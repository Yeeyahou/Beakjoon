#include <cstdio>

const int LEN = 10000001;
int N, K, i;
int _h, h[LEN];
int p[LEN], s[LEN];
char c;

bool comp(int x, int y) { return s[x] > s[y] || s[x] == s[y] && x < y; }

void push(int x) {
   int j, y;
   h[++_h] = x;
   j = _h;
   while (j > 1 && comp(x, y = h[j >> 1])) {
      h[j] = y; h[j >> 1] = x;
      j >>= 1;
   }
}
int pop() {
   int j, l, r, m, top = h[1];
   h[1] = h[_h--];
   j = 1;
   while (j < _h) {
      m = j;
      l = j << 1;
      r = j << 1 | 1;
      if (l <= _h && comp(h[l], h[j])) m = l;
      if (r <= _h && comp(h[r], h[m])) m = r;
      if (m ^ j) {
         l = h[m]; h[m] = h[j];
         h[j] = l; j = m;
      }
      else break;
   }
   return top;
}

int main() {
   scanf("%d%d", &N, &K);
   scanf(" %c", &c);
   p[1] = 100 + c;
   s[1] = 1;
   for (i = 2; i <= N; ++i) {
      scanf("%c", &c);
      if (p[i - 1] % 100 == c) {
         p[i] = p[i - 1];
         p[p[i] / 100] = i * 100 + c;
         ++s[p[i] / 100];
      }
      else {

         push(p[i - 1] / 100);
         p[i] = i * 100 + c;
         s[i] = 1;
      }
   }
   push(p[N] / 100);

   for (i = 0; _h;) {
      int cur, ptr, l, r, ll, lm = -1, lr, rl, rm = -1, rr, cl = 0, cr, fl = 1, fr = 1, sl, sr;
      cur = pop();
      ptr = p[cur] / 100;
      c = p[cur] % 100;
      if (!c) continue; // merged
      ++i;
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
   printf("%d", i);

   return 0;
}