package it.java.edu.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VeroTest {

    public static void main(String[] args) {
        List<String> result = bitPattern(Arrays.asList(1,3,2,3,4,1));
        System.out.println(result);

        System.out.println("mio res = "+ bitPattern2(Arrays.asList(1,3,2,3,4,1)));
        //bitPattern2(Arrays.asList(1,3,2,3,4,1));
    }

    public static List<String> bitPattern2(List<Integer> num) {

        String earlier="";
        String later="";
        boolean trovato=false;

        for (int i=0 ; i<num.size() ; i++) {
            for (int j=0 ; j<num.size() ; j++) {
                    if(num.get(i)==num.get(j) && j > i){
                        earlier+="0";
                        later+="1";
                        trovato=true;
                        break;
                    }else if(num.get(i)==num.get(j) && i > j){
                        earlier+="1";
                        later+="0";
                        trovato=true;
                        break;
                    }
            }
            if(!trovato){
                earlier+="0";
                later+="0";
            }
            trovato=false;
        }
        return Arrays.asList(earlier,later);
    }

    public static List<String> bitPattern(List<Integer> num) {
        int n = num.size();
        char[] earlier = new char[n];
        char[] later = new char[n];
        Arrays.fill(earlier, '0');
        Arrays.fill(later, '0');
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (seen.contains(num.get(i))) {
                earlier[i] = '1';
            }
            seen.add(num.get(i));
        }

        seen.clear();


        for (int i = n - 1; i >= 0; i--) {
            if (seen.contains(num.get(i))) {
                later[i] = '1';
            }
            seen.add(num.get(i));
        }
        System.out.println("earlier="+Arrays.toString(earlier) + " later="+Arrays.toString(later));
        return Arrays.asList(new String(earlier), new String(later));
    }




}
