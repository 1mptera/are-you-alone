package frame;

import models.Writing;
import repositories.FutsalWritingRepository;

import javax.swing.*;

public class FutsalPostDetailFrame extends JFrame {
  private final JFrame detailFrame;
  private JPanel panel;
  private JLabel postContent;

  private Writing writing;
  private FutsalWritingRepository futsalWritingRepository;

  public FutsalPostDetailFrame
      (FutsalWritingRepository futsalWritingRepository) {
    this.futsalWritingRepository = futsalWritingRepository;

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
    this.removeAll();
    String title = futsalWritingRepository.getFutsalTitleKey();
    String post = String.valueOf
        (futsalWritingRepository.getFutsalPostContent(title));
    postContent = new JLabel(post);
    this.add(postContent);

//    for(String post : writing.getPostContent()) {
//      postContent = new JLabel(post);
//      this.add(postContent);
//    }

    postContent.setBounds(10,10,700,600);

    return postContent;
  }

  public JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530,700,100,40);
    modifyButton.addActionListener(event -> {
      // 글 수정
        JFrame futsalWriteFrame =
            new FutsalWriteFrame(futsalWritingRepository);
        detailFrame.setVisible(false);
    });
    return modifyButton;
  }

  public JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650,700,100,40);
    deleteButton.addActionListener(event -> {
      // 글 삭제
      String title = futsalWritingRepository.getFutsalTitleKey();
      futsalWritingRepository.deleteFutsalWriting(title);

      detailFrame.setVisible(false);
    });
    return deleteButton;
  }
}