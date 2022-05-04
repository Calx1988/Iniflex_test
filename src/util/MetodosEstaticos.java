package util;

import entities.Funcionario;

import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MetodosEstaticos {
    public static String somaSalarios(List<Funcionario> list){
        double somaSalarios = 0;
        for (Funcionario f: list) {
            somaSalarios+=f.getSalario().doubleValue();
        }
        BigDecimal total = BigDecimal.valueOf(somaSalarios);
        return MetodosEstaticos.formatadorMoeda(total);
    }

    public static HashMap<Funcionario, Double> calculateSalariosMinimos(List<Funcionario> list){
        final BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        HashMap<Funcionario, Double> listaSalario = new HashMap<>();
        for(Funcionario f: list){
            double numeroSalariosMin = f.getSalario().doubleValue()/salarioMinimo.doubleValue();
            listaSalario.put(f, numeroSalariosMin);
        }
        return listaSalario;
    }

    public static String formatadorMoeda(BigDecimal value){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return currency.format(value);
    }
}
