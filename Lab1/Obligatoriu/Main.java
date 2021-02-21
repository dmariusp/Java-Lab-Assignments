package Obligatoriu;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n *= 3;
        System.out.println(n);

        n += Integer.parseInt("10101",2);
        System.out.println(n);

        n += Integer.parseInt("FF",16);
        System.out.println(n);

        n *= 6;
        System.out.println(n);

        while(true){
            int aux = 0;
            if(n < 10)
                break;
            while(n != 0){
                aux += n % 10;
                n /= 10;
            }
            n = aux;
        }

        System.out.println(n);

        System.out.printf("Willy-nilly, this semester I will learn %s", languages[n]);
    }
}


