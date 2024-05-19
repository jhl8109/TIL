#include <iostream>

using namespace std;

class Position { 
	int data;
	Position* leftChild;
	Position* rightChild;
	Position* parentChild;
public:
	Position(int _data=NULL, Position* _parent = NULL, Position* _right = NULL, Position* _left = NULL) : data(_data), leftChild(_left), rightChild(_right), parentChild(_parent) {};
	Position* left() const;
	Position* right() const;
	Position* parent() const;
	bool isRoot() const;
	bool isExternal() const;
	int getData() const;
};
Position* Position::left() const {
	return leftChild;
}
Position* Position::right() const {
	return rightChild;
}
Position* Position::parent() const {
	return parentChild;
}
bool Position::isRoot() const {
	if (parentChild == NULL) return true;
	else return false;
}
bool Position::isExternal() const  {
	if (leftChild == NULL && rightChild == NULL) return true;
	else return false;
}
int Position::getData() const {
	return data;
}

class BinaryTree { 
public: 
	Position position; 
	Position* positionList; 
	int _size;
public: 
	BinaryTree(Position _position);
	~BinaryTree();
	int size() const;
	bool empty() const;
	Position root() const;
	Position* positions() const;
	void insert(Position pos);
};
BinaryTree::BinaryTree(Position _position) : position(_position) {
	positionList = new Position[10000];
	insert(_position);
	
};
BinaryTree::~BinaryTree() {
	delete []positionList;
}
int BinaryTree::size() const {
	return _size;
};
bool BinaryTree::empty() const {
	if (_size == 0) return true;
	else return false;
};
Position BinaryTree::root() const {
	return  positionList[0];
};
Position* BinaryTree::positions() const {
	return positionList;
};
void BinaryTree::insert(Position pos) {
	positionList[_size++] = pos;
}


int main(void)
{
	Position a(1);
	Position b(2, &a);
	Position c(3, &a);
	BinaryTree tree(Position(1, NULL,&a, &b));
	tree.insert(b);
	tree.insert(c);
	cout << "size : " <<tree.size() << endl;;
	cout << "is root? : " << tree.positionList[0].isRoot()<<endl;
	cout << "is empty? : " << tree.empty() << endl;
	cout << "root : " << (tree.root()).getData() << endl;
}
