import java.util.Scanner;

public class Main {
    //Создаём новый обьект класса Calculator
    static Calculator calculator=new Calculator();
    //Создаём новый обьект класс Scanner
    static Scanner scanner=new Scanner(System.in);
    //throws означает что метод может выбросить исключение
    public static void main(String[] args) throws Exception {
        System.out.println("Поддерживаемые операции:  \n" +
                "\"JAVA\" + \"JAVA\" \n" +
                "\"JAVA\" - \"JAVA\" \n" +
                "\"JAVA\" * 5\n"+
                "\"JAVA\" \\ 3\n"+
                "Введите итерацию(обязательно ставьте пробел перед знаком оператора и после него) : "
                );

        //Блок кода отвечающий за вызов всех необходимых методов и отлова исключения
        try{
            StringBuilder[] sb = split(scanner.nextLine());
            String result = computeResult(sb,calculator);
            if(result.length()<40){
                System.out.println("Результат итерации: "+result);
            }
            else {
                System.out.println("Результат итерации: "+result.substring(0,41)+"...\"");
            }
        }
        catch (Exception e){
            throw new Exception("Вы ввели неверное значение!");
        }
    }

    // Метод проверяет знак и вызывает необходимый метод из класса Calculator
    public static String computeResult(StringBuilder[] sb,Calculator calculator){
        switch (sb[2].toString()){
            case "+":
                return calculator.sum(sb[0],sb[1]);

            case "-":
                return calculator.sub(sb[0],sb[1]);

            case "*":
                return calculator.mul(sb[0],Integer.parseInt(sb[1].toString()));

            case "/":
                return calculator.div(sb[0],Integer.parseInt(sb[1].toString()));

        }
        return null;
    }

    // Метод разделяет по оператору и заносит данные  в масив {первая строка, вторая строка, оператор}
    public static StringBuilder[] split(String nums){
        String[] sb=new String[2];
        StringBuilder[] sbNew=new StringBuilder[3];
        String operator="";
        if(nums.contains("+")){
            sb=nums.split(" [+] ");
            operator="+";
        } else if (nums.contains("-")) {
            sb=nums.split(" [-] ");
            operator="-";
        }
        else if (nums.contains("*")) {
            sb=nums.split(" [*] ");
            operator="*";
        }
        else if (nums.contains("/")) {
            sb=nums.split(" [/] ");
            operator="/";
        }
        sbNew[0]=new StringBuilder(sb[0]);
        sbNew[1]=new StringBuilder(sb[1]);
        sbNew[2]=new StringBuilder(operator);
        if(sbNew[0].length()-2>10||sbNew[1].length()-2>10)
            throw new NullPointerException("Значение одной из входных строк превышает 10 символов");
        return sbNew;
    }
}
