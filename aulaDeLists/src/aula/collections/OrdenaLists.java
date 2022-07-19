package aula.collections;

/*
Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
 */

import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaLists {
    public static void main(String[] args) {


        List<Gato> meusGatos = new ArrayList<>(){{
           add(new Gato("jon", 18, "preto"));
           add(new Gato("Simba", 6, "tigrado"));
           add(new Gato("jon", 12, "amarelo"));
        }};
        System.out.println(meusGatos);

        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);
        //Aqui precisei fazer modificações na classe Gato, para inserir a interface Comparable
        //Pois quero que a ordem "natural" seja por nome - ordem alfabética

        System.out.println("--\tOrdem Idade dos Gatos\t--");
        //Aqui a comparação será feita por idade segundo o Comparator
        //Porquê? Porque já usei o Comparable antes para o nome
        //Duas formas de escrever isso: por Collections ou usando a própria lista. Escolhi pela lista.
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem por cor\t--");
        //Novamente vai usar o comparator porque já foi usado o comparable com nome
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem por Nome, Cor e Idade\t--");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);

    }
}

/*Criação da classe gato. Poderia ser em outro documento, mas por ser pequena colocamos aqui mesmo.
Para criar uma classe eu fiz o primeiro bloco colocando os atributos private e suas tipologias,
depois com o atalho alt+insert eu fiz o Construtor (último bloco) e depois o Getter (bloco do meio).
e também o toString, deletando o nome "Gato" antes do colchete
pra imprimir só os elementos em vez do endereço de memória.
por último eu implementei uma interface Comparable.
 */

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }
/*
Lá na criação da classe eu inseri a interface Comparable e chamei o método dela que é o
"compareTo" obrigatoriamente. Como o método se refere a um Integer e a ordenação natural que quero é pelo nome,
ou seja, por String, foi necessário fazer um "compareToIgnoreCase - getNome".
 */

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {


    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome !=0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor !=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}