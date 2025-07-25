public class Encapsulation {
    // 封裝
    public static void main(String[] args) {
        Account account = new Account();
        account.userId = 123;

        System.out.println(account.userId);

        InnerClass innerClass = new InnerClass();
        innerClass.xxx = 333;
    }

    static class InnerClass {
        private int xxx;
    }
}
