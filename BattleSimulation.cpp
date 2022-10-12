#include <iostream>
#include <cstring>

char s[1000005];
char str[1000005];

int main()
{

   int input;
   scanf("%s", s);

   int len = strlen(s);

   input = 0;

   for (int i = 0; i < len;)
   {
      if ((s[i] == 'R' && s[i + 1] == 'B' && s[i + 2] == 'L') || (s[i] == 'R' && s[i + 1] == 'L' && s[i + 2] == 'B') || (s[i] == 'B' && s[i + 1] == 'R' && s[i + 2] == 'L') || (s[i] == 'B' && s[i + 1] == 'L' && s[i + 2] == 'R') || (s[i] == 'L' && s[i + 1] == 'R' && s[i + 2] == 'B') || (s[i] == 'L' && s[i + 1] == 'B' && s[i + 2] == 'R'))
      {
         str[input++] = 'C';
         i = i + 3;
         if (i == len)
         {
            break;
         }
         continue;
      }
      else if (s[i] == 'R')
      {
         str[input++] = 'S';
      }
      else if (s[i] == 'B')
      {
         str[input++] = 'K';
      }
      else if (s[i] == 'L')
      {
         str[input++] = 'H';
      }

      i = i + 1;
   }
   str[input] = '\0';
   printf("%s\n", str);

   return 0;
}