package top.lemonman;

import java.util.Date;

/**
 * @description 快速排序与冒泡时间对比
 * @author 张宇
 */
public class QuickSortAndBubbleSort {
	/**
	 * @param array 表示排序数组
	 * @param start 表示当前排序的起始位置
	 * @param end 表示排序结束点
	 */
	public static void quickSort(int []array, int start, int end) {
		//判断数组的长度是否大于0
		if (end - start >= 1) {
			int left = start+1, right = end;
			while (right >= left) {
				if (array[right] < array[start]) {//从右边得到小于基数的位置
					if (array[left] > array[start]) {//从左边得到大于基数的位置
						if (right > left) {//判断连个位置是否是正确，即不是同一个值
							//执行左右值的交换
							array[left] = array[right] + array[left];
							array[right] = array[left] - array[right];
							array[left] = array[left] - array[right];
						}else {//否则代表已经左右交换完成，只需要交换基数了
							array[start] = array[right] + array[start];
							array[right] = array[start] - array[right];
							array[start] = array[start] - array[right];
							//完成小块的交换,跳出循环
							break;
						}
					}else {
						if (left == right) {
							array[start] = array[right] + array[start];
							array[right] = array[start] - array[right];
							array[start] = array[start] - array[right];
							//完成小块的交换,跳出循环
							break;
						}
						left++;
					}
				}else {
					right--;
				}
			}
			//循环结束，数组被分为两部分，左边的小于基数，右边的都大于基数，递归调用
			quickSort(array, start, right-1);
			quickSort(array, right+1, end);
		}
	}
	
	/**
	 * 对数组进行冒泡排序
	 * @param array 排序数组
	 */
	public static void bubbleSort(int[] array) {
		if (array.length > 1) {
			for (int i = 0; i < array.length-1; i++) {
				for (int j = 0; j < array.length - 1 - i; j++) {
					if (array[j] > array[j+1]) {
						//进行数字 交换
						array[j] = array[j+1] + array[j];
						array[j+1] = array[j] - array[j+1];
						array[j] = array[j] - array[j+1];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		 int[] array = new int[]{5,5,3,4,2,15,20,15,21};
		 int[] nums = new int[10000000];
		 for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) Math.floor(Math.random() * 1000000);
		 }
		 Long time = new Date().getTime();
		 quickSort(nums, 0, nums.length-1);
		 Long time1 = new Date().getTime();
		 //bubbleSort(nums);
		 Long time2 = new Date().getTime();
		 System.out.println("快排时间"+(time1-time));
		 System.out.println("冒泡时间"+(time2-time1));
		 for (int i = 0; i < 100; i++) {
			 System.out.println(nums[i]);
		}
	}
}
