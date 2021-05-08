#include <iostream>

long long get_period(long long n, long long m) {
  long long period = 2;
  long long x, a = 1;
  long long b = 2;
  int i = 2;
  while (true) {
    x = a;
    a = b;
    b = a + x;
    if ((x % m == 0) && (a % m == 1)) {
      break;
    }
    ++period;
    ++i;
  }
  return period;
}

long long get_fibonaccihuge(long long n, long long m) {
  //write your code here
  if (n <= 1)
    return n % m;
  long long a = 0;
  long long b = 1;
  long long fib = 1;
  long long per = get_period(n, m);
  long long index = n % per;
  for (int i = 1; i < index; ++i) {
    fib = a + b;
    a = b;
    b = fib;
  }
  std::cout << b << " " << index << " " << per << std::endl;
  if (index <= 1)
    return index % m;
  return b % m;
}

int main() {
  long long n, m;
  std::cin >> n >> m;
  std::cout << get_fibonaccihuge(n, m) << '\n';
}
