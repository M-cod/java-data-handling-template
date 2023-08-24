package com.epam.izh.rd.online.service;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.Locale;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     * <p>
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base   - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, "");
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     * <p>
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        return text.endsWith("?");
    }

    /**
     * Реализовать функционал соединения переданных строк.
     * <p>
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        String temp = elements[0];
        for (int i = 1; i < elements.length; i++) {
            temp = temp.concat(elements[i]);
        }
        return temp;
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     * <p>
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 0) {
                ch[i] = Character.toLowerCase(ch[i]);
            } else {
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        return String.valueOf(ch);
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     * <p>
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     * <p>
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        if (string.isEmpty()) return false;
        char[] ch = string.toLowerCase(Locale.ROOT).replaceAll(" ", "").toCharArray();
        for (int i = 0, j =  ch.length - 1; i < ch.length / 2; i++, j--){
            if (ch[i] != ch[j]){
                return false;
            }
        }
        return true;
    }
}
