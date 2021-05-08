#include <iostream>

int gcd(int a, int b) {
  //write your code here
  int mod = 1;
  while (mod != 0) {
    mod = a % b;
    // std::cout << mod << std::endl;
    if (mod == 0) {
      return b;
    }
    a = b;
    b = mod;
  }
}

int main() {
  int a, b;
  std::cin >> a >> b;
  std::cout << gcd(a, b) << std::endl;
  return 0;
}
