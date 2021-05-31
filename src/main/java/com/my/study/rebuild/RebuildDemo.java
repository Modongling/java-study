package com.my.study.rebuild;

import com.my.study.stream.entity.CaloricLevel;
import com.my.study.stream.entity.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.my.study.stream.lambda.LambdaDemo.processFile;

/**
 * @author mdl
 * @Created 2021/5/31 17:14
 * @Description
 */
public class RebuildDemo {
    /**
     * 内部类到Lambda
     */
    public static void runnableDemo() {
        int a = 10;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                //屏蔽全局变量
                int a = 5;
                System.out.println("Hello");
            }
        };

        Runnable r2 = () -> System.out.println("Hello");

        Runnable r3 = () -> {
            //不能屏蔽全局变量
            //int a = 2;
            System.out.println(a);
        };
    }

    /**
     * 同名lambda
     */
    public static void sameNameDemo() {
        taskImpl(new Task() {
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });
        //加上类型转换
        taskImpl((Runnable) () -> System.out.println("Hello"));
    }

    private static void taskImpl(Task task) {
        task.execute();
    }

    private static void taskImpl(Runnable r) {
        r.run();
    }

    @FunctionalInterface
    interface Task {
        public void execute();
    }

    /**
     * 方法引用
     */
    public static void referenceDemo(List<Dish> dishes) {
        Map<CaloricLevel, List<Dish>> map = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getCaloricLevel));
        dishes.sort(Comparator.comparing(Dish::getCalories));
        dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
    }

    /**
     * Stream数据处理
     */
    public static void orderToStream(List<Dish> dishes) {
        dishes.parallelStream()
                .filter(dish -> dish.getCalories() > 400)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    /**
     * 日志处理
     */
    public static void loggerSwitch() {
        Logger logger = Logger.getLogger("com.my.study.rebuild.RebuildDemo");
        logger.log(Level.FINER, () -> "logger");
    }

    /**
     * 环绕执行
     */
    public static void roundProcess() throws IOException {
        String line = processFile(BufferedReader::readLine);
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    /**
     * lambda与设计模式
     * 策略模式
     * 模板方法
     * 观察者
     * 责任链
     * 工厂
     */

    /**
     * 策略
     */
    interface Strategy {
        boolean execute(String str);
    }

    private static class IsAllowLowerCase implements Strategy {
        @Override
        public boolean execute(String str) {
            return str.matches("[a-z]+");
        }
    }

    private static class NormalStrategy {
        private Strategy strategy;

        public NormalStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public boolean valid(String s) {
            return strategy.execute(s);
        }
    }

    public static void strategyDemo() {
        NormalStrategy normalStrategy = new NormalStrategy(new IsAllowLowerCase());
        System.out.println(normalStrategy.valid("aaa"));
        //传入策略实现
        NormalStrategy strategy = new NormalStrategy((String s) -> s.matches("[a-z]+"));
        System.out.println(strategy.valid("AAA"));
    }

    /**
     * 模板
     */
    private static abstract class BankingTemplate {
        public void processCustomer(int id) {
            Customer customer = Database.getCustomerById(id);
            serviceCustomer(customer);
        }
        //定义服务的模板方法
        abstract void serviceCustomer(Customer customer);
    }

    private static class BankingTemplateLambda {
        public void processCustomer(int id, Consumer<Customer> service) {
            Customer customer = Database.getCustomerById(id);
            //consumer代替模板方法
            service.accept(customer);
        }
    }

    private static class Customer {
        private Integer id;
        private String name;

        public Customer(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class Database {
        public static Customer getCustomerById(int id) {
            return new Customer(id, "A:" + id);
        }
    }

    public static void templateLambdaCase() {
        new BankingTemplate() {
            @Override
            void serviceCustomer(Customer customer) {
                System.out.println("service:" + customer);
            }
        }.processCustomer(1);

        new BankingTemplateLambda().processCustomer(2, (Customer c) -> System.out.println("Hello:" + c));
    }

    /**
     * 观察者:一个对象通知其他对象，券商对股票价格做出响应
     */
    interface Observer {
        void notify(String msg);
    }

    /**
     * 主题:注册观察者，执行观察者通知
     */
    interface Subject {
        void registerObserver(Observer observer);
        void notifyObservers(String msg);
    }

    private static class Obs1 implements Observer {

        @Override
        public void notify(String msg) {
            if (msg != null && msg.contains("obs1")) {
                System.out.println("obs1");
            }
        }
    }

    private static class Obs2 implements Observer {

        @Override
        public void notify(String msg) {
            if (msg != null && msg.contains("obs2")) {
                System.out.println("obs2");
            }
        }
    }

    private static class Feed implements Subject {
        private List<Observer> observers = new ArrayList<>();
        @Override
        public void registerObserver(Observer observer) {
            this.observers.add(observer);
        }

        /**
         * 维护观察者列表
         * @param msg
         */
        @Override
        public void notifyObservers(String msg) {
            observers.forEach(observer -> observer.notify(msg));
        }
    }

    public static void observerDemo() {
        Feed feed = new Feed();
        feed.registerObserver(new Obs1());
        feed.registerObserver(new Obs2());
        feed.registerObserver((String msg) -> {
            if (msg != null && msg.contains("aaa")) {
                System.out.println("obs-lambda");
            }
        });
        feed.notifyObservers("obs1&&obs2&&aaa");
    }

    /**
     * 责任链
     * 为请求创建一个接收者对象链
     */
    public abstract static class ProcessingObject<T> {
        protected ProcessingObject<T> successor;
        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }

        abstract protected T handleWork(T input);
    }

    private static class TextProcess extends ProcessingObject<String> {

        @Override
        protected String handleWork(String input) {
            return "hello " + input;
        }
    }

    private static class CheckProcess extends ProcessingObject<String> {

        @Override
        protected String handleWork(String input) {
            return input.replaceAll("labda", "lambda");
        }
    }

    public static void chainDemo() {
        ProcessingObject<String> p1 = new TextProcess();
        ProcessingObject<String> p2 = new CheckProcess();
        p1.setSuccessor(p2);
        String res = p1.handle("aaa labdas");
        System.out.println(res);

        UnaryOperator<String> p11 = (String s) -> "hi " + s;
        UnaryOperator<String> p22 = (String s) -> s.replaceAll("hi", "hii~~");
        Function<String, String> pipeline = p11.andThen(p22);
        System.out.println(pipeline.apply("hi aaa"));
    }

    /**
     * 工厂模式
     */
    private static class ProductFactory {
        public static Product createProduct(String name) {
            switch (name) {
                case "my": return new MyProduct(1, "prod1");
                default: throw new RuntimeException("No such product " + name);
            }
        }
    }

    private static class Product {
        private Integer id;

        public Product(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    '}';
        }
    }

    private static class MyProduct extends Product {
        private String name;

        public MyProduct(Integer id, String name) {
            super(id);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyProduct{" +
                    "id=" + super.id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class ProductFactoryLambda {
        public static Product createProduct(String name) {
            BiFunction<Integer, String, Product> myProd = MyProduct::new;
            if (Objects.nonNull(myProd)) {
                return myProd.apply(1, "MyProd");
            }
            throw new RuntimeException("No such product " + name);
        }
    }

    public static void factoryDemo() {
        Product product = ProductFactory.createProduct("my");
        System.out.println(product);

        Product product2 = ProductFactoryLambda.createProduct("my");
        System.out.println(product2);

        Map<String, BiFunction<Integer, String, Product>> map = new HashMap<>();
        map.put("my", MyProduct::new);
        Product product3 = map.get("my").apply(2, "Mine");
        System.out.println(product3);
    }

    /**
     * 日志调试
     */
    public static void logLambda() {
       List<Integer> nums = Arrays.asList(2, 3, 4, 5);
       nums.stream()
               .peek(x -> System.out.println("from stream:" + x))
               .map(x -> x + 17)
               .peek(x -> System.out.println("after map:" + x))
               .filter(x -> x % 2 == 0)
               .limit(3)
               .peek(x -> System.out.println("after limit:" + x))
               .forEach(System.out::println);
    }


    public static void main(String[] args) {
//        strategyDemo();
//        templateLambdaCase();
//        observerDemo();
//        chainDemo();
//        factoryDemo();
        logLambda();
    }


}
