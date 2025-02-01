#include <iostream>
#include <set>
using namespace std;


class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
      set<int> s;
      
      for (int i : nums) {
        if (s.find(i) != s.end())
            return true;
        s.insert(i);
      }
      
      return false;

    }
};




int main() {
    std::vector<int> in = {1, 2, 3, 4, 5, 5};

    Solution solution;
    
    cout << "Input contains duplicate?? " << solution.containsDuplicate(in) << endl;

    return 0;
}
