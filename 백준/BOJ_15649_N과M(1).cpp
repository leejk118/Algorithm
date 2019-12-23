#include <cstdio>
#include <vector>

#define NUM 9

using namespace std;

int N, M;
bool isVisited[NUM];
vector<int> vc;

using namespace std;

void input() {	
	scanf("%d %d", &N, &M);
}
void backtrack(int count) {
	if (count == M) {
		for (int i = 0; i < M; ++i) {
			printf("%d ", vc[i]);
		}
		printf("\n");
		return ;
	}
	for (int i = 1; i <= N; ++i) {
		if (isVisited[i]) continue;
		isVisited[i] = true;
		vc.push_back(i);
		backtrack(count + 1);
		isVisited[i] = false;
		vc.pop_back();
	}
}

int main() {
	input();
	backtrack(0);
	return 0;
}