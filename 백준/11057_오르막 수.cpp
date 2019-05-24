#include <iostream>
using namespace std;

void calc(int (*ary)[10], int N);
int main() {
	int N;
	int ary[1000][10];
	for(int i = 0; i < 10; ++i)	ary[0][i] = 1;
	cin >> N;
	for(int i = 1; i <= N; ++i)	calc(ary, i);
	
	int sum = 0;
	for (int i = 0; i < 10; ++i) {
		sum += ary[N - 1][i];
	}
	cout << sum % 10007 << endl;
	return 0;
}
void calc(int (*ary)[10], int N) {
	if (N == 1) return;
	for (int i = 0; i < 10; i++) {
		int  temp = 0;
		for (int j = i; j < 10; j++) {
			temp += ary[N-2][j];
		}
		ary[N-1][i] = temp % 10007;
	}
	
}
