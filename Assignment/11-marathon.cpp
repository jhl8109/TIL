#include <iostream>
#include <string>

using namespace std;

int N, M;
bool visited[26];
int edge[26][26];
int length = 0;
string mainWay = "";

void backTracking(int dest, int weight,string way) {
	visited[dest] = true;
	int tmpEdge = 0;
	for (int i = 0; i < 26; i++) {		
		if (visited[i]) continue;
		if (edge[i][dest] != 0) tmpEdge = edge[i][dest];
		if (edge[dest][i] != 0) tmpEdge = edge[dest][i];		
		if (tmpEdge != 0 && weight + tmpEdge < 42) {
			string tmp = way + char(i + 'a');
			backTracking(i, weight + tmpEdge, tmp);
			tmpEdge = 0;
		} 
	}
	if (edge[0][dest] + weight == 42 && edge[0][dest] != 0) {
		if (way.length() > length || (way.length() == length && way.compare(mainWay) < 0)) {
			mainWay = way;
			length = mainWay.length();
		}
	}
	visited[dest] = false;
}

int main(void) {
	cin >> N >> M;
	char v1, v2;
	int weight;
	for (int i = 0; i < M; i++) {
		cin >> v1 >> v2 >> weight;
		edge[v1 - 'a'][v2 - 'a'] = weight;
	}
	visited[0] = true;
	backTracking(0,0,"a");
	if (mainWay.empty()) cout << "None" << endl;
	else
		cout << mainWay.length() << endl;
		for (int i = 0; i < mainWay.length(); i++) {
			cout << mainWay[i] << " ";
		}
	cout << endl;
}
