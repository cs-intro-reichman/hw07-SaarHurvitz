/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

        public static String toBinary(int x) {
        
       if (x == 0) {
            return "0";
        }
        else if(x == 1){
            return "1";
        }
        
        return toBinaryHelper(x);
    }

    private static String toBinaryHelper(int x){
        if (x == 0) {
            return "";
        }
        return toBinaryHelper(x / 2) + (x % 2);
    }
        

 }
