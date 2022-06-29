package repositories;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FutsalWritingRepositoryTest {
  private Map<String, String> futsalTitleAndContent = new LinkedHashMap<>();

  @Test
  void getFusalPostTitle() {
    FutsalWritingRepository futsalWritingRepository
        = new FutsalWritingRepository();

    futsalWritingRepository.getFutsalWriting("안녕", "안녕하세요");
    assertEquals("안녕", futsalWritingRepository.getFutsalPostTitle());
  }

  @Test
  void getFutsalPostTitle() {

  }
}