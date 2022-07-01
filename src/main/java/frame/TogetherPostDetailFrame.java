package frame;


import repositories.TogetherWritingRepository;

import javax.swing.*;

public class TogetherPostDetailFrame extends JFrame {
  private final JFrame detailFrame;
  private final String post;
  private JPanel panel;
  private JLabel postContentLabel;

  private TogetherWritingRepository togetherWritingRepository;
  private String postContent;

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
    postContent = String.valueOf
        (togetherWritingRepository.getTogetherPostContent(title));
    postContentLabel = new JLabel(postContent);

    this.add(postContentLabel);

    postContentLabel.setBounds(10,10,700,600);

    return postContentLabel;
  }

  public JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530,700,100,40);
    modifyButton.addActionListener(event -> {
      panel.removeAll();

      JButton internalModifiyButton = new JButton("수정하기");
      internalModifiyButton.setBounds(650,700,100,40);
      panel.add(internalModifiyButton);

      JTextField titleBox = new JTextField(20);
      titleBox.setText(post);
      titleBox.setBounds(50,10, 700, 40);
      panel.add(titleBox);

      JTextArea contentBox = new JTextArea();
      contentBox.setText(postContent);
      contentBox.setBounds(50,60,700, 600);
      panel.add(contentBox);

      panel.setVisible(false);
      panel.setVisible(true);

      modify(internalModifiyButton, titleBox);
    });
    return modifyButton;
  }

  public void modify(JButton internalModifiyButton, JTextField titleBox) {
    internalModifiyButton.addActionListener(event1 -> {

      // 글 수정 입력 받기
      String modifiedPostTitle = titleBox.getText();
      String modifiedPostContent = titleBox.getText();

      togetherWritingRepository.getTogetherWriting(modifiedPostTitle,
          modifiedPostContent);

      // 입력 받은 제목과 내용을 저장소에서 기존 값과 변경하기
      togetherWritingRepository.changeTogetherWriting(post, modifiedPostTitle,
          modifiedPostContent);

      // 기존 제목은 저장소에서 삭제
      togetherWritingRepository.deleteTogetherWriting(post);

      detailFrame.setVisible(false);
    });
  }

  public JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650,700,100,40);
    deleteButton.addActionListener(event -> {
      String title = togetherWritingRepository.getTogetherTitleKey(post);
      togetherWritingRepository.deleteTogetherWriting(title);

      detailFrame.setVisible(false);
    });
    return deleteButton;
  }
}
