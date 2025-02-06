#include <iostream>
#include <string>
#include <vector>
using namespace std;


class Codec {
  string delimiter = "/:";

  public:
  // Encodes a list of strings to a single string.
  string encode(vector<string>& strs) {
    string toRet = "";

    for (string str : strs) {
      for (char c : str) {
        if (c == '/') {
          toRet += '/';
        }
        toRet += c;
      }
      toRet += this->delimiter;
    }

    return toRet;
  }

  // Decodes a single string to a list of strings.
  vector<string> decode(string s) {
    vector<string> toRet;

    // Hello!//://:/://:World/:
    // Iterate through the string, character by character.
    string toAdd = "";
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '/' && s[i + 1] == ':') {
        toRet.push_back(toAdd.substr(0, i));
        toAdd = "";
        i++;
      }
      else if (s[i] == '/' && s[i + 1] == '/') { // this is an escaped character.
        toAdd += '/';
        i++;
      }
      else {
        toAdd += s[i];
      }
    }

    return toRet;
  }
};


int main() {
  vector<string> input = {"Hello!/:/:", "/:World"};

  Codec c;

  cout << "Encoding input: ";
  copy(input.begin(), input.end(), ostream_iterator<string>(cout, ", "));
  cout << endl;

  string encoded = c.encode(input); 
  cout << "This is the encoded input: " << encoded << endl;

  vector<string> decoded = c.decode(encoded);
  cout << "This is the decoded output: ";
  copy(decoded.begin(), decoded.end(), ostream_iterator<string>(cout, ", "));

  return 0;
}
