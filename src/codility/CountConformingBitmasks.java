package codility;

import java.util.HashSet;

class CountConformingBitmasks {

  public static void main(String[] args) {
    System.out.println(new CountConformingBitmasks().solution(1073741727, 1073741631, 1073741679));
  }

  public int solution(int A, int B, int C) {
    String aBit = Integer.toBinaryString(A);
    String bBit = Integer.toBinaryString(B);
    String cBit = Integer.toBinaryString(C);

    HashSet<String> conforms = new HashSet<>();
    addConforms("", aBit, conforms);
    addConforms("", bBit, conforms);
    addConforms("", cBit, conforms);

    return conforms.size();
  }

  private void addConforms(String prefix, String suffix, HashSet<String> conforms) {
    for (int i = 0; i < suffix.length(); i++) {
      if (suffix.charAt(i) == '0') {
        addConforms(prefix + '0', suffix.substring(i + 1), conforms);
        addConforms(prefix + '1', suffix.substring(i + 1), conforms);
      }
      prefix += suffix.charAt(i);
    }
    conforms.add(prefix);
  }
}