#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> toRet;
        unordered_map<string, vector<string>> anagrams;

        // Tokenize each string and group anagrams
        for (string str : strs) {
            string tokenized = tokenizeString(str);
            anagrams[tokenized].push_back(str);
        }

        // Populate the result vector
        for (const auto& pair : anagrams) {
            toRet.push_back(pair.second);
        }

        return toRet;
    }

    string tokenizeString(string s) {
        int count[26] = {0}; // Initialize an array to count occurrences of each character
        for (char c : s) {
            count[c - 'a']++; // Increment the count for each character
        }

        string token;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                token += string(1, 'a' + i) + to_string(count[i]); // Append character and its count
            }
        }
        return token;
    }
};

int main() {
    Solution s;

    // Test input
    vector<string> input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> anagrams = s.groupAnagrams(input);

    // Print the grouped anagrams
    for (vector<string> v : anagrams) {
        for (string s : v) {
            cout << s << " ";
        }
        cout << endl;
    }

    return 0;
}
