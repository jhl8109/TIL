#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

bool used[50] = { false, };
int N, bp, bf, bc, bv, total, minPrice = 1000000;

struct nutri {
	vector<int> index; int pro; int fat; int carb; int vit; int price;
	nutri() {
		this->pro = 0; this->fat = 0; this->carb = 0; this->vit = 0; this->price = 1000000;
	}
	nutri(vector<int> index, int pro, int fat, int carb, int vitamin, int price) {
		this->index = index;
		this->pro = pro; this->fat = fat; this->carb = carb; this->vit = vitamin; this->price = price;
	}
	nutri operator+(nutri& a) {
		vector<int> test = this->index;
		bool check = false;
		for (int i = 0; i < a.index.size(); i++) {
			for (int j = 0; j < this->index.size(); j++) if (this->index[j] == a.index[i])  check = true;
			if (!check) test.push_back(a.index[i]);
		}
		return nutri(test, this->pro + a.pro, this->fat + a.fat, this->carb + a.carb, this->vit + a.vit, this->price + a.price);
	}
};
nutri nt[50], nt2[50], answer = nutri(), tmp;


struct cmp {
	bool operator()(nutri& a, nutri& b) {
		if (bp + bf + bc + bv - a.pro - a.fat - a.carb - a.vit == bp + bf + bc + bv - b.pro - b.fat - b.carb - b.vit) return a.price > b.price;
		else return bp + bf + bc + bv - a.pro - a.fat - a.carb - a.vit > bp + bf + bc + bv - b.pro - b.fat - b.carb - b.vit;
	}
};
bool compare(nutri a, nutri b) {
	if (bp + bf + bc + bv - a.pro - a.fat - a.carb - a.vit == bp + bf + bc + bv - b.pro - b.fat - b.carb - b.vit) return a.price < b.price;
	else return bp + bf + bc + bv - a.pro - a.fat - a.carb - a.vit < bp + bf + bc + bv - b.pro - b.fat - b.carb - b.vit;
}

priority_queue<nutri, vector<nutri>, cmp> pq;

bool isAnswer(nutri check) {
	if (check.pro >= bp && check.fat >= bf && check.carb >= bc && check.vit >= bv) {
		if (answer.price >= check.price) {
			if (check.price == answer.price) {
				int sum1 = answer.pro + answer.fat + answer.carb + answer.vit;
				int sum2 = check.pro + check.fat + check.carb + check.vit;
				if (sum1 == sum2 && answer.index > check.index) answer = check;
				if (sum1 < sum2) answer = check;
			}
			else answer = check;
		}return true;
	}return false;
}
void solve() {
	tmp = pq.top();
	while (!pq.empty()) {
		int index = 0, big = 0, small = 1000000;
		memset(used, false, N);	
		for (int i = 0; i < tmp.index.size(); i++) {
			for (int j = 0; j < N; j++) {
				if (nt[j].index[0] == tmp.index[i]) {
					index = j;
					break;
				}
			}
			big = max(big, index);
			used[(tmp.index[i])] = true;
		}
		for (int i = big + 1; i < N; i++) {
			small = min(small, nt[i].price);
		}
		if (tmp.price + small > answer.price || isAnswer(tmp)) {
			tmp = pq.top();
			pq.pop();
			continue;
		}
		for (int i = big + 1; i < N; i++) {
			if (!used[(nt[i].index[0])] && tmp.price + nt[i].price <= answer.price) {
				nutri test = tmp + nt[i];
				if (!isAnswer(test)) pq.push(test);
			}
		}
		tmp = pq.top();
		pq.pop();
	}
}
int main() {
	int p, f, c, v, pr, sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
	vector<int> index;
	cin >> N;
	cin >> bp >> bf >> bc >> bv;
	for (int i = 0; i < N; i++) {
		cin >> p >> f >> c >> v >> pr;
		if (minPrice > pr) minPrice = pr;
		total += pr;
		sum1 += p; sum2 += f; sum3 += c; sum4 += v;
		vector<int> tmp;
		tmp.push_back(i);
		index.push_back(i);
		nt[i] = nutri(tmp, p, f, c, v, pr);
		pq.push(nt[i]);

	}
	if (sum1 < bp || sum2 < bf || sum3 < bc || sum4 < bv) {
		cout << "0" << endl;
		return 0;
	}
	else {
		answer = nutri(index, sum1, sum2, sum3, sum4, total);
	}
	sort(nt, nt + N, compare);
	solve();
	priority_queue<int, vector<int>, greater<int> > pq;
	for (int i = 0; i < answer.index.size(); i++) pq.push(answer.index[i]);
	for (int i = 0; i < answer.index.size(); i++) {
		cout << pq.top() + 1 << " ";
		pq.pop();
	}
}
