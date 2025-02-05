
#include <iostream>
#include <queue>
#include <iostream>
using namespace std;

class Node {
  public:
    int count;
    int key;
    Node(int count, int key) {
      this->count = count;
      this->key = key;
    }
};

class Solution {
  public:
    vector<int> topKFrequent(vector<int>& nums, int k) { 
      vector<int> toRet;

      auto compareNodes = [](const Node& a, const Node& b) {
        return a.count < b.count; 
      };

      // Initialize a max-heap
      priority_queue<Node, vector<Node>, decltype(compareNodes)> pq(compareNodes);
      unordered_map<int, int> counts;

      // Iterate through the array, gather the counts O(N).
      for (int num : nums) {
        counts[num]++;
      }

      // make nodes based off of the counts.
      for (const auto& pair : counts) {
        cout << pair.first << " " << pair.second << endl;
        pq.push(Node(pair.second, pair.first));
      }

      while (!pq.empty() && k > 0) {
        int el = pq.top().key;
        toRet.push_back(el);
        pq.pop();
        k--;
      }

      return toRet;
    }
};


int main() {

  Solution s;
  vector<int> nums = {7, 7};
  vector<int> res = s.topKFrequent(nums, 10);

  cout << "This is the result: " << endl;

  for (int num : res) {
    cout << num << " ";
  }

  cout << endl;
  return 0;
}

