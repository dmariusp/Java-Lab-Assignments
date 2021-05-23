package coloring;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class Greedy {
    private int maxDegree = 0;
    private Map<String, Integer> degrees;
    public Greedy(Map<String, Set<String>> friendship){
        init(friendship);
    }

    private void init(Map<String, Set<String>> friendship){
        degrees = new HashMap<>();

        for(Map.Entry<String, Set<String>>entry: friendship.entrySet()){
            String nod = entry.getKey();
            Set<String> vecini = entry.getValue();

            int degree = degrees.getOrDefault(nod, 0);
            int newDegree = degree + vecini.size();

            if(newDegree > maxDegree){
                maxDegree = newDegree;
            }
            degrees.put(nod, newDegree);

            for(String vecin: vecini){
                degree = degrees.getOrDefault(vecin, 0);
                newDegree = degree + 1;

                if(newDegree > maxDegree){
                    maxDegree = newDegree;
                }
                degrees.put(vecin, newDegree);
            }
        }
    }

    public int minimColor(){
        int minim = degrees.size();
        for(String user: degrees.keySet()){
            int degree = degrees.get(user);
            if(degree < minim){
                minim = degree;
            }
        }
        return minim;
    }




}
