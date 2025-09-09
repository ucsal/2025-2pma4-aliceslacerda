package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::createAndShowUI);
    }

    private static void createAndShowUI(){
        JFrame frame = new JFrame("Figure editor - AbstractFactory");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900,600);

        AbstractFigureFactory classic = new ClassicFigureFactory();
        AbstractFigureFactory pastel = new PastelFigureFactory();

        DrawingPanel canvas = new DrawingPanel(classic);

        JComboBox<String> factoryBox = new JComboBox<>(new String[]{
            "Clássico (preto)",
            "Pastel (tracejado)"
        });

        JComboBox<ShapeKind> shapeBox = new JComboBox<>(ShapeKind.values());
        JButton clearBtn = new JButton("Limpar");

        factoryBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                int idx = factoryBox.getSelectedIndex();
                canvas.setFactory(idx == 0 ? classic : pastel);
                  }
                      });
                 shapeBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                canvas.setShapeKind((ShapeKind) shapeBox.getSelectedItem());

            }
            });
            clearBtn.addActionListener (e -> canvas.clear());

            JToolBar toolbar = new JToolBar();
            toolbar.setFloatable(false);
            toolbar.add(new JLabel("Fabrica: "));
            toolbar.add (factoryBox);
            toolbar.addSeparator();
            toolbar.add(new JLabel("Forma: "));
            toolbar.add(shapeBox);
            toolbar.add(Box.createHorizontalStrut(10));
            toolbar.add(clearBtn);

            frame.setLayout(new BorderLayout());
            frame.add(toolbar, BorderLayout.NORTH);
            frame.add(canvas, BorderLayout.CENTER);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

}
}


