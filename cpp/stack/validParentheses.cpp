#include<iostream>
#include<string>
#include<stack>
using namespace std;

class Solution {
public:
    bool isValid(string s) {

      stack<char> theStack;
      unordered_map<char, char> theMap {
        { ']', '['},
        { '}', '{'},
        { ')', '('}
      }; 

      for (char c : s) { 

        if (isOpener(c)) {
          theStack.push(c);
        }
        else {
          // case where it's a closer.
          // 1: check if the stack is empty.
          if (theStack.empty()) {
            return false;
          }
          
          // 2: Check to make sure top of stack character matches the opener. 
          char top = theStack.top();
          
          if (top != theMap[c]) {
            return false;
          }

          // 3: neither invariant is broken, just pop it...
          theStack.pop();
        }
      }

      return theStack.empty();
    }

    bool isOpener(char c) {
      return c == '[' || c == '{' || c == '(';
    } 

};

int main() {

  Solution s;
  string in = "[[]]class Solution {
public:
    bool isValid(string s) {

      stack<char> theStack;
      unordered_map<char, char> theMap {
        { ']', '['},
        { '}', '{'},
        { ')', '('}
      };

      for (char c : s) {

        if (isOpener(c)) {
          theStack.push(c);
        }
        else {
          // case where it's a closer.
          // 1: check if the stack is empty.
          if (theStack.empty()) {
            return false;
          }

          // 2: Check to make sure top of stack character matches the opener.
          char top = theStack.top();

          if (top != theMap[c]) {
            return false;
          }

          // 3: neither invariant is broken, just pop it...
          theStack.pop();
        }
      }

      return theStack.empty();
    }

    bool isOpener(char c) {
      return c == '[' || c == '{' || c == '(';
    }

};";
  cout << "String: " << in << " is valid?: " << s.isValid(in) << endl;

  return 0;
}

