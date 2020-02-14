package br.com.lanza.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumber {

    private int contador = 0;


    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador = contador + int1;
    }

    @Então("o valor será {int}")
    public void oValorSerá(Integer int1) {
        //Assert.assertTrue(int1 == contador);
        Assert.assertEquals(new Double(int1), new Double(contador));
    }

    Date entrega = new Date();
    @Dado("que a entrega é dia {int}\\/{int}\\/{int}")
    public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes-1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }

    @Quando("a entrega atrasar em {int} dias")
    public void aEntregaAtrasarEmDias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }

    @Então("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }
}
