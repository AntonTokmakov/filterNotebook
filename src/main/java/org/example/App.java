package org.example;

import java.util.*;

public class App
{
    static ArrayList<Notebook> shop = new ArrayList<>();

    public static void main( String[] args )
    {
        shop.add(new Notebook(1, "Machinake", 8, 256, "Microsoft", "Синий"));
        shop.add(new Notebook(2, "Mac", 16, 512, "Mac os", "Черный"));
        shop.add(new Notebook(3, "Aser", 32, 512, "Fedora", "Черный"));
        shop.add(new Notebook(4, "Robot", 16, 128, "other os", "Черный"));
        shop.add(new Notebook(5, "PloKitay", 16, 64, "other os", "Коричневый"));

        Scanner scan = new Scanner(System.in);
        String info = "Информация о действиях:\n" +
                "/info - выводит информацию о командах \n" +
                "/filter - фильтрует ноутбуки по входным значениям\n" +
                "/exit - завершение работы программы\n";
        System.out.println(info);
        String line = "";
        while (!line.equals("/exit")) {
            line = scan.nextLine();
            ////////////////////////////////////////
            line = "/filter";

            switch (line){
                case "/info":
                    System.out.println(info);
                    break;
                case "/filter":
                    findNotebook(editFilter());
                    break;
            }
        }
    }

    public static Map<String, String> editFilter(){

        Map<String, String> filter = new HashMap<>();
        filter.put("#brand", null);
        filter.put("#ozy", null);
        filter.put("#pzy", null);
        filter.put("#os", null);
        filter.put("#color", null);

        String comandFilter = "Команды для работы с фильтром: \n" +
                "#find - после настройки фильтра, что бы сделать поиск\n" +
                "#brand\n" +
                "#ozy\n" +
                "#pzy\n" +
                "#os\n" +
                "#color";
        System.out.println(comandFilter);
        Scanner scan = new Scanner(System.in);
        String line = "";
        while (!line.equals("#find")) {
            line = scan.nextLine();

            if (!filter.containsKey(line.trim())){
                if (!line.equals("#find")){
                    System.out.println("Команда не распознана");
                    System.out.println(comandFilter);
                }
                continue;
            }

            System.out.print("Введите параметр" + line.replace('#', ' ') +
                    "\n- ");
            String item = scan.nextLine();
            filter.put(line, item);
        }
        return filter;
    }

    public static void findNotebook(Map<String, String> filter) {
        for (Notebook notebook : shop) {
            if (checkNotebook(notebook, filter)) {
                System.out.println(notebook);
            }
        }

        System.out.println("////////////////////////////////////////");
        System.out.println("////////////ФИЛЬТР СБРОШЕН//////////////");
    }

    public static boolean checkNotebook(Notebook notebook, Map<String, String> filter) {
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                switch (key) {
                    case "#brand":
                        if (!notebook.brand.toLowerCase().equals(value.toLowerCase())) return false;
                        break;
                    case "#ozy":
                        if (notebook.ozy < Integer.parseInt(value)) return false;
                        break;
                    case "#pzy":
                        if (notebook.pzy < Integer.parseInt(value)) return false;
                        break;
                    case "#os":
                        if (!notebook.os.toLowerCase().equals(value.toLowerCase())) return false;
                        break;
                    case "#color":
                        if (!notebook.color.toLowerCase().equals(value.toLowerCase())) return false;
                        break;
                }
            }
        }
        return true;
    }

   /* public static void findNotebook(Map<String, String> filter) {

        ArrayList<Notebook> filterShop = new ArrayList<>();

        for (Notebook notebook: shop) {

            if (notebook.brand == null || !notebook.brand.equals(filter.get("#brand"))) {}
            else
                continue;
            if (notebook.ozy == null || !(notebook.ozy >= Integer.parseInt(filter.get("#ozy")))){}
            else
                continue;
            if (notebook.pzy == null || !(notebook.pzy >= Integer.parseInt(filter.get("#pzy")))){}
            else
                continue;
            if (notebook.color == null || !(notebook.color.equals(filter.get("#color")))){}
            else
                continue;
            if (notebook.os == null || !(notebook.os.equals(filter.get("#os")))){}
            else
                continue;
            filterShop.add(notebook);
        }

        for (Notebook notebook: filterShop){
            System.out.println(notebook + "\n");
        }

    }*/
}
