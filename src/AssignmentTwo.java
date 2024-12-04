public class AssignmentTwo {
    public static void main(String[] args) {
        // 主方法，您可以在这里测试其他类
        partThree();
    }

    public  static void partThree() {
        // 第三部分的代码将在这里实现

                // 创建一个新的Ride对象
                Employee operator = new Employee("John Doe", 30, "Male", 175.0, "EMP001", "Rides");
                Ride rollerCoaster = new Ride("Thunderbolt", 4, operator);

                System.out.println("Demonstrating Part 3 - Queue Interface");
                System.out.println("Created new Ride: " + rollerCoaster.getRideName());

                // 创建并添加至少5个Visitor到队列
                Visitor v1 = new Visitor("Alice", 25, "Female", 165.0, "Standard", true);
                Visitor v2 = new Visitor("Bob", 30, "Male", 180.0, "VIP", false);
                Visitor v3 = new Visitor("Charlie", 22, "Male", 175.0, "Standard", true);
                Visitor v4 = new Visitor("Diana", 28, "Female", 170.0, "VIP", true);
                Visitor v5 = new Visitor("Eva", 35, "Female", 160.0, "Standard", false);

                System.out.println("\nAdding visitors to the queue:");
                rollerCoaster.addVisitorToQueue(v1);
                rollerCoaster.addVisitorToQueue(v2);
                rollerCoaster.addVisitorToQueue(v3);
                rollerCoaster.addVisitorToQueue(v4);
                rollerCoaster.addVisitorToQueue(v5);

                // 打印队列
                System.out.println("\nPrinting the queue after adding visitors:");
                rollerCoaster.printQueue();

                // 从队列中移除一个访客
                System.out.println("\nRemoving a visitor from the queue:");
                rollerCoaster.removeVisitorFromQueue();

                // 再次打印队列以显示变化
                System.out.println("\nPrinting the queue after removing a visitor:");
                rollerCoaster.printQueue();
            }





    public void partFourA() {
        // 第四部分A的代码将在这里实现
    }

    public void partFourB() {
        // 第四部分B的代码将在这里实现
    }

    public void partFive() {
        // 第五部分的代码将在这里实现
    }

    public void partSix() {
        // 第六部分的代码将在这里实现
    }

    public void partSeven() {
        // 第七部分的代码将在这里实现
    }

}
