

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bussra
 */

public class PolishNotasyonu {
        static boolean sayiKontrol(String deger)  { //Girilen Karakterin Sayi Olup Olmadigini Kontrol Eden Method
        boolean sonuc;
        while(true) {
                if(deger.equals("+")) {
                        sonuc = false;
                        break;
                }
                else if(deger.equals("-")) {
                        sonuc = false;
                        break;
                }
                else if(deger.equals("*")) {
                        sonuc = false;
                        break;
                }
                else if(deger.equals("/")) {
                        sonuc = false;
                        break;
                }
                else {
                        sonuc = true;
                        break;
                }
                
        }
        return sonuc;
    }

        static Integer Hesapla(String giris)  { //Notasyonun Sonucunu Hesaplayan Method
        ArrayList<String> arrayPolish = new ArrayList<>(); 
        String [] array = giris.split(" ");
        boolean addAll = arrayPolish.addAll(Arrays.asList(array));
        int i = 0;
        Integer gecici = 0;
        while(arrayPolish.size() != 1) {
           
                switch(arrayPolish.get(i)) {
                        case "+":
                        if(sayiKontrol(arrayPolish.get(i+1)))  {
                        if(sayiKontrol(arrayPolish.get(i+2))) {
                        Integer temp = Integer.valueOf(arrayPolish.get(i+1)) + Integer.valueOf(arrayPolish.get(i+2));
                        arrayPolish.set(i, temp.toString());
                        arrayPolish.remove(i+2);
                        arrayPolish.remove(i+1);
                        i=0;
                        break;
                        }
                    }
                        i++; 
                        break;
                      
                        case "-":
                        if(sayiKontrol(arrayPolish.get(i+1))) {
                        if(sayiKontrol(arrayPolish.get(i+2)))  {
                        Integer temp = Integer.valueOf(arrayPolish.get(i+1)) - Integer.valueOf(arrayPolish.get(i+2));
                        arrayPolish.set(i, temp.toString());
                        arrayPolish.remove(i+2);
                        arrayPolish.remove(i+1);
                        i=0;
                        break;
                        }
                    }
                        i++;
                        break;
                        case "*":
                        if(sayiKontrol(arrayPolish.get(i+1)))   {
                        if(sayiKontrol(arrayPolish.get(i+2))) {
                        Integer temp = Integer.valueOf(arrayPolish.get(i+1)) * Integer.valueOf(arrayPolish.get(i+2));
                        arrayPolish.set(i, temp.toString());
                        arrayPolish.remove(i+2);
                        arrayPolish.remove(i+1);
                        i=0;
                        break;
                        }
                 }
                        i++;
                        break;
                        
                        case "/":
                        if(sayiKontrol(arrayPolish.get(i+1))) {
                        if(sayiKontrol(arrayPolish.get(i+2))) {
                        Integer temp = Integer.valueOf(arrayPolish.get(i+1)) / Integer.valueOf(arrayPolish.get(i+2));
                        arrayPolish.set(i, temp.toString());
                        arrayPolish.remove(i+2);
                        arrayPolish.remove(i+1);
                        i=0;
                        break;
                        }
                   }
                        i++;
                        break;
                        default:
                        i++;
                        break;
                        }                 
                 }
        
        for(int j = 0; j < arrayPolish.size(); j++) {
            gecici += Integer.valueOf(arrayPolish.get(j));
        }
         return gecici;
        }

  public static void main(String[] args) {
        System.out.println("Notasyonu Giriniz:");
        Scanner scanner = new Scanner(System.in);
        String giris = scanner.nextLine();
        System.out.println("Sonuc : " + Hesapla(giris));
    }
}
