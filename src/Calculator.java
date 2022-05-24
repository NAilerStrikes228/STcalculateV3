//Интерфейс в данном случае необходим для модулирования будущего класса
interface Calculate{
    public String sum(StringBuilder a,StringBuilder b);
    public String sub(StringBuilder a,StringBuilder b);
    public String mul(StringBuilder a,int b);
    public String div(StringBuilder a,int b);
}

//В данном классе производятся все необходимые подсчёты
class Calculator implements Calculate{
    StringBuilder result=new StringBuilder("\"");
    boolean charAt(StringBuilder a,StringBuilder b){
        if(a.indexOf("\"")!=-1&&a.indexOf("\"",a.length()-1)!=-1&&b.indexOf("\"")!=-1&&b.indexOf("\"",b.length()-1)!=-1)
        return true;
        else
        return false;
    }
    //Метод сложения преопределённый из интерфейса Calculate
    @Override
    public String sum(StringBuilder a,StringBuilder b) {
        if(charAt(a, b)){
            a.deleteCharAt(0).deleteCharAt(a.length()-1);
            b.deleteCharAt(0).deleteCharAt(b.length()-1);
            return result.append(a).append(b).append("\"").toString();}
        else{
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }

    //Метод вычитания преопределённый из интерфейса Calculate
    @Override
    public String sub(StringBuilder a,StringBuilder b) {
        try{
        if(charAt(a, b)) {
            a.deleteCharAt(0).deleteCharAt(a.length() - 1);
            b.deleteCharAt(0).deleteCharAt(b.length() - 1);
            a.delete(a.indexOf(b.toString()), a.indexOf(b.toString()) + b.length());
            return result.append(a).append("\"").toString();
        }
        else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }}
        catch (Exception e){
            return a.toString();
        }
    }

    //Метод умножения преопределённый из интерфейса Calculate
    @Override
    public String mul(StringBuilder a,int b) {
        if(a.indexOf("\"")!=-1&&a.indexOf("\"",a.length()-1)!=-1&&b<=10){
            a.deleteCharAt(0).deleteCharAt(a.length()-1);
            String realString=a.toString();
            for(int i=0;i<b-1;i++){
                a.append(realString);
            }
            return result.append(a).append("\"").toString();}
        else{
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }

    //Метод деления преопределённый из интерфейса Calculate
    @Override
    public String div(StringBuilder a,int b) {
        if(a.indexOf("\"")!=-1&&a.indexOf("\"",a.length()-1)!=-1&&b<=10){
            a.deleteCharAt(0).deleteCharAt(a.length()-1);
            a.delete(a.length()/2,a.length());
            return result.append(a).append("\"").toString();}
        else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }
}