#include <stdio.h>
#include <vector>

using namespace std;

struct Vertex {
	int t;
	int d; 
};

int main() {
	
	int N, M;
	int a,b,c;
	vector<Vertex> list[1001];
	
	freopen("inputs/1922.txt","r",stdin);
	
	scanf("%d",&N);
	scanf("%d",&M);
	
	
	for(int i = 0; i < N ; i++) {
		scanf("%d %d %d",&a, &b, &c);
		list[a].push_back(Vertex(b,c))
	}
	
	
	printf(N);
	
	
	
}
