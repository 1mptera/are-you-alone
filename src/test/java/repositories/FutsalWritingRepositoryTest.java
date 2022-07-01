package repositories;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FutsalWritingRepositoryTest {
  private Map<String, String> futsalTitleAndContent = new LinkedHashMap<>();
  private FutsalWritingRepository futsalWritingRepository;

  @Test
  void getFusalPostTitle() {
    futsalWritingRepository = new FutsalWritingRepository();

    futsalWritingRepository.getFutsalWriting("안녕", "안녕하세요");
    assertEquals("안녕", futsalWritingRepository.getFutsalPostTitle());
  }

  @Test
  void deleteFutsalWriting() {
    futsalWritingRepository = new FutsalWritingRepository();

    futsalWritingRepository.getFutsalWriting("축구", "축구할사람");
    futsalWritingRepository.getFutsalWriting("농구", "농구할사람");
    futsalWritingRepository.getFutsalWriting("야구", "야구할사람");

    futsalWritingRepository.deleteFutsalWriting("농구");
    assertEquals("축구, 야구",futsalWritingRepository.getFutsalPostTitle());
  }

  @Test
  void changeTitleKey() {
    futsalWritingRepository = new FutsalWritingRepository();

    futsalWritingRepository.getFutsalWriting("축구", "축구할사람");
    futsalWritingRepository.getFutsalWriting("농구", "농구할사람");

    futsalWritingRepository.changeFutsalWriting("축구", "야구", "야구할사람");
  }
}