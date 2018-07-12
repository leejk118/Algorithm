# BaekJoon 11399 ATM
```
#include <iostream>
using namespace std;

void quicksort(int v[], int n);
void swap(int v[], int i, int j);

int main() {
	int N, P[1001], sum = 0;
	cin >> N;
	for (int i = 1; i <= N; ++i) cin >> P[i];
	quicksort(P, N + 1);
	for (int i = 1; i <= N; ++i) {
		sum += P[i] * (N - i + 1);
	}
	cout << sum;
	return 0;
}

void quicksort(int v[], int n){
	int i, last;
	if (n <= 1) return;
	swap(v, 0, rand() % n);
	last = 0;
	for (i = 0; i < n; ++i) {
		if (v[i] < v[0])	swap(v, ++last, i);
	}
	swap(v, 0, last);
	quicksort(v, last);
	quicksort(v +last + 1, n - last - 1);
}

void swap(int v[], int i, int j) {
	int temp;

	temp = v[i];
	v[i] = v[j];
	v[j] = temp;
}
```
