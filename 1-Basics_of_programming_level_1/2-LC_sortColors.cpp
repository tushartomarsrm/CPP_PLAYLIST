// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// red - 0 , white - 1 , blue - 2

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int index = 0;
        int left = 0;
        int right = nums.size()-1;
        while(index<= right){
            if(nums[index] == 0){
                swap(nums[index], nums[left]);
                left++;
                index++;
            }
            else if(nums[index] == 2){
                swap(nums[index], nums[right]);
                right--;
            }else{
                index++;
            }

        }
    }
};