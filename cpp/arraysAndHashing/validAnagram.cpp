#include <iostream>
using namespace std;



class Solution {
  public:
    bool isAnagram(string s1, string s2) {

      if (s1.length() != s2.length()) {
        return false;
      }

      unordered_map<char, int> s1Map = countChars(s1);
      unordered_map<char, int> s2Map = countChars(s2);

      // check to make sure they have the same number of elements.
      if (s1Map.size() != s2Map.size()) return false; 


      auto it = s1Map.begin();

      while (it != s1Map.end()) {
        if (!s2Map.count(it->first) || s2Map[it->first] != it->second) {
          return false;
        }
        
        it = s1Map.erase(it);
      }


      return s1Map.size() == 0;
    }

    unordered_map<char, int> countChars(string s) {
      unordered_map<char, int> smap;
      for (char c : s) {
        smap[c]++;
      }
      return smap;
    }

};


int main() {
  string s1 = "rfacecar";
  string s2 = "cdarrace";

  Solution s;
  // cout << "Is anagram: " << endl << s.isAnagram(s1, s2) << endl;
  bool isAnagram  = s.isAnagram(s1, s2);
  cout << "Is anagram: " << isAnagram << endl;
  return 0;        
}
