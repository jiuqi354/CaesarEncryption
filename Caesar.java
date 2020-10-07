import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        System.out.println("欢迎使用凯撒加密系统，加密请扣1，解密请扣2,使用Md5加密请扣3");
        Scanner scanner1 = new Scanner(System.in);//创造scanner对象
        String input1 = scanner1.nextLine();//判断加密或解密
        if (input1.equals("1")) {
            System.out.println("请输入明文");
            Scanner scanner2 = new Scanner(System.in);
            String input2 = scanner2.nextLine();//获取明文
            System.out.println("请输入偏移量，若不输入则默认为3");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            Scanner in2 = new Scanner(line);
            int input3 = 3;
            while (in2.hasNextInt()) {
                input3 = in2.nextInt();//获取偏移量
            }
            for (char c : input2.toCharArray()) {
                if (Character.getType(c) == Character.OTHER_LETTER) {
                    System.out.print(c);
                }
                else if (Character.isDigit(c)) {
                    System.out.print(c);
                }
                else if (Character.isLetter(c)) {
                    String string = String.valueOf(c);
                    CaesarEncryption p = new CaesarEncryption();
                    p.encryption(string, input3);
                }
                else {
                    System.out.print(c);
                }
            }
        }
        else if (input1.equals("2")) {
            System.out.println("请输入密文");
            Scanner scanner2 = new Scanner(System.in);
            String input2 = scanner2.nextLine();//获取密文
            System.out.println("请输入偏移量，若按回车则默认为3");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            Scanner in2 = new Scanner(line);
            int input3 = 3;
            while (in2.hasNextInt()) {
            input3 = in2.nextInt();//获取偏移量
            }
             for (char c : input2.toCharArray()) {
                 if (Character.getType(c) == Character.OTHER_LETTER) {
                        System.out.print(c);
                  }
                 else if (Character.isDigit(c)) {
                        System.out.print(c);
                  }
                 else if (Character.isLetter(c)) {
                        String string = String.valueOf(c);
                        CaesarEncryption p = new CaesarEncryption();
                        p.decryption(string, input3);
                  }
                 else {
                        System.out.print(c);
                  }
             }
        }
        else if(input1.equals("3")){
        System.out.print("没搞出来，下个版本见（");
        }
    }
}

interface Encryption{
    void encryption( String input, int number);
    void decryption(String input, int number);
}
class CaesarEncryption implements Encryption {
        private String input;
        private int number=3;
    @Override
    public void encryption(String input, int number) {
        this.input=input;
        this.number=number;
        String string="";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                letter += number;
                while(letter < 'a')
                    letter += 26;
                while(letter > 'z')
                    letter -= 26;
            }
            else if (letter >= 'A' && letter <= 'Z') {
                letter += number;
                while (letter < 'A')
                    letter += 26;
                while(letter > 'Z')
                    letter -= 26;
            }
            System.out.print(letter);
        }

    }
    public void decryption(String input, int number){
        this.input=input;
        this.number=number;
        String string="";
        for(int i=0;i<input.length();i++){
            char letter = input.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                letter -= number;
                while(letter < 'a')
                    letter += 26;
                while(letter > 'z')
                    letter -= 26;
            }
            else if (letter >= 'A' && letter <= 'Z') {
                letter -= number;
                while(letter < 'A')
                    letter += 26;
                while(letter > 'Z')
                    letter -= 26;
            }
            System.out.print(letter);
        }
    }
}

//Md5的这段没时间了做不出来orz
class Md5Encryption implements Encryption{
@Override
    public void encryption(String input,int number){

}
    public void decryption(String input, int number) {

    }
}
