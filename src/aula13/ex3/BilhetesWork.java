package aula13.ex3;

import java.util.LinkedList;
import java.util.List;

public class BilhetesWork {

    private int indice = 0;
    private String[] workers;

    public BilhetesWork(String[] workers) {
        this.workers = workers;
    }

    public List<String> giveTickets(int N) {
        List<String> awardedWorkers = new LinkedList<>();
        for(int i = 1; i <= N; i++) awardedWorkers.add(giveTicket());
        return awardedWorkers;
    }

    private String giveTicket() {
        indice = (indice + 1) % workers.length;
        return workers[indice];
    }
}
