package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Thready extends Thread
implements Runnable
{
    int k;
    Thready(int _k)
    {
        k = _k;
    }
    //      Кодировка SHA
    String SHAcode (String name) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        messageDigest.update(name.getBytes());
        byte[] SHAbyte = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SHAbyte.length; i++) {
            if ((SHAbyte[i] & 0xff) < 0x10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Long.toString(SHAbyte[i] & 0xff, 16));
        }
        return stringBuilder.toString();
    }
    //      Полный перебор
    void BrutForce (int k) throws NoSuchAlgorithmException {
        String checkStr = "", /*Полученная перебором строка*/
               checkSHA = "", /*Закодированная строка*/
               SHA_1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad",
               SHA_2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b",
               SHA_3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
        switch (k)
        {
            //Проверка первого SHA
            case 1 :
            {
                for (char i1 = 'a'; i1 <= 'z'; i1++)
                    for (char i2 = 'a'; i2 <= 'z'; i2++)
                        for (char i3 = 'a'; i3 <= 'z'; i3++)
                            for (char i4 = 'a'; i4 <= 'z'; i4++)
                                for (char i5 = 'a'; i5 <= 'z'; i5++)
                                {
                                    checkStr = String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4) + String.valueOf(i5);
                                    checkSHA = SHAcode(checkStr);
                                    if (checkSHA.equals(SHA_1))
                                        System.out.println("SHA-1 : " + checkStr + " " + checkSHA);
                                }
                break;
            }
            //Проверка второго SHA
            case 2 :
            {
                for (char i1 = 'a'; i1 <= 'z'; i1++)
                    for (char i2 = 'a'; i2 <= 'z'; i2++)
                        for (char i3 = 'a'; i3 <= 'z'; i3++)
                            for (char i4 = 'a'; i4 <= 'z'; i4++)
                                for (char i5 = 'a'; i5 <= 'z'; i5++)
                                {
                                    checkStr = String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4) + String.valueOf(i5);
                                    checkSHA = SHAcode(checkStr);
                                    if (checkSHA.equals(SHA_2))
                                        System.out.println("SHA-2 : " + checkStr + " " + checkSHA);
                                }
                break;
            }
            //Проверка третьего SHA
            case 3 :
            {
                for (char i1 = 'a'; i1 <= 'z'; i1++)
                    for (char i2 = 'a'; i2 <= 'z'; i2++)
                        for (char i3 = 'a'; i3 <= 'z'; i3++)
                            for (char i4 = 'a'; i4 <= 'z'; i4++)
                                for (char i5 = 'a'; i5 <= 'z'; i5++)
                                {
                                    checkStr = String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4) + String.valueOf(i5);
                                    checkSHA = SHAcode(checkStr);
                                    if (checkSHA.equals(SHA_3))
                                        System.out.println("SHA-3 : " + checkStr + " " + checkSHA);
                                }
                break;
            }

        }
    }

    public void run() {
        try {
            BrutForce(k);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
