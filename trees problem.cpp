#include<bits/stdc++.h>
using namespace std;
int main(){
    int n,ans=0;
    cin>>n;
    vector<int> a(n);
    vector<int> dp(n,1);
    for(int i=0;i<n;i++) cin>>a[i];
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(a[i]>a[j]) dp[i]=max(dp[i],dp[j]+1);
        }
    }
    for(int i=0;i<n;i++) ans=max(ans,dp[i]);
    cout<<ans;
    return 0;
}
