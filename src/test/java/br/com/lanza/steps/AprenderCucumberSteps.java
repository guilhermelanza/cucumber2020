package br.com.lanza.steps;

import br.com.lanza.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

    private int contador = 0;

    @Dado("que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em (\\d+)$")
    public void euIncrementarEm(Integer int1) {
        contador = contador + int1;
    }

    @Então("o valor será (\\d+)$")
    public void oValorSerá(Integer int1) {
        //Assert.assertTrue(int1 == contador);
        Assert.assertEquals(new Double(int1), new Double(contador));
    }

    Date entrega = new Date();

    @Dado("que a entrega é dia (.*)$")
    public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) throws Throwable {
        System.out.println("---------------" + data);
        entrega = data;
    }

    @Quando("a entrega atrasar em (\\d+) dias$")
    public void aEntregaAtrasarEmDias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }

    @Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }
}
