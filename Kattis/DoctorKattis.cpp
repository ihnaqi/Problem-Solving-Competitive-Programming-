#include <bits/stdc++.h>

struct Cat
{
   int arrivalTime;
   std::string name;
   int infectionLevel;

   bool operator<(const Cat &d) const
   {
      if (infectionLevel != d.infectionLevel)
         return infectionLevel > d.infectionLevel;
      return arrivalTime < d.arrivalTime;
   }
};

int main()
{

   std::ios_base::sync_with_stdio(false);

   int n;
   std::cin >> n;
   std::set<Cat> cats;
   std::map<std::string, std::pair<int, int>> mapValues;
   int catsCount = 0;
   while (n-- > 0)
   {
      int command;
      std::cin >> command;

      if (command == 0)
      {
         Cat cat;
         std::string name;
         int infection;
         std::cin >> name >> infection;
         // scanf("%s", &name);
         // scanf("%d", &infection);
         cat.arrivalTime = catsCount++;
         cat.infectionLevel = infection;
         cat.name = name;

         cats.insert(cat);
         mapValues[name] = {catsCount - 1, infection};
      }

      else if (command == 1)
      {
         std::string name;
         int infection;
         std::cin >> name >> infection;
         Cat cat;
         cat.name = name;
         cat.infectionLevel = mapValues[name].second;
         cat.arrivalTime = mapValues[name].first;

         auto it = cats.find(cat);
         auto old = *it;
         cats.erase(it);
         old.infectionLevel += infection;
         cats.insert(old);

         mapValues[name].second = old.infectionLevel;
      }
      else if (command == 2)
      {

         std::string name;
         std::cin >> name;

         Cat cat;
         cat.name = name;
         cat.arrivalTime = mapValues[name].first;
         cat.infectionLevel = mapValues[name].second;

         cats.erase(cats.find(cat));
      }
      else
      {

         if (cats.empty())
         {
            std::cout << "The clinic is empty" << std::endl;
         }
         else
         {
            std::cout << (*cats.begin()).name << std::endl;
         }
      }
   }

   return 0;
}