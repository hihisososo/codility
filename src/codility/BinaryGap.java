package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

  public static void main(String[] args) {
    int N = 4;
    System.out.println(new Solution().solution(1041));
  }

  public int solution(int N) {
    String binaryRepresentation = getBinaryRep(N);
    return getMaxGap(binaryRepresentation);
  }

  private String getBinaryRep(int n) {
    if (n == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    while (n > 1) {
      sb.append(n % 2);
      n = n / 2;
    }
    sb.append("1");
    sb.reverse();
    System.out.println(sb.toString());
    return sb.toString();
  }

  private int getMaxGap(String rep) {
    List<Integer> list = new ArrayList<Integer>();
    int lastZeroIdx = -1;
    for (int i = 0; i < rep.length(); i++) {
      if (rep.charAt(i) == '0') {
        if (lastZeroIdx == -1) {
          lastZeroIdx = i;
        }
      } else {
        if (lastZeroIdx != -1) {
          list.add(i - lastZeroIdx);
          lastZeroIdx = -1;
        }
      }
    }
    if (list.size() == 0) {
      return 0;
    }
    Collections.sort(list,Collections.reverseOrder());
    return list.get(0);
  }
}
