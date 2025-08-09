import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Tạo Scanner chỉ một lần

            System.out.println("nha môn toán");
            double math = sc.nextDouble();
            System.out.println("nhập môn ly");
            double physic = sc.nextDouble();
            System.out.println("nhap mon hoa");
            double chemistry = sc.nextDouble();

            double average = ( math + physic + chemistry)/3;
            if(average >=8.0 && average<=10)
            {
                System.out.println("A");
            }
                if(average >=6.5 && average <8.0)
            {
                System.out.println("B");
            }
            if(average >=5.0 && average < 6.5)
            {
                System.out.print("c");
            }
            if(average <5.0)
            {
                System.out.print("D");
            }
            else if ( average >10 )
            {
                System.out.println("moi ban nhap lai");
            } Scanner scanner = new Scanner(System.in);
            // Khai báo mảng có kích thước 4
                int[] numbers = new int[4];
                // Nhập 4 số từ bàn phím và lưu vào mảng
                System.out.println("Nhập 4 số nguyên:");
                for (int i = 0; i < 4; i++) {
                    System.out.print("Số thứ " + (i + 1) + ": ");
                    numbers[i] = scanner.nextInt();
                }

                // In ra các số đã nhập
                System.out.println("Các số đã nhập là:");
                for (int i = 0; i < 4; i++) {
                    System.out.println("Số thứ " + (i + 1) + ": " + numbers[i]);
                }

            }
        }



