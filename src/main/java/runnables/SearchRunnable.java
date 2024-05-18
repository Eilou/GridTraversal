package main.java.runnables;

import main.java.Search;
import main.java.Searches;

public class SearchRunnable implements Runnable{
    private Search search;

    public SearchRunnable(Search search) {
        this.search = search;
    }

    @Override
    public void run() {
        try {
            search.runSearch();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
