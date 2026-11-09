package br.com.fsync.jobs;

import br.com.fsync.forms.Index;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Marcus
 */
public class JobDescontoManual implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        Index.btGeral.doClick();
        Index.descontoManual();
        Index.btAtualizaVendas.doClick();
        Index.btEntregas.doClick();
        Index.btDevolucoes.doClick();
        Index.atualizaEstoquesCompleto();
        
        Index.taLog.append("DESCONTO MANUAL CALCULADO: " + sdf.format(new Date()) + "\n");
    }
}
