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
public class JobFinalizacao implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        Index.rodaFinalizacaoEstoqueVenda();
        Index.taLog.append("VENDAS POR LABORATÓRIOS ATUALIZADAS: " + sdf.format(new Date()) + "\n");
    }
}
