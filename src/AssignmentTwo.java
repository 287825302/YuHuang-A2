public class AssignmentTwo {
    public static void main(String[] args) {
        // 主方法，您可以在这里测试其他类
        partFourB();
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





    public  static void partFourA() {
        // 第四部分A的代码将在这里实现
        System.out.println("Demonstrating Part 4A - Collection class (LinkedList)");

        // 创建一个新的Ride对象
        Employee operator = new Employee("Jane Smith", 28, "Female", 170.0, "EMP002", "Rides");
        Ride ferrisWheel = new Ride("Giant Wheel", 6, operator);
        System.out.println("Created new Ride: " + ferrisWheel.getRideName());

        // 创建访客
        Visitor v1 = new Visitor("Frank", 40, "Male", 185.0, "VIP", true);
        Visitor v2 = new Visitor("Grace", 35, "Female", 160.0, "Standard", true);
        Visitor v3 = new Visitor("Henry", 28, "Male", 175.0, "Standard", false);
        Visitor v4 = new Visitor("Ivy", 22, "Female", 165.0, "VIP", true);
        Visitor v5 = new Visitor("Jack", 31, "Male", 180.0, "Standard", true);

        // 添加访客到乘坐历史
        System.out.println("\nAdding visitors to ride history:");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // 检查访客是否在乘坐历史中
        System.out.println("\nChecking if Frank is in the ride history:");
        boolean isInHistory = ferrisWheel.checkVisitorFromHistory(v1);
        System.out.println("Frank is in ride history: " + isInHistory);

        // 打印乘坐历史中的访客数量
        System.out.println("\nNumber of visitors in ride history:");
        System.out.println(ferrisWheel.numberOfVisitors());

        // 打印所有在乘坐历史中的访客
        System.out.println("\nPrinting all visitors in ride history:");
        ferrisWheel.printRideHistory();

    }

    public  static void partFourB() {
        // 第四部分B的代码将在这里实现


            System.out.println("Demonstrating Part 4B - Sorting the collection");

            // 创建一个新的Ride对象
            Employee operator = new Employee("Alex Brown", 32, "Male", 178.0, "EMP003", "Rides");
            Ride rollerCoaster = new Ride("Cyclone", 4, operator);
            System.out.println("Created new Ride: " + rollerCoaster.getRideName());

            // 创建访客
            Visitor v1 = new Visitor("Zoe", 28, "Female", 165.0, "Standard", true);
            Visitor v2 = new Visitor("Yara", 35, "Female", 170.0, "VIP", false);
            Visitor v3 = new Visitor("Xavier", 22, "Male", 180.0, "Standard", true);
            Visitor v4 = new Visitor("William", 40, "Male", 175.0, "VIP", true);
            Visitor v5 = new Visitor("Victoria", 30, "Female", 168.0, "Standard", false);

            // 添加访客到乘坐历史
            System.out.println("\nAdding visitors to ride history:");
            rollerCoaster.addVisitorToHistory(v1);
            rollerCoaster.addVisitorToHistory(v2);
            rollerCoaster.addVisitorToHistory(v3);
            rollerCoaster.addVisitorToHistory(v4);
            rollerCoaster.addVisitorToHistory(v5);

            // 打印未排序的乘坐历史
            System.out.println("\nPrinting unsorted ride history:");
            rollerCoaster.printRideHistory();

            // 排序乘坐历史
            System.out.println("\nSorting ride history:");
            rollerCoaster.sortVisitorHistory();

            // 打印排序后的乘坐历史
            System.out.println("\nPrinting sorted ride history:");
            rollerCoaster.printRideHistory();
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
