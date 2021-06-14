package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class Program {
    public static void main(String[] args)  {
        File fl = new File("src/main/resources/input/Shantaram.txt");
        System.out.println("###############################################################");
        String fileName = "src/main/resources/input/Shantaram.txt";
        String contents = null;
        try {
            contents = readUsingScanner(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(contents);
        System.out.println("###############################################################");
        System.out.println("Имя файла: " + fl.getName() + " ,  Полный путь: " + fl.getAbsolutePath());
        System.out.println("Размер файла : " + fl.length() / 1024 + " kb");
        System.out.println(fl.canWrite() ? "Свойство - можно записывать" : "Свойство - нельзя записывать");
        System.out.println(fl.canRead() ? "Свойство - можно читать" : "Свойство - нельзя читать");
        System.out.println(fl.isHidden() ? "Свойство - скрытый файл" : "Свойство - не скрытый файл");

        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(fl));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count1 = 0;
            while (sc.hasNext()) {
                sc.next();
                count1++;
            }
            System.out.println("Количество слов в тексте : " + count1);


        List<String> wordsKir = new ArrayList<>(Arrays.asList(contents.split("[^А-Яа-я]+")));
        //System.out.println(wordsKir);
        System.out.println("Колличество слов в тексте на кириллице:  " + wordsKir.size());

        List<String> wordsLat = new ArrayList<>(Arrays.asList(contents.split("[^A-Za-z]+")));
        //System.out.println(wordsLat);
        System.out.println("Колличество слов в тексте на латинице:  " + wordsLat.size());

        int percentage = wordsKir.size() / wordsLat.size() * 100;
        System.out.println("Отношение слов на кириллице к латинским словам: " + percentage + " %");

        int count = 0;
        for (int i = 0; i < contents.length() - 1; i++) {
            if ((contents.charAt(i + 1) == '.' || contents.charAt(i + 1) == '!' ||
                    contents.charAt(i + 1) == '?') &&
                    !(contents.charAt(i) == '.' || contents.charAt(i) == '!' ||
                            contents.charAt(i) == '?')) count++;
        }
        System.out.println("Количество педложений в тексте : " + count);

        int punctuationBefore = contents.length();
        int punctuationAfter = contents.replaceAll("[,.;:]", "").length();
        System.out.println("Количество знаков препинания в тексте: " + (punctuationBefore - punctuationAfter));

        int marketBefore = contents.length();
        int marketAfter = contents.replaceAll("[?!@#-]", "").length();
        System.out.println("Количество знаков  в тексте: " + (marketBefore - marketAfter));

        int spaces = contents == null ? 0 : contents.length() - contents.replace(" ", "").length();
        System.out.println("Количество пробелов в тексте : " + spaces);

        System.out.println("Отношение знаков  (знаков и пробелов) к знакам припинания:  " + (spaces + (marketBefore - marketAfter)) / (punctuationBefore - punctuationAfter) * 100 + "%");

        String alfabeta = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        int cnt = 0;
        for (int i = 0; i < alfabeta.length(); i++) {
            for (int j = 0; j < contents.length(); j++) {
                if (alfabeta.charAt(i) == contents.charAt(j)) {
                    cnt++;
                }
            }
            ;
        }
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqastuvwxyz";
        TreeMap<Character, Integer> tm1 = new TreeMap<>();
        int cnt1 = 0;
        for (int i = 0; i < alfabet.length(); i++) {
            for (int j = 0; j < contents.length(); j++) {
                if (alfabet.charAt(i) == contents.charAt(j)) {
                    cnt1++;
                }
            }
            ;
        }
        System.out.println("Отношение символов на кириллице к латинским символам: " + cnt / cnt1 * 100 + " %");
        System.out.println("Количество символов кириллицы в тексте:  " + cnt);
        System.out.println("Количество символов латиницы в тексте: " + cnt1);

        String letters1 = "BCDFGHKLMNPQRSTVWXZbcdfghklmnpqstvwбвгджзклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФХЦЧШЩ";
        System.out.println("Колличество слов в тексте начинающихся с согласных (кириллица и латиница): " + Arrays.stream(contents.split("\\s+"))
                .filter(x -> letters1.contains(x.substring(0, 1)))
                .count());

        String letters2 = "АЕИОУЫЮЯЭаеиоуыэюяaeiouyAEIOY";
        System.out.println("Колличество слов в тексте начинающихся с гласных (кириллица и латиница): " + Arrays.stream(contents.split("\\s+"))
                .filter(x -> letters2.contains(x.substring(0, 1)))
                .count());

        ArrayList<String> list = new ArrayList<>();
        list.add("Имя файла: " + fl.getName() + " ,  Полный путь: " + fl.getAbsolutePath());
        list.add("Размер файла : " + fl.length() / 1000 + " kb");
        list.add(fl.canWrite() ? "Свойство - можно записывать" : "Свойство - нельзя записывать");
        list.add(fl.canRead() ? "Свойство - можно читать" : "Свойство - нельзя читать");
        list.add(fl.isHidden() ? "Свойство - скрытый файл" : "Свойство - не скрытый файл");
        list.add("Количество слов в тексте : " + count1);
        list.add("Колличество слов в тексте на кириллице:  " + wordsKir.size());
        list.add("Колличество слов в тексте на латинице:  " + wordsLat.size());
        list.add("Отношение слов на кириллице к латинским словам: " + percentage + " %");
        list.add("Количество педложений в тексте : " + count);
        list.add("Количество знаков препинания в тексте: " + (punctuationBefore - punctuationAfter));
        list.add("Количество знаков  в тексте: " + (marketBefore - marketAfter));
        list.add("Количество пробелов в тексте : " + spaces);
        list.add("Отношение знаков  (знаков и пробелов) к знакам припинания:  " + (spaces + (marketBefore - marketAfter)) / (punctuationBefore - punctuationAfter) * 100 + "%");
        list.add("Отношение символов на кириллице к латинским символам: " + cnt / cnt1 * 100 + " %");
        list.add("Колличество слов в тексте начинающихся с согласных (кириллица и латиница): " + Arrays.stream(contents.split("\\s+")).filter(x -> letters1.contains(x.substring(0, 1))).count());
        list.add("Колличество слов в тексте начинающихся с гласных (кириллица и латиница): " + Arrays.stream(contents.split("\\s+")).filter(x -> letters2.contains(x.substring(0, 1))).count());

        System.out.println("###############################################################");
        try {
            Files.write(Paths.get("src/main/resources/output/LatinText.txt"), wordsLat, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Files.write(Paths.get("src/main/resources/output/KirillText.txt"), wordsKir, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Files.write(Paths.get("src/main/resources/output/InformationFail.txt"),list , StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
                private static String readUsingScanner (String fileName) throws IOException {
                    Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
                    String data = scanner.useDelimiter("\\A").next();
                    scanner.close();
                    return data;
                    }


        }
