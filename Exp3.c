#include<stdio.h>
#include<string.h>

int main()
{
 int i=0,count=0;
 char databits[50];

 printf("Enter Data Charactres: ");
 scanf("%s",databits);

 printf("Data Byte Before Bit Stuffing:%s",databits);

 printf("\nData Byte After Bit stuffing :");
 printf("F");

 for(i=0; i<strlen(databits); i++)
 {
    if(databits[i]=='E')
    {
        printf("EE");
    }
    else if(databits[i]=='F')
    {
        printf("EF");
    }
    else
        printf("%c",databits[i]);
 }
  printf("F");
 return 0;
}