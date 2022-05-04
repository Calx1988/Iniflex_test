package application;

import entities.Funcionario;
import util.MetodosEstaticos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws ParseException {
        List<Funcionario> funcionarioList = new ArrayList<>();


        // Inserção de valores na lista
        Funcionario f1 = new Funcionario("Maria",
                LocalDate.of(2000,10,18),
                new BigDecimal("2009.44"),
                "Operador");
        funcionarioList.add(f1);
        Funcionario f2 = new Funcionario("João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"),
                "Operador");
        funcionarioList.add(f2);
        Funcionario f3 = new Funcionario("Caio",
                LocalDate.of(1961,5,2),
                new BigDecimal("9836.14"),
                "Coordenador");
        funcionarioList.add(f3);
        Funcionario f4 = new Funcionario("Miguel",
                LocalDate.of(1988,10,14),
                new BigDecimal("19119.88"),
                "Diretor");
        funcionarioList.add(f4);

        Funcionario f5 = new Funcionario("Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista");
        funcionarioList.add(f5);
        Funcionario f6 = new Funcionario("Heitor",
                LocalDate.of(1999,11,19),
                new BigDecimal("1582.72"),
                "Operador");
        funcionarioList.add(f6);
        Funcionario f7 = new Funcionario("Arthur",
                LocalDate.of(1993,3,31),
                new BigDecimal("4071.84"),
                "Contador");
        funcionarioList.add(f7);
        Funcionario f8 = new Funcionario("Laura",
                LocalDate.of(1994,7,8),
                new BigDecimal("3017.45"),
                "Gerente");
        funcionarioList.add(f8);
        Funcionario f9 = new Funcionario("Heloísa",
                LocalDate.of(2003,5,24),
                new BigDecimal("1606.85"),
                "Eletricista");
        funcionarioList.add(f9);
        Funcionario f10 = new Funcionario("Helena",
                LocalDate.of(1996,9,2),
                new BigDecimal("2799.93"),
                "Gerente");
        funcionarioList.add(f10);
        // fim da inserção
        System.out.println("-----1ª impressão de funcionários");
        for (Funcionario f: funcionarioList) {System.out.println(f);}

        funcionarioList.removeIf(x -> Objects.equals(x.getNome(), "João"));
        System.out.println();
        System.out.println("-----2ª impressão de funcionários - João removido-----");
        for (Funcionario f: funcionarioList) {System.out.println(f);}

        for (Funcionario f: funcionarioList) {
            double amount = 1.1;
            BigDecimal valor = BigDecimal.valueOf(amount);
            f.setSalario(f.getSalario().multiply(valor));
        }

        HashMap<String, List<Funcionario>> map = new HashMap<>();
        for (Funcionario f: funcionarioList
             ) {
            map.put(f.getFuncao(),funcionarioList.stream().filter(x->x.getFuncao()==f.getFuncao()).toList());
        }
        System.out.println();
        System.out.println("-----Impressão Map-----");
        map.forEach((k,v) -> System.out.println(k + ": " + v));

        System.out.println();
        System.out.println("-----Funcionários aniversariantes mês 10 e 12-----");
        for (Funcionario f: funcionarioList) {
            if(f.getDataNascimento().getMonthValue()==10 || f.getDataNascimento().getMonthValue()==12 ){
                System.out.println(f);
            }
        }

        //Não consegui puxar apenas a informação do objeto na lista.
        //Tentei fazer um add em uma nova lista usando o stream abaixo, mas não deu certo.
        System.out.println();
        System.out.println("-----Funcionário mais velho-----");
        System.out.println(funcionarioList.stream().min(Comparator.comparing(Funcionario::calcularIdade)));
        System.out.println();
        System.out.println("-----Funcionários por ordem alfabética-----");
        Collections.sort(funcionarioList, Comparator.comparing(Funcionario::getNome));
        for (Funcionario f: funcionarioList) {System.out.println(f);}
        System.out.println();
        System.out.println("-----Soma dos salários-----");
        System.out.println(MetodosEstaticos.somaSalarios(funcionarioList));
        System.out.println();
        System.out.println("-----Salários mínimos de cada funcionário-----");
        MetodosEstaticos.calculateSalariosMinimos(funcionarioList)
                .forEach((k,v)-> System.out.println("Funcionário: " + k.getNome()
                        +" | Salários mínimos:  " + String.format("%.1f",v)));
    }
}
