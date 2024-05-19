#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
#include <vector>

using namespace std;

int N, M;
bool visited[26];
int edge[26][26];
int bfsEdge[26][26];
int maxWeight = 0;
vector<int> banList;

bool bfs(int start) {
	queue <int> q;
	bool bfsVisited[26] = { false, };
	for (int i = 0; i < 26; i++) {
		bfsVisited[i] = visited[i];
	}
	
	int tmpEdge = 0, vertex = 0;
	q.push(start);
	while (!q.empty()) {
		vertex = q.front();
		q.pop();
		bfsVisited[vertex] = true;
		if (bfsEdge[0][vertex] != 0) return true;
		for (int i = 0; i < 26; i++) {
			if (bfsVisited[i]) continue;
			if (bfsEdge[i][vertex] != 0) tmpEdge = bfsEdge[i][vertex];
			if (bfsEdge[vertex][i] != 0) tmpEdge = bfsEdge[vertex][i];
			if (tmpEdge != 0) {
				q.push(i);
				tmpEdge = 0;
			}
		}
	}
	return false;
}
void backTracking(int dest, int weight) {
	int tmpEdge = 0, count = 0,edgeSum = 0;
	if (edge[0][dest] != 0) {
		int tmp = weight + edge[0][dest];
		if (tmp > maxWeight) {
			maxWeight = tmp;
		}
	}
	for (int i = 0; i < banList.size(); i++) {
		if (!visited[banList[i]]) break;
		if (i == banList.size() - 1) return;
	}
	visited[dest] = true;
	for (int i = 0; i < 26; i++) {
		if (visited[i]) continue;
		if (edge[i][dest] != 0) tmpEdge = edge[i][dest];
		if (edge[dest][i] != 0) tmpEdge = edge[dest][i];
		if (tmpEdge != 0) {
			bfsEdge[i][dest] = 0;
			bfsEdge[dest][i] = 0;
			if (!bfs(i)) {
				bfsEdge[i][dest] = edge[i][dest];
				bfsEdge[dest][i] = edge[dest][i];
				tmpEdge = 0;
				continue;
			}
			backTracking(i, weight + tmpEdge);
			bfsEdge[i][dest] = edge[i][dest];
			bfsEdge[dest][i] = edge[dest][i];
			visited[i] = false;
			tmpEdge = 0;
			edgeSum = 0;
		}
	}
	
}


int main(void) {
	cin >> N >> M;
	char v1, v2;
	int weight;
	
	for (int i = 0; i < M; i++) {
		cin >> v1 >> v2 >> weight;
		edge[v1 - 'a'][v2 - 'a'] = weight;
		bfsEdge[v1 - 'a'][v2 - 'a'] = weight;
	}
	for (int i = 0; i < 26; i++) {
		if (edge[0][i] != 0) banList.push_back(i);
	}
	backTracking(0,0);
	cout << maxWeight << endl;
}
