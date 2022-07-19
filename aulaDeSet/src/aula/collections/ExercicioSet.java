package aula.collections;

/*
Formas de se inicializar um Set:
Set notas = new HashSe(); //antes do java 5
Set<Double> notas = new HashSet<>(); // Generics JDK5 - Diamond Operator JDK7
HashSet<Double> notas = new HashSet<>();
Set<Double> notas = Set.of(7.0, 8.5, 9.3, 5d, 7d, 0d, 3.6);
notas.add(1d);
notas.remove(5d);
System.out.println(notas);
 */


import java.util.*;

public class ExercicioSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());
        //Como mostra a saída, ele eliminou um número repetido e mudou as posições aleatoriamente

        System.out.println("Exiba a posição da nota 5.0: em Set não dá pra fazer isso");
        System.out.println("Adicione na lista a nota 8.0 na posição 4: não dá pq não tem índice em Set");
        System.out.println("Substitua a nota 5.0 pela nota 6.0: não dá, Set não tem índice");

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5.0));
        //Sim ele diz se tem ou não um elemento na lista mas não diz em qual posição pois não tem índice

        System.out.println("Exiba a terceira nota adicionada: Set não tem índice pra fazer isso");

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota zero: ");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova a nota na posição zero: não tem índice em Set");

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next <7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas3.clear();

        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto inicial está vazio: " + notas.isEmpty());


    }

}
