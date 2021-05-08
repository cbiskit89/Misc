#include <iostream>

int calc_fib(int n) {
    if (n <= 1)
        return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
}

int calc_fib_faster(int n) {
    if (n <= 1)
      return n;

    int a = 0;
    int b = 1;
    int fib = 1;
    for (int i = 1; i < n; ++i) {
        fib = a + b;
        a = b;
        b = fib;
    }
    return b;
}

int main() {
    int n = 0;
    std::cin >> n;

    // std::cout << calc_fib(n) << '\n';
    std::cout << calc_fib_faster(n) << '\n';
    return 0;
}
