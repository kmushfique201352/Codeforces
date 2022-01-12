#include<stdio.h>
#include<string.h>
int main(){

    int i,n;
    char s[100];
    scanf("%s",s);
    n=strlen(s);
    for(i=0;i<n;i++){
      if(s[i]=='a'||s[i]=='o'||s[i]=='y'||s[i]=='e'||s[i]=='u'||s[i]=='i'||s[i]=='A'||s[i]=='O'||s[i]=='Y'||s[i]=='E'||s[i]=='U'||s[i]=='I'){
        continue;
      }
      else {
        printf(".");
        if(s[i]>='A'&&s[i]<='Z'){
          printf("%c",s[i]+32);
        }
        else printf("%c",s[i]);
      }
    }

    return 0;
}
