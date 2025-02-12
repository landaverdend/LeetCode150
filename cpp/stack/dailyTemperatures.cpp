#include <vector>
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
      
      vector<int> toRet(temperatures.size());
      stack<pair<int, int>> theStack;


      for (int i = 0; i < temperatures.size(); i++) {
        
        if (theStack.empty()) {
          theStack.push({temperatures[i], i});
        } else {


          // Pop off pairs that are smaller than the current temperature.
          while (!theStack.empty() && temperatures[i] > theStack.top().first) {
            // populate the result array.
            
            toRet[theStack.top().second] = i - theStack.top().second; // Days since that temperature is i - p.second (index we pushed onto the stack.) 
            theStack.pop(); // days have been found, pop that bitch off
          }

          theStack.push({temperatures[i], i});
        }
      }



      return toRet;
    }
};



int main() {


  vector<int> input = {30, 38, 30, 36, 35, 40, 28};
  Solution s;

  cout << "For input: [";
  copy(input.begin(), input.end(), ostream_iterator<int>(cout, " "));
  cout << "]" << endl;

  vector<int> res = s.dailyTemperatures(input);
  cout << "Result: [";
  copy(res.begin(), res.end(), ostream_iterator<int>(cout, " "));
  cout << "]" << endl;


  return 0;
}
