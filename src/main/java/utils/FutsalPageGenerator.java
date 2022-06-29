package utils;

import frame.FutsalPostDetailFrame;
import frame.FutsalWriteFrame;
import frame.WriteFrame;
import models.Writing;
import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FutsalPageGenerator extends JPanel {
  private Writing writing;
  private FutsalWritingRepository futsalWritingRepository;

  private JLabel postTitle;


  public FutsalPageGenerator(FutsalWritingRepository futsalWritingRepository) {
//    this.writing = writing;
    this.futsalWritingRepository = futsalWritingRepository;

    setLayout(new GridLayout(3, 1));

    writingList();
    writeButton();
  }

  public void writingList() {
    for(String post : futsalWritingRepository.getFusalPostTitle()) {
      postTitle = new JLabel(post);

      postTitle.removeAll();
      this.add(postTitle);


      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame futsalPostdetailPage =
              new FutsalPostDetailFrame(futsalWritingRepository);
        }
      });
    }
  }

  public void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame futsalWriteFrame =
          new FutsalWriteFrame(futsalWritingRepository);
    });

    this.add(writeButton);
  }
}
