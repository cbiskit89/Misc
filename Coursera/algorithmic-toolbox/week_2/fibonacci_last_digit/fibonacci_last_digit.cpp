#include <iostream>

int get_fibonacci_last_digit(int n) {
  //write your code here
  int a = 0;
  int b = 1;
  int fib = 1;
  for (int i = 1; i < n; ++i) {
    fib = (a + b) % 10;
    a = b;
    b = fib;
  }
  return b;
}

int main() {
  int n;
  std::cin >> n;
  int c = get_fibonacci_last_digit(n);
  std::cout << c << '\n';
}
