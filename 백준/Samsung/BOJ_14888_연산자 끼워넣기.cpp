#include <cstdio>
#include <algorithm>

using namespace std;

int N, A[100], op[4];
enum { PLUS, MINUS, MULTIPLY, DIVIDE };
int maxValue = -1000000001, minValue = 1000000001;

void input();
void dfs(int count, int sum);
void output();

int main() {
	input();
	dfs(1, A[0]);
	output();
	return 0;
}

void input() {
	scanf("%d", &N);
	for (int i = 0; i < N; ++i) {
		scanf("%d", &A[i]);
	}
	for (int i = 0; i < 4; ++i) {
		scanf("%d", &op[i]);
	}
}
void dfs(int count, int sum) {
	if (count == N) {
		maxValue = max(maxValue, sum);
		minValue = min(minValue, sum);
		return ;
	}
	for (int i = 0; i < 4; ++i) {
		int temp = sum;
		if (op[i]) {
			op[i]--;
			switch (i) {
				case PLUS: sum += A[count]; break;
				case MINUS: sum -= A[count]; break;
				case MULTIPLY: sum *= A[count]; break;
				case DIVIDE: sum /= A[count]; break;	
				default: break;
			}
			dfs(count + 1, sum);
			op[i]++;
			sum = temp;
		}
	}
}
void output() {
	printf("%d\n%d\n", maxValue, minValue);
}
