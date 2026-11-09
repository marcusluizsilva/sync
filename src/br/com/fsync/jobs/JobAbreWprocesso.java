package br.com.fsync.jobs;

import javax.swing.JOptionPane;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Marcus
 */
public class JobAbreWprocesso implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            Runtime.getRuntime().exec("C://wprocesso.bat");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex, "LandA", JOptionPane.ERROR_MESSAGE);
        }
    }
}
