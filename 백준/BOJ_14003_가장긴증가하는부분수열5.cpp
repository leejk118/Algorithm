#include <cstdio>
#include <vector>
#include <stack>

using namespace std;

int N, ary[1000000], info[1000000], index, length;
vector< pair<int, int> > v;

int main(){
	scanf("%d", &N);
	for (int i = 0; i < N; ++i){
		scanf("%d", &ary[i]);
	}
	
	v.push_back({ary[0], 0});
	for (int i = 1; i < N; ++i){
		if (v.back().first < ary[i]){
			info[i] = v[v.size() - 1].second;
			v.push_back({ary[i], i});
			continue;
		}
		index = lower_bound(v.begin(), v.end(), pair<int,int>(ary[i], 0)) - v.begin();
		if (index > 0) info[i] = v[index - 1].second;
		else info[i] = -1;
		v[index].first = ary[i];
		v[index].second = i;
	}
	
	length = v.size();
	printf("%d\n", length);

	stack<int> st;
	int idx = v[v.size() - 1].second;
	for (int i = 0; i < length; ++i){
		st.push(ary[idx]);
		idx = info[idx];
	}
	while(!st.empty()){
		printf("%d ", st.top());
		st.pop();
	}
	return 0;
}
