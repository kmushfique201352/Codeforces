#include<iostream>
#include<string>
#include<algorithm>

using namespace std;
int main(){

  string x;
  char a[20];
  int j=0,i1=0,i2=0,i3=0;

  cin>>x;

  for(int i=0;i<x.size();i++){
    if(x[i]!='+'){
      a[j]=x[i];
      j++;
    }
  }
  sort(a,a+j);
  // 1 1 1 1 2 2 3 3 3
  for(int i=0;i<j;i++){
    cout<<a[i];
    if(i!=j-1){
      cout<<'+';
    }
  }

  return 0;
}
