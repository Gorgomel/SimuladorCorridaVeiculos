package poo.trabalho.fun;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Helper de leitura robusta para o console. */
public final class Leitor {
    private final Scanner sc;

    public Leitor() {
        this.sc = new Scanner(System.in, StandardCharsets.UTF_8).useLocale(Locale.ROOT);
    }

    public int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine();
                if (line == null) continue;
                line = line.trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            } catch (NoSuchElementException e) {
                System.out.println("\nEntrada encerrada. Saindo...");
                System.exit(0);
            }
        }
    }

    public int lerInt(String prompt, int min, int max) {
        while (true) {
            int v = lerInt(prompt);
            if (v < min || v > max) {
                System.out.printf("Valor fora do intervalo [%d..%d].%n", min, max);
                continue;
            }
            return v;
        }
    }

    public char lerChar(String prompt, char... aceitaveis) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine();
                if (s == null) continue;
                s = s.trim();
                if (s.isEmpty()) continue;
                char c = Character.toUpperCase(s.charAt(0));
                if (aceitaveis == null || aceitaveis.length == 0) return c;
                for (char a : aceitaveis) {
                    if (Character.toUpperCase(a) == c) return c;
                }
                System.out.print("Valor inválido. Aceitos: ");
                for (char a : aceitaveis) System.out.print(Character.toUpperCase(a) + " ");
                System.out.println();
            } catch (NoSuchElementException e) {
                System.out.println("\nEntrada encerrada. Saindo...");
                System.exit(0);
            }
        }
    }

    public String lerLinha(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = sc.nextLine();
                if (s != null) return s;
            } catch (NoSuchElementException e) {
                System.out.println("\nEntrada encerrada. Saindo...");
                System.exit(0);
            }
        }
    }
}
