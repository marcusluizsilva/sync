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
public class JobSyncMov implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        Index.listaDepositos();
        Index.syncMov();
        Index.btEntregas.doClick();
        Index.btBalanco.doClick();
        Index.atualizaListaFidelidade();
        //Index.geraBI60Dias();
        Index.taLog.append("MOV sincronizado: " + sdf.format(new Date()) + "\n");
    }
}
