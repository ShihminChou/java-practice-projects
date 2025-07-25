public class Object {
    public static void main(String[] args) {
        //將 Role 類別實體化成 role
        Role role = new Role();

        //設定 Role 類別中的三個屬性值資料，透過點的方式進行存取與呼叫
        role.nickName = "Amy";
        role.gender = "女生";
        role.skill = "天空飛行";

        //獲取 Role 類別中的三個屬性值資料
        System.out.println(role.nickName);
        System.out.println(role.gender);
        System.out.println(role.skill);

        //使用呼叫 Role 類別中的三個方法
        role.walk();
        role.run();
        role.hit();
    }
}
