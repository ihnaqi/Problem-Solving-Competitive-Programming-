// #include <iostream>
// #include <string>
// #include <bits/stdc++.h>

// bool check(std::string str, int index)
// {

//    if ((str[index] == 'R' && str[index + 1] == 'B' && str[index + 2] == 'L') || (str[index] == 'R' && str[index + 1] == 'L' && str[index + 2] == 'B') || (str[index] == 'B' && str[index + 1] == 'R' && str[index + 2] == 'L') || (str[index] == 'B' && str[index + 1] == 'L' && str[index + 2] == 'R') || (str[index] == 'L' && str[index + 1] == 'R' && str[index + 2] == 'B') || (str[index] == 'L' && str[index + 1] == 'B' && str[index + 2] == 'R'))
//    {
//       return true;
//    }
//    return false;
// }
// int main()
// {

//    time_t start, end;
//    time(&start);
//    std::ios_base::sync_with_stdio(false);

//    std::string input;
//    std::cin >> input;

//    std::string result;
//    int i = 0;

//    while (i < input.length())
//    {
//       if (i + 2 < input.length() && check(input, i))
//       {
//          result = result + "C";
//          i = i + 3;
//       }
//       else if (input[i] == 'R')
//       {
//          result = result + "S";
//          i = i + 1;
//       }
//       else if (input[i] == 'B')
//       {
//          result = result + "K";
//          i = i + 1;
//       }
//       else if (input[i] == 'L')
//       {
//          result = result + "H";
//          i = i + 1;
//       }

//       else
//       {
//          i = i + 1;
//       }
//    }

//    std::cout << result;
//    time(&end);
//    std::cout << (start - end);

//    return 0;
// }

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