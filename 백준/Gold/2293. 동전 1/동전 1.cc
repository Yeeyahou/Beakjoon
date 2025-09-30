// 백준_2293_동전1_골드4
// 풀이 실패 ㅠ

#include <iostream>
#include <vector>
#include <string>
#include <iomanip>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, k;
    cin >> n >> k;
    
    vector<int> v(n+1, 0);
    for (int i=0; i<n; i++) {
        cin >> v[i];
    }
    
    int dp[k+1] = {0};
    dp[0] = 1;

    for (int i=0; i<n; i++) {
        for (int j=v[i]; j<=k; j++) {
                dp[j] += dp[j-v[i]];
            
        }
    }
    
    cout << dp[k];
}