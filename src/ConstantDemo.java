class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
}

class Company {
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}

public class ConstantDemo {

    public static void main(String[] args) {
        //if(Fruit.APPLE == Company.APPLE) {
        //    System.out.print("과일 사과와 회사 사과가 같습니다.");
        //}
        //Company type = Company.APPLE;
        if (Fruit.APPLE.equals(Fruit.APPLE)) {
            System.out.println(57 + "kcal 입니다.");
        } else if (Fruit.PEACH.equals(Fruit.APPLE)) {
            System.out.println(60 + "kcal 입니다.");
        } else if (Fruit.BANANA.equals(Fruit.APPLE)) {
            System.out.println(42 + "kcal 입니다.");
        }
    }
}