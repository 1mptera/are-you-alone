import utils.BasketballPageGenerator;
import utils.FutsalPageGenerator;
import utils.TogetherPageGenerator;

import javax.swing.*;
import java.awt.*;

public class AreYouAlone {
  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    AreYouAlone application = new AreYouAlone();
    application.run();
  }

  public void run() {
    frame = new JFrame("Are you alone?");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);

    navigationBar();
    pageContentPanel();

    frame.setVisible(true);
  }

  private void navigationBar() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createMainButton());
    panel.add(createFutsalButton());
    panel.add(createBasketballButton());
    panel.add(createTogetherButton());
  }

  public JButton createMainButton() {
    JButton button = new JButton("메인");
    button.addActionListener(event -> {

    });
    return button;
  }

  public JButton createFutsalButton() {
    JButton button = new JButton("풋살 매치");
    button.addActionListener(event -> {
      JPanel futsalPageGenerator = new FutsalPageGenerator();
      showFutsalConetnt(futsalPageGenerator);
    });
    return button;
  }

  public JButton createBasketballButton() {
    JButton button = new JButton("농구 매치");
    button.addActionListener(event -> {
      JPanel basketballPageGenerator = new BasketballPageGenerator();
      showFutsalConetnt(basketballPageGenerator);
    });
    return button;
  }

  public JButton createTogetherButton() {
    JButton button = new JButton("함께 해요");
    button.addActionListener(event -> {
      JPanel togetherPageGenerator = new TogetherPageGenerator();
      showFutsalConetnt(togetherPageGenerator);
    });
    return button;
  }

  public void pageContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void showFutsalConetnt(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
