#include <iostream>

int get_change(int n) {
  //write your code here
  int coins = 0;
  while (n > 0) {
    if (n - 10 >= 0) {
      ++coins;
      n -= 10;
    }
    else if (n - 5 >= 0) {
      ++coins;
      n -= 5;
    }
    else if (n - 1 >= 0) {
      ++coins;
      n -= 1;
    }
  }
  return coins;
}

int main() {
  int n;
  std::cin >> n;
  std::cout << get_change(n) << '\n';
}
