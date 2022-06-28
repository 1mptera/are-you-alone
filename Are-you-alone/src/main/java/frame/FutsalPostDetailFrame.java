package frame;

import javax.swing.*;

public class FutsalPostDetailFrame extends JFrame {
  private final JFrame detailFrame;
  private JPanel panel;

  public FutsalPostDetailFrame() {

    detailFrame = new JFrame("상세 페이지");
    detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    detailFrame.setSize(800, 800);

    loadContent();

    detailFrame.setVisible(true);
  }

  public void loadContent() {
    panel = new JPanel();
    detailFrame.add(panel);
    panel.setLayout(null);


    panel.add(createContent());
    panel.add(createDeleteButton());
    panel.add(createModifyButton());
//    detailFrame.add(content);

//    content.setBounds(10,10,100,100);
//    panel.add(content);
  }

  public JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530,700,100,40);
    modifyButton.addActionListener(event -> {
      // 글 수정
    });
    return modifyButton;
  }

  public JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650,700,100,40);
    deleteButton.addActionListener(event -> {
      // 글 삭제
    });
    return deleteButton;
  }

  public JLabel createContent() {
    JLabel label = new JLabel("6/26 17:00 메가테라 스타디움에서 풋살 5:5 같이 " +
        "즐기실 분 010-xxxx-xxxx 연락부탁드립니다. ");
    label.setBounds(10,10,700,600);
    return label;
  }
}
