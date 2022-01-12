#include <stdio.h>
int main()
{
    int n,a1=0,a2=0,a3=0,i,x=0;
    scanf("%d",&n);
    for(i=0;i<n;i++){
      scanf("%d%d%d",&a1,&a2,&a3);
      if(a1&&a2&&a3==1){
        x++;
      }
      else if(a1&&a2==1||a1&&a3==1||a2&&a3==1){
        x++;
      }
    }
    printf("%d",x);
    return 0;
}
