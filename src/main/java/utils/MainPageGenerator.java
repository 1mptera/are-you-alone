package utils;

import javax.swing.*;
import java.awt.*;

public class MainPageGenerator extends JPanel {
  public MainPageGenerator( ) {
    this.setLayout(new BorderLayout());
    JLabel main = new JLabel("1회성 팀 매칭 게시판 \"혼자왔니?\"");
    JLabel introduceTitle = new JLabel("\"혼자 왔니?\" 게시판이란? ");
    JLabel introduceContent = new JLabel("풋살, 농구 등 혼자 할 수 없는 스포츠를 즐기기 위해 하루만 " +
        "같이 팀이 되어 운동을 즐길 사람들을 모집하는 게시판이다 ");

    this.add((main), BorderLayout.NORTH);
    this.add((introduceTitle), BorderLayout.CENTER);
    this.add((introduceContent), BorderLayout.SOUTH);
    }
}
