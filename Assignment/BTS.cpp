#include <iostream>
#include <string>
#include <queue>
#include <functional>

using namespace std;

struct Node {
	Node* left;
	Node* right;
	string value;
};
struct cmp {
	bool operator()(string s1, string s2) {
		return s1 > s2;
	}
};

int N;
Node* root;
queue<string> q;
priority_queue<string, vector<string>, greater<string>> pq;

Node* searchBigNode(Node* node) {
	Node* ptr = node;

	if (ptr->right == nullptr) return node;
	else {
		return searchBigNode(ptr->right);
	}
}
Node* searchSmallNode(Node* node) {
	Node* ptr = node;

	if (ptr->left == nullptr) return node;
	else {
		return searchSmallNode(ptr->left);
	}
}


void addTree(string value) {
	Node* node = new Node();
	node->value = value;
	Node* tmpRoot = nullptr;

	if (root == nullptr) {
		root = node;
	}
	else {
		Node* ptr = root;
		while (ptr != nullptr) {
			tmpRoot = ptr;
			if (node->value < ptr->value) {
				ptr = ptr->left;
			}
			else if (node->value.find(ptr->value) != string::npos) {
				return;
			}
			else {
				ptr = ptr->right;
			}
		}
		if (node->value < tmpRoot->value) {
			tmpRoot->left = node;
		}
		else {
			tmpRoot->right = node;
		}

	}
}
Node* deleteTree(Node* node, string value) {

	if (node == nullptr) return nullptr;
	if ((node->value).find(value) != string::npos) {
		Node* ptr = node;
		if (node->right == nullptr && node->left == nullptr) {
			delete node;
			return nullptr;
		}
		else if (node->right == nullptr) {
			ptr = searchBigNode(node->left);
			node->value = ptr->value;
			node->left = deleteTree(node->left, ptr->value);
		}
		else {
			ptr = searchSmallNode(node->right);
			node->value = ptr->value;
			node->right = deleteTree(node->right, ptr->value);
		}
	}
	else if (node->value > value)
		node->left = deleteTree(node->left, value);
	else if (node->value < value)
		node->right = deleteTree(node->right, value);
	return node;
}

void printDepth(Node* curNode, int curDepth, int depth) {
	Node* tmpRoot = root;
	Node* ptr = root;
	if (curDepth == depth) pq.push(curNode->value);
	if (curNode->left != nullptr)
		printDepth(curNode->left, curDepth + 1, depth);
	if (curNode->right != nullptr)
		printDepth(curNode->right, curDepth + 1, depth);
	return;

}
void printLeaf(Node* node) {
	if (node != nullptr) {
		if (node->left != nullptr) {
			printLeaf(node->left);
		}
		if (node->right != nullptr) {
			printLeaf(node->right);
		}
		if (node->left == nullptr && node->right == nullptr) {
			pq.push(node->value);
		}
	}
}
void deleteAll(Node* node) {
	if (node != nullptr) {
		deleteAll(node->left);
		deleteAll(node->right);
		delete node;
	}
}

int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		string op, value;
		int dep;
		cin >> op;
		if (op == "leaf") {
			printLeaf(root);
			while (!pq.empty()) {
				string printTmp;
				printTmp = pq.top();
				cout << printTmp << " ";
				pq.pop();
			}
			cout << endl;
		}
		else if (op == "depth") {
			cin >> dep;
			printDepth(root, 1, dep);
			if (pq.empty()) cout << "NO";
			while (!pq.empty()) {
				string printTmp;
				printTmp = pq.top();
				cout << printTmp << " ";
				pq.pop();
			}
			cout << endl;
		}
		else if (op == "+") {
			cin >> value;
			addTree(value);
		}
		else if (op == "-") {
			cin >> value;
			root = deleteTree(root, value);
		}
	}
	deleteAll(root);

}