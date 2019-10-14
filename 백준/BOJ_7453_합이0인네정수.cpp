#include <iostream>
#include <algorithm>

using namespace std;

int N, map[4000][4];
int ab[16000000], cd[16000000];
	
int main(){
	cin >> N;
	for (int i = 0; i < N; ++i){
		for(int j = 0; j < 4; ++j){
			cin >> map[i][j];
		}
	}
	int index = 0;
	int len = N * N;
	long long answer = 0;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			ab[index] = map[i][0] + map[j][1];
			cd[index] = map[i][2] + map[j][3];
			index++;
		}
	}	
	
	sort(cd, cd + len);
	
	for (int i = 0; i < len; ++i){
		int lowerBound = lower_bound(cd, cd + len, -ab[i]) - cd;
		int upperBound = upper_bound(cd, cd + len, -ab[i]) - cd;
		answer += upperBound - lowerBound;
	}
	cout << answer;
	
	return 0;
}
