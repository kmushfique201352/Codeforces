#include<iostream>
using namespace std;
int main(){

  int x[5][5],mark=0,m;

  for(int i=0;i<5;i++){
    for(int j=0;j<5;j++){
      cin>>x[i][j];
    }
  }
  for(int i=0;i<5;i++){
    for(int j=0;j<5;j++){
        if(x[2][2]==1){
          m=0;
        }else if(x[1][2]==1||x[2][1]==1||x[2][3]==1||x[3][2]==1){
          m=1;
        }else if(x[0][2]==1||x[2][0]==1||x[2][4]==1||x[4][2]==1){
          m=2;
        }else if(x[1][1]==1||x[1][3]==1||x[3][1]==1||x[3][3]==1){
          m=2;
        }else if(x[0][1]==1||x[0][3]==1||x[1][0]==1||x[1][4]==1||x[3][0]==1||x[3][4]==1||x[4][1]==1||x[4][3]==1){
          m=3;
        }else if(x[0][0]==1||x[0][4]==1||x[4][0]==1||x[4][4]==1){
          m=4;
        }
    }
  }
  cout<<m<<endl;

  return 0;
}
