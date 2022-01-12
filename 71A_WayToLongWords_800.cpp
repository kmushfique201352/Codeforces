#include<stdio.h>
#include<string.h>
int main(){

    int i,n,c=0,m;
    char s[100];
    scanf("%d",&n);
    for(i=1;i<=n;i++){
      scanf("%s",s);
      if(strlen(s)<=10){
        puts(s);
      }
      else {
        printf("%c",s[0]);
        for(int j=0;j<strlen(s);j++){
          c++;
        }
        printf("%d",c-2);
        c=0;
        m=strlen(s)-1;
        printf("%c\n",s[m]);
      }
    }
    return 0;
}
