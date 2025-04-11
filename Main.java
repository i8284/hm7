import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки:\n" +
                "\n" +
                "1. Молоко 50 руб/шт\n" +
                "2. Хлеб 14 руб/шт\n" +
                "3. Гречневая крупа 80 руб/шт");

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};
        int cnt = 0;
        String[] basket = new String[30];
        int[] pr = new int [30];
        int[] amounts = new int [30];
        boolean dbl = false;


        while(true) {
            System.out.println("Выберите товар и количество или введите end");
            String input = scanner.nextLine();

            if("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int product = Integer.parseInt(parts[0]) - 1;
            int amount = Integer.parseInt(parts[1]);


            for (int i = 0; i < basket.length; i++) {
                if(cnt != 0 && basket[i] == products[product]) {
                    pr[i] = pr[i] + (prices[product] * amount);
                    amounts[i] = amounts[i] + amount;
                    dbl = true;
                }

            }
            if(dbl == false) {
                basket[cnt] = products[product];
                pr[cnt] = prices[product] * amount;
                amounts[cnt] = amounts[cnt] + amount;
                cnt++;
            }



            dbl = false;
        }

        System.out.println("Ваша корзина:");
        for (int i = 0; i<cnt; i++) {
            System.out.println(basket[i] +" "+ amounts[i] + " шт " + pr[i]/amounts[i] + " руб/шт " + pr[i] + " руб в сумме");
        }



    }
}