#include <iostream>
#include <queue>
using namespace std;

int V, E;
const int MAX = 101;
int map[MAX][MAX] = { 0, };
bool visited[MAX] = { 0, };
int ans = 0;
queue<int> q;

void BFS(int v) {
    visited[v] = true;
    //cout << v << " ";

    q.push(v);
    while (!q.empty()) {
        v = q.front();
        q.pop();
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0 && map[v][i] == 1) {
                q.push(i);
                visited[i] = true;
                ans++;
                //cout << i << " ";
            }
        }

    }
}

int main() {
    cin >> V >> E;
    for (int i = 0; i < E; i++) {
        int a, b;
        cin >> a >> b;
        map[a][b] = 1;
        map[b][a] = 1;
    }

    BFS(1);

    cout << ans;
}
