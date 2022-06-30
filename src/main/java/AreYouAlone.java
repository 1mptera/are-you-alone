import repositories.BasketballWritingRepository;
import repositories.FutsalWritingRepository;
import repositories.TogetherWritingRepository;
import utils.BasketballPageGenerator;
import utils.FutsalPageGenerator;
import utils.MainPageGenerator;
import utils.TogetherPageGenerator;

import javax.swing.*;
import java.awt.*;

public class AreYouAlone {
  private JFrame frame;
  private JPanel contentPanel;

  private FutsalWritingRepository futsalWritingRepository;
  private BasketballWritingRepository basketballWritingRepository;
  private TogetherWritingRepository togetherWritingRepository;

  public static void main(String[] args) {
    AreYouAlone application = new AreYouAlone();

    application.run();
  }

  public void run() {
    futsalWritingRepository = new FutsalWritingRepository();
    basketballWritingRepository = new BasketballWritingRepository();
    togetherWritingRepository = new TogetherWritingRepository();

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

    panel.add(createLogo());
    panel.add(createMainButton());
    panel.add(createFutsalButton());
    panel.add(createBasketballButton());
    panel.add(createTogetherButton());
  }

  public JLabel createLogo() {
    return new JLabel("혼자왔니?");
  }

  public JButton createMainButton() {
    JButton button = new JButton("메인");
    button.addActionListener(event -> {
      JPanel mainPageGenerator = new MainPageGenerator();
      showFutsalConetnt(mainPageGenerator);
    });
    return button;
  }

  public JButton createFutsalButton() {
    JButton button = new JButton("풋살 매치");
    button.addActionListener(event -> {
      JPanel futsalPageGenerator =
          new FutsalPageGenerator(futsalWritingRepository);
      showFutsalConetnt(futsalPageGenerator);
    });
    return button;
  }

  public JButton createBasketballButton() {
    JButton button = new JButton("농구 매치");
    button.addActionListener(event -> {
      JPanel basketballPageGenerator =
          new BasketballPageGenerator(basketballWritingRepository);
      showFutsalConetnt(basketballPageGenerator);

    });
    return button;
  }

  public JButton createTogetherButton() {
    JButton button = new JButton("함께 해요");
    button.addActionListener(event -> {
      JPanel togetherPageGenerator = new TogetherPageGenerator(togetherWritingRepository);
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