#include <iostream>

using namespace std;

int calc(string X);

int main(){
	int T;
	string X;
	cin >> T;
	for (int tc = 1; tc <= T; ++tc){
		cin >> X;
		cout << "#" << tc << " " << calc(X) << '\n';
	}
	return 0;
}
int calc(string X){
	int num[10] = {0, };
	int res = 0;
	for (int i = 0, len = X.length(); i < len; ++i){
		num[X[i] - '0']++;
	}
	for (int i = 0; i < 10; ++i){
		if (num[i] > 0)
			res++;
	}
	return res;
}
