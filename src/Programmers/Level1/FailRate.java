package src.Programmers.Level1;

import java.util.*;
import java.util.stream.Stream;

public class FailRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,1,2,4,2,4,3,3};
        Arrays.stream(solution(N, stages)).forEach(a -> System.out.println(a));
    }
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> failRate = new HashMap<Integer, Double>();
        Arrays.sort(stages);
        int curStage = 1;
        int num = stages.length;
        while (curStage <= N) {
            int failNum = 0;
            for (int i = 0; i < stages.length; i++) {
                if (curStage < stages[i] || i == stages.length-1){ // 마지막이 3일 때 집계가 안 된다........
                    if(stages[i] == curStage) failNum += 1;
                    if (num == 0) {
                        failRate.put(curStage, (double) 0);
                    } else {
                        failRate.put(curStage, (double) failNum / num);
                    }

                    //System.out.println("curStage = " + curStage);
                    //System.out.println("num = " + num);
                    //System.out.println("failNum = " + failNum);
                    //System.out.println("failRate = " + failRate.get(curStage));
                    num -= failNum;
                    curStage += 1;
                    break;
                } else if (curStage == stages[i]){
                    failNum += 1;
                }
            }
        }

        List<Integer> keySetList = new ArrayList<>(failRate.keySet());
        Collections.sort(keySetList, (o1, o2) -> (failRate.get(o2).compareTo(failRate.get(o1))));
        return keySetList.stream().mapToInt(Integer::intValue).toArray();

    }
}
