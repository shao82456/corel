package object;

public class DynamicDispatch {
    static abstract class Human{
        protected abstract void sayHello();
        public void makeLove(){
            System.out.println("xxoo");
        }
    }

    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human{
        static {
            System.out.println("woman loaded");
        }
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }
    static int hehe(int a){
        return a+1;
    }

    static int hehe(char a){
        return a+1;
    }

    public static void main(String[] args) {
        Human man=new Man();
        man.sayHello();
        DynamicDispatch.hehe(1);
    }
}
