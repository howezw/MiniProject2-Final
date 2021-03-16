import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Egg {
  private Color color;
  private Contents contents;

  Egg() {
    color = randomColor();
    contents = randomContents();
  }

  Color getColor() {return color; }
  Contents getContents() {return contents; }

  private static final List<Color> COLOR_VALUES = Collections.unmodifiableList(Arrays.asList(Color.values()));
  private static final int COLOR_SIZE = COLOR_VALUES.size();

  private static final List<Contents> CONTENTS_VALUES = Collections.unmodifiableList(Arrays.asList(Contents.values()));
  private static final int CONTENTS_SIZE = CONTENTS_VALUES.size();

  private static final Random RANDOM = new Random();

  private Color randomColor() {
    return COLOR_VALUES.get(RANDOM.nextInt(COLOR_SIZE));
  }
  private Contents randomContents() {
    return CONTENTS_VALUES.get(RANDOM.nextInt(CONTENTS_SIZE));
  }
  void printEgg(){
    System.out.printf("%s egg contains %s%n", randomColor(), randomContents());
  }
}