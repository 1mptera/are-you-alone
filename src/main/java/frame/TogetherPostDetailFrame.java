package frame;


import repositories.TogetherWritingRepository;

import javax.swing.*;

public class TogetherPostDetailFrame extends JFrame {
  private final JFrame detailFrame;
  private final String post;
  private JPanel panel;
  private JLabel postContent;

  private TogetherWritingRepository togetherWritingRepository;

  public TogetherPostDetailFrame
      (TogetherWritingRepository togetherWritingRepository, String post) {
    this.togetherWritingRepository = togetherWritingRepository;
    this.post = post;

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
  }

  public JLabel createContent() {
    String title = togetherWritingRepository.getTogetherTitleKey(post);
    String post = String.valueOf
        (togetherWritingRepository.getTogetherPostContent(title));
    postContent = new JLabel(post);

    this.add(postContent);

    postContent.setBounds(10,10,700,600);

    return postContent;
  }

  public JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530,700,100,40);
    modifyButton.addActionListener(event -> {
      // 글 수정
      JFrame futsalWriteFrame =
          new TogetherWriteFrame(togetherWritingRepository);
      detailFrame.setVisible(false);
    });
    return modifyButton;
  }

  public JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650,700,100,40);
    deleteButton.addActionListener(event -> {
      // 글 삭제
      String title = togetherWritingRepository.getTogetherTitleKey(post);
      togetherWritingRepository.deleteTogetherWriting(title);

      detailFrame.setVisible(false);
    });
    return deleteButton;
  }
}