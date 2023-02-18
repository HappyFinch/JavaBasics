package interfaceLearning;
/**
 * @author hqy
 * @date 2019/12/3
 * @description xxx
 */

// 接口可以多继承
public class Car implements Vehicle, Production {
    private int speed;
    private String type;

    public Car(int speed, String type) {
        super();
        this.speed = speed;
        this.type = type;
    }

    @Override
    public void getSpeed() {
        System.out.println("Speed: " + speed);
    }

    @Override
    public void getType() {
        System.out.println("Type: " + type);
}

    @Override
    public void getProduction() {
        System.out.println("Production: " + "China");
    }

}
    
