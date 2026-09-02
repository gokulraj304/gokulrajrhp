#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {
    int n, q;
    cin >> n >> q;

    vector<int> a(n + 1);

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    vector<int> lg(n + 1);
    for (int i = 2; i <= n; i++) {
        lg[i] = lg[i / 2] + 1;
    }

    int K = lg[n] + 1;

    vector<vector<int>> st(K, vector<int>(n + 1));

    for (int i = 1; i <= n; i++) {
        st[0][i] = a[i];
    }

    for (int k = 1; k < K; k++) {
        for (int i = 1; i + (1 << k) - 1 <= n; i++) {
            st[k][i] = min(st[k - 1][i],
                           st[k - 1][i + (1 << (k - 1))]);
        }
    }

    while (q--) {
        int l, r;
        cin >> l >> r;

        int len = r - l + 1;
        int k = lg[len];

        cout << min(st[k][l],
                    st[k][r - (1 << k) + 1]) << '\n';
    }

    return 0;
}
