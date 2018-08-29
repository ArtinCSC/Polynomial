//





public class AbsMin {
    public static void main(String args[]) {
        int X = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE - 1;//-2147483647;
        System.out.println("X = " + X);
        System.out.println("absolute value of X = " + X +" " + X * -1 + " " + Math.abs(X));
        
        System.out.println("y =  " + y);
        System.out.println("absolute value of y = " + y +" " + y * -1 + " " + Math.abs(y));
    }
}




















//public class pr {
//
//	public static void main(String[] args) {
////int[] arr = new int[1000];
////arr[0]= -78;
////arr[1]= +78;
////arr[8]= -78;
////arr[17]= 78;
////
////System.out.println(arrayToString(arr));
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
////
//	}
////	private static String arrayToString(int[] arr){
////		String result = "";
////		for(int i = arr.length-1; i >= 0; i--){
////			if(arr[i] != 0){
////				if (i == 0) {
////					if (arr[i] > 0)
////						result += ("+" + Integer.toString(arr[i]));
////					else
////						result += Integer.toString(arr[i]);
////				} else if (i == 1) {
////					if (arr[i] > 0)
////						result += ("+" + Integer.toString(arr[i]) + "x" + " ");
////					else
////						result += (Integer.toString(arr[i]) + "x" + " ");
////				} else {
////					if (arr[i] > 0)
////						result += ("+" + Integer.toString(arr[i]) + "x^" + Integer.toString(i) + " ");
////					else
////						result += (Integer.toString(arr[i]) + "x^" + Integer.toString(i) + " ");
////				}	
////			}
////		}
////		return result;
////	}
//}
