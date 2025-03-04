import java.util.regex.Pattern;

public class Test4 {
    public static void main(String[] args){
        try {
            String bt = "^[a-zA-Z0-9_%+-]+@gmail.com$";
            String ma = "hongnhung987@gmail.com";
            System.out.println(Pattern.matches(bt, ma));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}
