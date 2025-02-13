
#include <iostream>
#include <vector>

using namespace std;

class Solution {
  public:
    int search(vector<int>& nums, int target) {
      int l = 0;
      int r = nums.size() - 1;


      // 0, 1, 2, 3, 4
      while (l <= r) {
        int m = (r - l) / 2 + l;

        if (nums[m] == target) {
          return m;
        }
        else if (nums[m] > target) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }

      return -1;
    }
};


int main() {

  vector<int> input = {0, 1, 2, 3, 4, 5};
  int target = 4;
  
  Solution s;

  cout << "For array [";
  copy(input.begin(), input.end(), ostream_iterator<int>(cout, " "));
  cout << "] and target "<< target << endl;

  cout << "Index is: " << s.search(input, target) << endl; 

  return 0;
}
