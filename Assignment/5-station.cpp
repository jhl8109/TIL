#include <iostream>
#include <tuple>
#include <math.h>
using namespace std;

tuple<double, double, double> coordinates[4], tmp[4];
tuple<double, double, double> check[2];
double dis_x1, dis_y1, dis_z1, dis_x2, dis_y2, dis_z2, dis_min, dis_min_tmp, sum1, sum2;

void getC() {
	dis_x1 = pow(abs(get<0>(tmp[0]) - get<0>(tmp[2])), 2);
	dis_y1 = pow(abs(get<1>(tmp[0]) - get<1>(tmp[2])), 2);
	dis_z1 = pow(abs(get<2>(tmp[0]) - get<2>(tmp[2])), 2);
	sum1 = dis_x1 + dis_y1 + dis_z1;
}
void getD() {
	dis_x2 = pow(abs(get<0>(tmp[0]) - get<0>(tmp[3])), 2);
	dis_y2 = pow(abs(get<1>(tmp[0]) - get<1>(tmp[3])), 2);
	dis_z2 = pow(abs(get<2>(tmp[0]) - get<2>(tmp[3])), 2);
	sum2 = dis_x2 + dis_y2 + dis_z2;
}
void minDist() {
	getC();
	getD();
}

void solveA() {
	while (true) {
		minDist();

		if (sum1 == 0 || sum2 == 0) break;
		if ((abs(get<0>(tmp[2])-get<0>(tmp[3])) <=0.5) &&
			(abs(get<1>(tmp[2])-get<1>(tmp[3])) <=0.5) &&
			(abs(get<2>(tmp[2])-get<2>(tmp[3])) <=0.5) &&
            ceil(sum1) == ceil(sum2) &&
            abs(sum1- sum2)<= 0.001) break;
		if (sum1 < sum2) {
			tmp[3] = make_tuple(
				(get<0>(tmp[2]) + get<0>(tmp[3])) / 2.0,
				(get<1>(tmp[2]) + get<1>(tmp[3])) / 2.0,
				(get<2>(tmp[2]) + get<2>(tmp[3])) / 2.0);
		}
		else {
			tmp[2] = make_tuple(
				(get<0>(tmp[3]) + get<0>(tmp[2])) / 2.0,
				(get<1>(tmp[3]) + get<1>(tmp[2])) / 2.0,
				(get<2>(tmp[3]) + get<2>(tmp[2])) / 2.0);
		}
	}
}


void solveB() {
	bool checkLine = false;
	dis_min_tmp = 2000000000;
    dis_min = 2000000001;

	while (abs(dis_min_tmp - dis_min) > 0.001 || ceil(dis_min_tmp) != ceil(dis_min)) {
		solveA();
		if (sum1 < sum2) {
            tmp[0] = tmp[2];
            tmp[1] = tmp[3];
            if (!checkLine) {
                dis_min = min(dis_min,sum1);
                tmp[2] = coordinates[0];
                tmp[3] = coordinates[1];
                checkLine = true;
            }
            else {
                dis_min_tmp = min(dis_min_tmp,sum1);
                tmp[2] = coordinates[2];
                tmp[3] = coordinates[3];
                checkLine = false;
            }
		}
		else {
		    tmp[0] = tmp[3];
		    tmp[1] = tmp[2];
            if (!checkLine) {
                dis_min = min(dis_min,sum2);
                tmp[2] = coordinates[0];
                tmp[3] = coordinates[1];
                checkLine = true;
            }
            else {
                dis_min_tmp = min(dis_min_tmp,sum2);
                tmp[2] = coordinates[2];
                tmp[3] = coordinates[3];
                checkLine = false;
            }
		}
	}
	cout << ceil(sqrt(min(dis_min,dis_min_tmp))) << endl;
}


int main() {
	double x, y, z;
	for (int i = 0; i < 4; i++) {
		cin >> x >> y >> z;
		coordinates[i] = make_tuple(x, y, z);
	}
	for (int i = 0; i < 4; i++) tmp[i] = coordinates[i];

	solveB();
}
