package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DimaK on 20.11.2014.
 */
class ServerFrame extends JFrame {

    private Map<Character, Integer> keys;

    private java.util.List<JComponent> components = new ArrayList<>();

    ServerFrame(Map<Character, Integer> keys) {
        this.keys = keys;

        setTitle("Server");

        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // do not stop server.
        setLocationRelativeTo(null);

        ((BorderLayout) getLayout()).setVgap(20);
    }

    public void updateKeys(Map<Character, Integer> keys) {
        this.keys = keys;

        try {
            EventQueue.invokeAndWait(() -> {
//                ServerFrame.this.removeAll();
                for (Component component : components) {
                    System.out.println("Remove component " + component);
                    component.getParent().remove(component);
                }
                components.clear();

                ServerFrame.this.revalidate();
            });
        } catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Removed all previous components, starting two new threads to create new components");

        // Make an update in separate threads.
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ChartBuilder());
        executorService.execute(new TableBuilder());
    }

    private class ChartBuilder implements Runnable {
        @Override
        public void run() {
            if (keys.isEmpty()) return;

            final JComponent chart = KeysChart.buildJFreeChart(keys);
            EventQueue.invokeLater(() -> {
                System.out.println("Create new chart");
                ServerFrame.this.add(chart, BorderLayout.CENTER);
                components.add(chart);
                ServerFrame.this.revalidate();
            });
        }
    }

    private class TableBuilder implements Runnable {
        @Override
        public void run() {
            if (keys.isEmpty()) return;

            final JComponent table = buildTable(keys);
            EventQueue.invokeLater(() -> {
                System.out.println("Create new table");
                ServerFrame.this.add(table, BorderLayout.SOUTH);
                components.add(table);
                ServerFrame.this.revalidate();
            });
        }
    }

    private static JComponent buildTable(Map<Character, Integer> keys) {

        Object[][] rowData = new Object[keys.size()][3];
        int cntr = 0;
        for (Map.Entry<Character, Integer> pair : keys.entrySet()) {
            rowData[cntr][0] = cntr + 1;
            rowData[cntr][1] = pair.getKey();
            rowData[cntr][2] = pair.getValue();
            cntr++;
        }

        JTable table = new JTable(rowData, new String[]{
                "#", "Key", "Count"
        });
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        return new JScrollPane(table);

    }
}
