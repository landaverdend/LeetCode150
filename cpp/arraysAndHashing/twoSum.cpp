#include <iostream>
using namespace std;


class Solution {
  public:
    vector<int> twoSum(vector<int>& nums, int target) {
      unordered_map<int, int> complements;
      vector<int> toRet;

      for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i];
        complements[complement] = i;
      }


      for (int i = 0; i < nums.size(); i++) {
        if (complements.count(nums[i]) && complements[nums[i]] != i) {
          toRet = {complements[nums[i]], i};
          sort(toRet.begin(), toRet.end());
          return toRet;
        }
      }

      return toRet;
    }
};




int main() {

  vector<int> arr = {1, 2, 3, 4, 5, 6};
  int target = 6;

  Solution solution;

  vector<int> sol = solution.twoSum(arr, target);
  cout << "Indices that add to " << target << " are: [";

  for (int num : sol) {
    cout << num << " ";
  }
  cout << "]\n";
  return 1;
}
