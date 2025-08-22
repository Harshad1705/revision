#include<iostream>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;

    vector<int> adj[N + 1];

    for (int i = 0; i < m; i++){
        int u, v;
        adj(u).push_back(v);
        adj(v).push_back(u);
    }
    return 0;
}

// In Undirected Graph
// Space Complexity = O(2*Edges)

// In Directed Graph
// Space Complexity = O(Edges)
