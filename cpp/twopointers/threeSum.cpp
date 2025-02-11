#include <iostream>
#include <vector> 
using namespace std;

class Solution {
  public:
    vector<vector<int>> threeSum(vector<int>& nums) {

      vector<vector<int>> toRet;
      // Step one: Sort the input array. For this algorithm to work our input must be sorted.
      sort(nums.begin(), nums.end());



      // For the sorted array, we need to iterate from left to right.
      // 'i' will serve as the anchor point.
      for (int i = 0; i < nums.size(); i++) {

        int l = i + 1;
        int r = nums.size() - 1;

        while (l < r) {
          int sum = nums[i] + nums[l] + nums[r];
          if (sum == 0) {
            toRet.push_back({nums[i], nums[l], nums[r]});
            // in order to prevent duplicates, keep iterating while l is the same as the current element.
            while (l + 1 < nums.size() && nums[l + 1] == nums[l] ) {
              l++;
            }

            r--;
            l++;
          }
          else if (sum < 0) {
            l++;
          } else {
            r--;
          }
        }

        while (i + 1 < nums.size() && nums[i] == nums[i + 1]) i++; 
      }

      return toRet;
    }
};


int main() {
  Solution s;
  vector<int> input = {-1, 0, 1, 2, -1, -4};
  cout << "For input: [";
  copy(input.begin(), input.end(), ostream_iterator<int>(cout, " " ));
  cout << "]" << endl;

  vector<vector<int>> res = s.threeSum(input);

  cout << "Solutions: [";

  for (vector<int> vec : res) { 
    cout << "[";
    copy(vec.begin(), vec.end(), ostream_iterator<int>(cout, " "));

    cout << "]" << endl;
  }
  cout << "]";
}
