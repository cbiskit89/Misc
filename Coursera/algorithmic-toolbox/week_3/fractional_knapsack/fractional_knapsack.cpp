#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;
using std::sort;

double get_optimal_value(int capacity, vector<int> weights, vector<int> values) {
  double value = 0.0;
  // write your code here
  int current_weight = 0;
  if (capacity == 0) { return value; }
  while (current_weight < capacity && values.size() > 0) {
    double greatest_vpw = 0.0; // The highest value per weight item.
    int greatest_vpwi = 0; // The index of the highest value per weight item.
    for (int i = 0; i < weights.size(); ++i) {
      double current_vpw = (double)values[i] / weights[i]; // The highest value per weight seen so far.
      if (current_vpw > greatest_vpw) {
        greatest_vpwi = i;
        greatest_vpw = current_vpw;
      }
    }
    double weight_usable = capacity - current_weight;
    if (weight_usable > weights[greatest_vpwi]) { weight_usable = weights[greatest_vpwi]; }
    value += (values[greatest_vpwi] * (weight_usable / weights[greatest_vpwi]));
    current_weight += weight_usable;
    values.erase(values.begin() + greatest_vpwi);
    weights.erase(weights.begin() + greatest_vpwi);
  }
  return value;
}

int main() {
  int n;
  int capacity;
  std::cin >> n >> capacity;
  vector<int> values(n);
  vector<int> weights(n);
  for (int i = 0; i < n; i++) {
    std::cin >> values[i] >> weights[i];
  }

  double optimal_value = get_optimal_value(capacity, weights, values);

  std::cout.precision(10);
  std::cout << optimal_value << std::endl;
  return 0;
}
