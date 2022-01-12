#include<iostream>
using namespace std;
int main(){
  int a,b,count=0,x,mark=0;
  int arr[100];
  cin>>a>>b;
  for(int i=0;i<a;i++){
    cin>>arr[i];
  }
  for(int i=0;i<a;i++){
    if(arr[i]>=arr[b-1]&&arr[i]>0){
      count++;
    }
  }
  cout<<count;
  return 0;
}
