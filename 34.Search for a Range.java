public int[] search(int[] nums, int target){
		int[] result = new int[2];
		result[0] = result[1] = -1;
		int n = nums.length;
		if(n==0) return result;
		int left = 0,right = n-1,leftindex = -1, rightindex = -1,mid=0;
		while(left<=right){
			mid = (left+right)/2;
			if(nums[mid]<target){
				left = mid + 1;
			}
			else if(nums[mid]>target){
				right = mid - 1;
			}
			else{
				leftindex = rightindex = mid;
				break;
			}
		}
		if(left>right) return result;
		while(leftindex>0 && nums[leftindex-1]==nums[mid]) --leftindex;
		while(rightindex<n-1&&nums[rightindex+1] == nums[mid]) ++rightindex;
		result[0] = leftindex;
		result[1] = rightindex;
		return result;
	}	
	public int[] search2(int[] nums, int target){
		int[] result = new int[2];
		result[0] = result[1] = -1;
		int n = nums.length;
		if(n==0) return result;
		int left = 0,right = n-1,mid=0;
		while(left<right){
			mid = (left + right)/2;
			if(nums[mid]<target) left = mid + 1;
			else right = mid;
		}
		if(nums[right]!=target)return result;
		result[0] = right;
		right = n;
		while(left<right){
			mid = (left+right)/2;
			if(nums[mid]<=target) left = mid+1;
			else right = mid - 1;
		}
		result[1] = left - 1;
		return result;
	}	