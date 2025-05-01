package arrays.easy;
public class code{
    static int fun(int arr[]){
        int count=0;
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int product=arr[i]*arr[j];
                    for(int k=j+1;k<n;k++){
                        if (product % arr[k] == 0) { // Check if perfectly divisible
                            int elementToFind = product / arr[k];
                            if(findInArray(arr,elementToFind)){
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
        }
        static boolean findInArray(int arr[], int n){
            for(int i=0; i<arr.length; i++){
                if(arr[i] == n){
                return true;
                }
            }
            return false;
        }
        public static void main(String[] args) {
            int arr[] = {1,2,4,5,10,20};
            System.out.println(fun(arr)*8);
    }
}
