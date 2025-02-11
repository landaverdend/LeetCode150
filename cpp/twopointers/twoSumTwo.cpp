#include <string>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
  public:
    vector<int> twoSum(vector<int>& numbers, int target) {
      vector<int> toRet = {};

      int l = 0; int r = numbers.size() - 1;

      while (l < r) {
        int sum = numbers[l] + numbers[r];

        if (sum == target) {
          toRet = {++l, ++r};
          return toRet;
        }
        else if (sum > target) {
          r--;
        }
        else {
          l++;
        }

      }

      return toRet;
    }
};



int main() {

  Solution s;
  
  vector<int> numbers = { -2, 1, 3, 5, 6, 7, 9, 10};
  int target = 5;


  cout << "The elements that add up to target " << target << " are: "; 
  vector<int> res = s.twoSum(numbers, target);
  copy(res.begin(), res.end(), ostream_iterator<int>(cout, ", " ));
  cout << endl;

  return 0;
}

