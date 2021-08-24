import java.util.ArrayList;

public class CardValidation {
    public static boolean isValid(String string){
        ArrayList<Integer> arrayValue = new ArrayList<Integer>();
        if(string.length()>= 14 && string.length()<=19){
            long newInt = Long.parseLong(string), reverse = 0;
            int checkDigit = (int) (newInt % 10), sum = 0;
            newInt = newInt/10;
            while(newInt!=0){
                long digit = newInt % 10;
                reverse = reverse * 10 + digit;
                newInt = newInt/10;
                arrayValue.add((int) digit);
            }
            for(int i=0; i< arrayValue.size(); i++){
                if(i%2 == 0){
                    long newDigit = arrayValue.get(i) * 2;
                    if(newDigit > 9){
                        sum = sum + (int)((newDigit % 10) + (newDigit / 10));
                    }
                    else{
                        sum = sum + (int)newDigit;
                    }
                }
                else{
                    sum = sum + arrayValue.get(i);
                }
            }
            return ((10 - (sum % 10)) == checkDigit);
        }
        else{ return false; }
    }

    public static void main(String[] args) {
        System.out.println(isValid("1234567890123452"));
    }
}
