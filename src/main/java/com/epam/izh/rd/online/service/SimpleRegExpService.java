package com.epam.izh.rd.online.service;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        String str = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/sensitive_data.txt"))) {
            Pattern pattern = Pattern.compile("(?<=(?:[^\\d]|^))(\\d{4}[ \\t])(?:\\d{4}[ \\t]){2}(\\d{4})(?=(?:[^\\d]|$))");
            Matcher matcher = pattern.matcher(bufferedReader.readLine());
            str = matcher.replaceAll("$1**** **** $2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        String str = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/sensitive_data.txt"))) {
            str = bufferedReader.readLine();
            str = str.replaceAll("\\$\\{payment_amount}", String.valueOf ((int) paymentAmount))
                    .replaceAll("\\$\\{balance}", String.valueOf ((int) balance));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
