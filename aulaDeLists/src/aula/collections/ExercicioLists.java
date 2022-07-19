package aula.collections;

/*
Esse Exercício possui a utilização dos principais métodos do Lists.
 */

import java.sql.SQLOutput;
import java.util.*;

public class ExercicioLists {
    public static void main(String[] args) {

        //Parte 1
        System.out.println("Crie uma lista e adicione as sete notas: ");

        //Algumas formas de iniciar uma List, criar uma lista:

//      List notas = new ArrayList(); //antes do Java 5
//      List<Double> notas = new ArrayList<>();
        //Conceito de Generics (<preenchido>) e Diamond Operator - Java 7 (<> vazio)
//      ArrayList<Double> notas = new ArrayList<>(); não é recomendável
//        List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        // mais uma forma, onde já passamos os elementos
//        List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        //forma limitada porque depois não pode adicionar ou retirar
//        List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        //essa forma também torna a lista imutável, não é legal.

        List<Double> notas = new ArrayList<Double>(); //forma escolhida: Generics jDK5
        notas.add(7.0);
        notas.add(8.0);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas);
        //Podemos usar o método "toString" System.out.println(notas.toString); mas deu redundante

        //Parte 2
        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d));
        //O método IndexOf faz isso

        //Parte 3
        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);
        //O interessante é que ele não substitui a posição 4, ele empurrou a lista

        //Parte 4
        System.out.println("Substitua a nota 5.0 pela nota 7.0: ");
        //O método "set" faz isso. Ele precisa da posição e depois do elemento novo
        notas.set(notas.indexOf(5d), 7.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));
        // o método que faz isso é o "contains" passando o elemento que vc procura

        //Parte 5
        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        //Lists se mostra exatamente na ordem que a gente insere, então é só imprimir
        System.out.println(notas);

        //Parte 6
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        // método get exibe o elemento que está em determinada posição
        System.out.println(notas.toString());

        //Parte 7
        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        // Não existe um método que faz isso direto, então "Collections min" e a nossa collection que é a List

        //Parte 8
        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        //a mesma coisa do exemplo anterior

        //Parte 9
        System.out.println("Exiba a soma dos valores: ");
        //Mesma coisa, não existe um método de somar tudo. Vamos  usar o método Interator pra fazer isso, com laço
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma: " + soma);

        //Parte 10
        System.out.println("Exiba a média das notas: " + (soma/notas.size()));
        // o método size retorna a quantidade de elementos que tem na lista

        //Parte 11
        System.out.println("Remova a nota zero: ");
        //Existe o método remove - mas cuidado pra não remover a posição em vez do elemento
        notas.remove(0d);
        System.out.println(notas);

        //Parte 12
        System.out.println("Remova a nota da posição zero: ");
        // mesmo método remove, mas agora indica a posição. So não colocar o "d" de double do elemento
        notas.remove(0);
        System.out.println(notas);

        //Parte 13
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        //Faz uso do iterator e do remove em laço while
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //Parte 14
        System.out.println("Apague toda a lista: ");
        //existe um método pra isso, o clear
        notas.clear();
        System.out.println(notas);

        //Parte 15
        System.out.println("Confira se a lista está mesmo vazia: " + notas.isEmpty());
        //só usar o método isEmpty que retorna um verdadeiro ou falso
















    }

}
