package compulsory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();

        Source s1 = new Source();
        s1.setNames("S1");
        s1.setSourceType(SourceType.FACTORY);
        Source s2 = new Source("S2", SourceType.WAREHOUSE);
        Source s3 = new Source("S3", SourceType.WAREHOUSE);

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");

        pb.setSources(new Source[]{s1, s2, s3});
        pb.setDestinations(new Destination[]{d1, d2, d3});
        pb.setDemands(new int[]{20, 25, 25});
        pb.setSupply(new int[]{10, 35, 25});
        pb.setCostMatrix(new int[][]{
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}});

        System.out.println(pb.toString());
    }
}